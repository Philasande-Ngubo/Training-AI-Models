import java.io.*;
/**
 * This DataQuery class allows to share 
 * GUI between different Data structures and apps  
 * @author Philasande Ngubo
 */
public abstract class DataQuery{
	protected File baseKnolwegde;
	public DataQuery(){

	}
	/**
	 * adds a Statement to the specific data struture
	 * @param statement 
	 * the string containing the statement
	 */
	public abstract void add(String statement);
	/**
	 * searches for a Statement by term to return 
	 * @param item
	 * Item being searched
	 */
	/**
	 * Updates term
	 * @param term
	 * String for the term
	 * @param sentence
	 * String for the term
	 * @param score 
	 * Float for the new confidence score
	 */
	public abstract void update(String term, String sentence,double score);
	/**
	 * Searches for a statement
	 * @return Statement searched for or null if absent 
	 * @param item
	 * Item being searched
	 */
	public abstract Statement search(String item);
	/**
	 * Searches for a statement
	 * @return Statement searched for or null if absent 
	 * @param item
	 * Item being searched
	 * @param sentence
	 * sentence of the item being searched
	 */
	public abstract Statement search(String item,String sentence);
	/**
	 * Updates made saved to the datafile
	 */
	public abstract void post();
	/**
	 * loads the file to the knowlegde base
	 */
	public abstract void load();
	/**
	 * Updates file in the used
	 */
	/**
	 * Suggest terms similar to the one being searched
	 * @return suggestions for the searched item
	 * @param trial
	 * the word to compile suggestion for
	 */
	public abstract String[] compileSug(String trial);
	/** Sets the file the  program is gonna work with
	 * @param file
	 * The file for in File object type
	 */
	public void updateFile(File file){
      baseKnolwegde = file;
	}
	/** Get the filename 
	 *  @return Filename initialised
	 */
	public String getFileName(){
		return baseKnolwegde.getName();
	}
}