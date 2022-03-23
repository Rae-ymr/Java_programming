package labe;

import java.util.ArrayList;
import java.util.Iterator;

public class PrintHTML implements PrintOutput{
    public void printStats(GameCharacter theCharacter) {
        String characterName = theCharacter.characterName;
        String characterClass = theCharacter.getCharacterClass();
        System.out.println("<p>Name: " + characterName + "<br />");
        System.out.println("Life: " + theCharacter.lifeforce + "<br />");
        System.out.println("Class: " + characterClass + "<br />");
        System.out.println("Says: " + theCharacter.talk("I am " + characterName + " the " + characterClass + ".") + "<br />");
        System.out.println("Attack speed: " + theCharacter.getAttackPriority() + "<br />");
        System.out.println("Damage: " + theCharacter.getAttackDamage() + "<br />");
        System.out.println("Attack: " + theCharacter.getAttackMessage() + "</p>");
    }
    public void printFightLog(ArrayList<String> log){
        Iterator<String> x= log.iterator();
        System.out.println("<ul>");
        while(x.hasNext()){
            System.out.println("<li>" + x.next() + "</li>");
        }
        System.out.println("<ul>");
    }

}
