import java.io.*;
import java.util.*;
import java.util.regex.*;
public class TranslationText implements Serializable {
    static final long serialVersionUID = 19L;
    String[] months = new String[12];
    String[] days = new String[31];
    String sentence;
    TranslationText(String[] months, String[] days, String sentence) {
        this.months = months;
        this.days = days;
        this.sentence = sentence;
    }
    public String getSentence() {
        return this.sentence;
    }
    public String[] getMonths() {
        return this.months;
    }
    public String[] getDays() {
        return this.days;
    }
    public String getMonth(int index) {
        return this.months[index];
    }
    public String getDay(int index) {
        return this.days[index];
    }
    public void printSentence() {
        System.out.println("Sentence: "+sentence);
    }
    public void printMonths() {
        System.out.println("Months");
        for (int i = 0; i < months.length; i++) {
            System.out.println(months[i]);
        }
    }
    public void printDays() {
        System.out.println("Days");
        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i]);
        }
    }


}
/* TranslationText
 * Serializable representation of the data file. Has the serialVersionUID of 19.
*/

  /* getSentence()
   * Getter method, returns String
  */


  /* getMonths()
   * Getter method, returns String[]
  */

  /* getDays()
   * Getter method, returns String[]
  */

  /* getMonth()
   * Accepts an integer 0-11 corresponding to an index in the months array,
   * and returns the value at that index. (e.g., 0 = January)
  */

  /* getDay()
   * Accepts an integer 0-30 corresponding to an index in the day array,
   * and returns the value at that index. (e.g., 30 = 31st)
  */

  /* Constructor
   * Accepts a String array of months, a String array of days, and a String 
   * containing a sentence with formatting.
  */

