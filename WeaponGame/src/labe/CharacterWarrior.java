package labe;

import java.util.ArrayList;

public class CharacterWarrior extends GameCharacter{
    private ArrayList<String> weapons=new ArrayList(2);
    public CharacterWarrior(String characterName, int attackPriority) throws IllegalArgumentException{
        super(characterName, "warrior", attackPriority, 20);
        this.weapons.add("sword");

    }
    public CharacterWarrior(String characterName, int attackPriority, String weapon) throws IllegalArgumentException {
        super(characterName, "warrior", attackPriority, 12);
        this.weapons.add("sword");
        this.weapons.add("weapon");
    }

    public CharacterWarrior(String characterName, int attackPriority, String weapon1, String weapon2) throws IllegalArgumentException {
        super(characterName, "warrior", attackPriority, 12);
        this.weapons.add("weapon1");
        this.weapons.add("weapon2");
    }

    @Override
    public String talk(String message) {
        message = message.replaceAll("\\.", "!!!!!");
        return message.toUpperCase();
    }
    public String getWeapons() {
        String allWeapons = "";
        for (int i=0; i<weapons.size(); i++) {
            if (weapons.get(i) == null) { break; }
            allWeapons = allWeapons + weapons.get(i) + " and ";
        }
        allWeapons = allWeapons.replaceAll(" and $", "");
        return allWeapons;
    }
    @Override
    public String getAttackMessage() {
        String returnMsg = this.getCharacterName() + " attacks with their " + this.getWeapons() + ".";
        return returnMsg;
    }
}
