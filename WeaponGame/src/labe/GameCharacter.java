package labe;

import java.util.Locale;

import java.util.*;
abstract class GameCharacter {
    public GameCharacter(String characterName, String characterClass, int attackPriority, int attackDamage) throws IllegalArgumentException {
        this.characterName=characterName;
        this.CHARACTER_CLASS=getValidCharacterClass(characterClass);
        this.ATTACK_PRIORITY=attackPriority;
        this.ATTACK_DAMAGE=attackDamage;
        this.validateAndRecordAttackPriority(attackPriority);
    }

    enum CharacterClasses{

        WARRIOR{

            public String asString(){
                return WARRIOR.toString().substring(0,1)+WARRIOR.toString().substring(1).toLowerCase(Locale.ROOT);
            }
        },
        HEALER{

            public String asString(){
                return WARRIOR.toString().substring(0,1)+WARRIOR.toString().substring(1).toLowerCase(Locale.ROOT);
            }
        },
        ROGUE{

            public String asString(){
                return WARRIOR.toString().substring(0,1)+WARRIOR.toString().substring(1).toLowerCase(Locale.ROOT);
            }
        };
        public abstract String asString();
    }
    protected String characterName;
    protected CharacterClasses CHARACTER_CLASS;
    protected int ATTACK_PRIORITY;
    protected int ATTACK_DAMAGE;
    protected int lifeforce = 100;
    static TreeSet<Integer> attackPriorities = new TreeSet<Integer>();
    public String getCharacterName() { return this.characterName; }
    public void setLifeforce(int points){this.lifeforce=points;}
    public Integer getLifeforce(){return this.lifeforce;}
    public Integer getAttackPriority(){return this.ATTACK_PRIORITY;}
    public Integer getAttackDamage(){return this.ATTACK_DAMAGE;}
    public String getCharacterClass(){
        String theEnum=CHARACTER_CLASS.name();
        return CharacterClasses.valueOf(theEnum).asString();
    }
    public abstract String talk(String message);
    public abstract String getAttackMessage();
    public void validateAndRecordAttackPriority(int priority) throws IllegalArgumentException {
        Integer priorityInteger=Integer.valueOf(priority);
        if (attackPriorities.contains(priority)){
            throw new IllegalArgumentException("Attack priority must be unique within the game; " +
                    priority + " is already in use.");
        }
        attackPriorities.add(priorityInteger);
    }
    private CharacterClasses getValidCharacterClass(String name) {
        name=name.toUpperCase();
        if (name.equals("WARRIOR")) {
            return CharacterClasses.WARRIOR;
        } else if (name.equals("HEALER")) {
            return CharacterClasses.HEALER;
        }
        return CharacterClasses.ROGUE;

    }

}
