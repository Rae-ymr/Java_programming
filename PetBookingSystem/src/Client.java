public class Client {
    private final String name;
    private final String phoneNumber;
    private final String address;
    private RewardsProfile rewardsInfo;
    public Client(String name,String phoneNumber,String address,RewardsProfile rewardsInfo){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.rewardsInfo=rewardsInfo;
    }

    public boolean enrollRewards(String newNumber) throws InvalidRewordsNumException {
        try{
            this.rewardsInfo=new RewardsProfile(newNumber);
            return true;
        }
       catch(InvalidRewordsNumException e){
            return false;
       }

    }
    public int getRewardsPoints(){
        return this.rewardsInfo.getPoints();
    }
}
