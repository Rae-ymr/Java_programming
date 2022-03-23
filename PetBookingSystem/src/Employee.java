public class Employee {
    private String name;
    private final String IDNUMBER;
    private String managerID;
    private Employee[] supervisedEmployees = new Employee[10];

    public Employee(String name, String idNumber){
        this.name = name;
        this.IDNUMBER = idNumber;
    }
    public Employee(String name, String idNumber, String managerID){
        this.name = name;
        this.IDNUMBER = idNumber;
        this.managerID = managerID;
    }
    public addEmployee(Employee newEmployee){
        for (int i = 0;i< supervisedEmployees.length;i++){
            if(this.supervisedEmployees[i]==null){
                this.supervisedEmployees[i]=new ;
                break;
            }
        }

    }


}
