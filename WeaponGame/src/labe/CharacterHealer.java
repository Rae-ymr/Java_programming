package labe;
public class CharacterHealer extends GameCharacter {
    private String weapon = "bare hands";

    public CharacterHealer(String characterName, int attackPriority) throws IllegalArgumentException {
        super(characterName, "healer", attackPriority, 1);
    }

    public String getWeapon() {
        return weapon;
    }

    @Override
    public String talk(String message) {
        return message;
    }

    @Override
    public String getAttackMessage() {
        String returnMsg = this.getCharacterName() + " attacks with their " + this.weapon + ".";
        return returnMsg;
    }
}