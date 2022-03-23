/*
Copyright Ann Barcomb and Emily Marasco, 2022
Licensed under GPL v3
See LICENSE.txt for more information.
*/

import java.sql.*;

public class Registration{

    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    
    private Connection dbConnect;
    private ResultSet results;
    
    public Registration(String url, String user, String pw){

        // Database URL
        this.DBURL = url;

        //  Database credentials
        this.USERNAME = user;
        this.PASSWORD = pw;
    }


//Must create a connection to the database, no arguments, no return value    
    public void initializeConnection() throws SQLException {
        try{
            dbConnect=DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);

        }
        catch(SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        }

    }
    
    String getDburl(){
        return this.DBURL;
    }

    String getUsername(){
        return this.USERNAME;
    }
    
    String getPassword(){
        return this.PASSWORD;
    }

    
    public String selectAllNames(String tableName) throws SQLException {
        StringBuffer lf=new StringBuffer();
        String sql = "SELECT * FROM " + tableName;    //要执行的SQL
        Statement stmt = dbConnect.createStatement();
        ResultSet rs = stmt.executeQuery(sql);//创建数据对象
        while(rs.next()){
//            System.out.println("Last name"+rs.getString("LName")+"First name"+rs.getString("FName"));
            lf.append(rs.getString("LName")+","+rs.getString("FName"));
        }
        stmt.close();
        return lf.toString();
    }
    
    
    public void insertNewCompetitor(String id, String lName, String fName, int age, String instrument, String teacherID){
        if(!validateTeacher(teacherID)){
            throw new IllegalArgumentException("Student must have a registered teacher.");
        }

        if(age < 5 || age > 18){
            throw new IllegalArgumentException("Student must be between the ages of 5 and 18.");
        }
        try {

            String query = "INSERT INTO competitor (CompetitorID, LName, FName, Age, Instrument, TeacherID) VALUES (?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, id);
            myStmt.setString(2, lName);
            myStmt.setString(3, fName);
            myStmt.setInt(4, age);
            myStmt.setString(5, instrument);
            myStmt.setString(6, teacherID);

            int rowCount = myStmt.executeUpdate();

            myStmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

/***********ADD CODE HERE***********/                


    }    

    
// Used to ensure that any new students are connected to an existing teacher    
    private boolean validateTeacher(String teacherID){
        
        boolean validTeacher = false;
                    
        try {                    
            Statement myStmt = dbConnect.createStatement();
            
            // Execute SQL query
            results = myStmt.executeQuery("SELECT * FROM teacher");
            
            // Process the results set
            while (results.next()){
                if(results.getString("TeacherID").equals(teacherID))
                    validTeacher = true;
            }
            
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return validTeacher;

    }    
    
 
    public void deleteCompetitor(String id){
        try {
            String query = "DELETE FROM competitor WHERE CompetitorID = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, id);

            int rowCount = myStmt.executeUpdate();

            myStmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

/***********ADD CODE HERE***********/                


    }    

    public void close() {
        
/***********ADD CODE HERE***********/                

    }
    
    public static void main(String[] args) throws SQLException {

		// Remember that each time you execute the given .sql file, the database will be reset. 
		// You should reset the database before each test run of your code.

        //Use the following account information: Username = student, Password = ensf
        Registration myJDBC = new Registration("jdbc:mysql://localhost/competition","root","19980430");
        
        //1 mark - initializeConnection method must create a connection to the database, may not take in any arguments or return any values
        // Must throw an SQLException if connection cannot be made
        myJDBC.initializeConnection();
                
        //2 marks - returns a String of competitors/teachers where each lastName, firstName is on a new line with no new line at the end
        //Must take in a String for the table name and return a String (mark deducted if incorrect)
        //-1 if the content of the competitors list is incorrect
        //-1 if the content of the teachers list is incorrect
        System.out.println("------------------------------");
        System.out.println("***Printing list of competitors:***");
        System.out.println(myJDBC.selectAllNames("competitor"));
        System.out.println("------------------------------");
        System.out.println("***Printing list of teachers:***");
        System.out.println(myJDBC.selectAllNames("teacher"));
        /*
        Example format:
        Williams, Sophie
        Warren, Harper
        */

        System.out.println("------------------------------");
        System.out.println("***Now testing insert statements...***");                
        //2 marks - inserts a new competitor into the database
        //Six arguments that match the competitor table, no return value (mark deducted if incorrect)
        //Check to make sure the database has been updated with a new competitor        
        myJDBC.insertNewCompetitor("234", "Robertson", "Ebba", 15, "Trombone", "0023");
        System.out.println("Competitor #234 Robertson, Ebba should now be added.");

        //1 mark - insertion should fail and throw an IllegalArgumentException because the new student's teacher is not already registered in the database
        //Check to make sure the competitor was not added
        try{
            myJDBC.insertNewCompetitor("678", "Jordan", "Ali", 10, "Oboe", "9807");
        }catch(IllegalArgumentException e){
            System.out.println("Sucessfully threw exception when no registered teacher can be found for a competitor.");
        }
        
        //1 mark - insertion should fail and throw an IllegalArgumentException because the new student is outside of the valid age range
        //Check to make sure the competitor was not added
        try{
            myJDBC.insertNewCompetitor("654", "Smyth", "Ace", 4, "Oboe", "1012");
        }catch(IllegalArgumentException e){
            System.out.println("Sucessfully threw exception when competitor is outside valid age range.");
        }
        
        System.out.println("------------------------------");
        System.out.println("***Now testing delete statements...***");                        
        //1 mark - deletes the specified competitor from the database
        //Must take in the competitor's id as a String, no return value (mark deducted if incorrect)
        //Check to make sure the competitor was deleted (no need for cascade or error checking within the rest of the database)
        myJDBC.deleteCompetitor("205");
        System.out.println("Competitor #205 Kamilla, Mala should now be deleted.");

        //1 mark - Answer the following question in your demonstration:
        //What data conflicts might arise when we try to delete an existing teacher?
        
        //1 mark - must show where all Statement, ResultSet, and Connection objects are closed.
        myJDBC.close();
        System.out.println("------------------------------");
        System.out.println("***End of tests.***"); 
    }
}


