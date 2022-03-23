import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ArgFileNotFoundException extends Exception {
    public ArgFileNotFoundException(String fn){
        super("The file" + fn+"could not be found");
    }
    public ArgFileNotFoundException() {
        super();
    }
}
