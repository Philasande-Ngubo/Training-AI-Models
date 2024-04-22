import java.util.Scanner;
/** Binary Search Tree class
 * Provides methods to manipulate a Binary search tree to
 * achieve the features specified by the abstract class  DataQuery
 * @author Philasande Ngubo
 */
public class BinarySearchTreeBase extends DataQuery{
	BinarySearchTree base = new BinarySearchTree();

	public BinarySearchTreeBase(){
   	super();
   }
   @Override
   public void add(String statement){
   	try{
   	base.insert(Guru.toStatement(statement));
    }
    catch (Exception e){}

   }

   @Override
   public void update(String term, String sentence,double score){
   	 Statement temp = base.search(base.root,term).data;
     temp.update(sentence,score);
   }

   @Override
   public Statement search(String item){
   	  if (base.search(base.root,item) == null){
   	  	return null;
   	  }
      return base.search(base.root,item).data;
   }

   @Override

   public Statement search(String item,String sentence){

   	Statement temp = search(item);
   	if (temp == null){
   		return null;
   	}
   	if ( sentence.equals("")){
   		return null;
   	}
   	if ( ! (temp == null)){
		if ( temp.sentence().trim().toLowerCase().indexOf(sentence.trim().toLowerCase()) == -1 ){
			 temp = null;

		}
   	}
     return temp;
   }
   @Override

   public void post(){
      System.out.println("");
   }

   @Override
   public void load(){
   	try{
   	   Scanner reader = new Scanner(super.baseKnolwegde);
       Statement temp;
       while (reader.hasNextLine() ){
         temp =Guru.toStatement(reader.nextLine() );
       	 base.insert( temp );
       }

      }
       catch(Exception e){}

   }

   @Override
   public String[] compileSug(String trial){
   	return base.getSuggestions(trial);
   }


}