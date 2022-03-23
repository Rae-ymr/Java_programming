public class RewardsProfile {
    private final String newNumber;
    private int pointsTotal = 10;

    public RewardsProfile(String newNumber) throws InvalidRewordsNumException {
        String validNum = "^\\d{7}$";
        if (newNumber.matches(validNum)) {
            this.newNumber = newNumber;
        } else
            throw new InvalidRewordsNumException();
    }
    public int getPoints(){
        return pointsTotal;
    }
}

