package labe;

public class CharacterRogue extends GameCharacter {
    private String weapon="knife";
    public CharacterRogue (String characterName, int attackPriority){
        super(characterName, "rogue", attackPriority, 10);
    }
    public String getWeapon() {
        return weapon;
    }

    @Override
    public String talk(String message) {
        return "....(" + message + ")....";
    }
    @Override
    public String getAttackMessage() {
        String returnMsg = this.getCharacterName() + " attacks with their " + this.weapon + ".";
        return returnMsg;
    }
}
