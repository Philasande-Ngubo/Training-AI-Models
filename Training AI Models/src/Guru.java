/**
 * This is a static helper class it contains general methods to be used in conjuction with other Classes
 * @author Philasande Ngubo(NGBPHI016)
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Guru{
    
	private Guru(){}

    /**
     * String to Stratement Data type should be in the form
     * term \t description \t confidence score
     * @return Statemenent made from string
     * @param statement
     * String statement
     */
	public static Statement toStatement(String statement) {
		Scanner myScanner = new Scanner(statement);
		myScanner.useDelimiter("\t");
		String term = myScanner.next();
		String sentence=myScanner.next();
		double score= Double.parseDouble(myScanner.next());
        return new Statement(term ,sentence ,score);
    
	}

	private static boolean isDouble(String test){
		try{
			double d = Double.parseDouble(test);
		}
		catch(NumberFormatException nfe){
			return false;
		}
        return true;
	}
    /**
     * makes a string to sentence format start with Caps and 
     * end with a fullstop
     * @return String Formatted as a sentence
     * @param temp
     * String of words
     */
	public static String toSentenceFormat(String temp){
		String result,stemp;
		result =""+temp.charAt(0);
        result = result.toUpperCase();
		stemp =temp;
		if (! (stemp.charAt(stemp.length() -1) == '.') ){
			stemp+=".";
		}
		result += ((new StringBuilder(stemp)).delete(0,1)).toString();
		return result;

	}


}