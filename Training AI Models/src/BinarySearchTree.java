import java.util.ArrayList;
/**
 * My implementation of the binary Search Tree
 *@author Philasande Ngubo
 */
public class BinarySearchTree{
	Node root;
    ArrayList<String> list = new ArrayList();
    /** Constructor Makes 
     * An empty binary Tree
     */
	public BinarySearchTree(){
		root = null;
	}

    /** Insert a statement
     * into a binary search tree
     * @param data
     * Statement to insert
     */

	public void insert(Statement data) {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node root, Statement data) {
    	if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data.term().hashCode() < root.data.term().hashCode()) {
            root.left = insertRec(root.left, data);
        } else if (data.term().hashCode() > root.data.term().hashCode()) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }
    
    /**
     * The node containing the queried data or null if absent
     *  @return Node with the searched term or null if not present
     * @param root 
     * the root node
     * @param term
     * the term of the statement searched for
     */
    public Node search(Node root, String term) {
        if (root == null || root.data.term().equals(term)) {
            return root;
        }

        if (term.hashCode() < root.data.term().hashCode()) {
            return search(root.left, term);
        }

        return search(root.right, term);
    }

   private void inorder() {
    list.clear();
    inorderRec(root);
  }

  private void inorderRec(Node root) {
    if (root != null) {
      inorderRec(root.left);
      list.add(root.data.term());
      inorderRec(root.right);
    }
  }
  
  /**
   * An array of terms matching the substring item
   * @return an array of suggested terms matching the one searched
   * @param item
   * the substring looked for
   */
  public String[] getSuggestions(String item){
     inorder();
     int count = 0;
     for (String term:list){
        if (  term.trim().toLowerCase().indexOf(item.trim().toLowerCase()) >-1 ){
        count++;
           }
     }
     String[] results = new String[count]; 

     int i = 0 ;
     for (String term : list){
        if ( term.trim().toLowerCase().indexOf(item.trim().toLowerCase()) > -1 )  {
         results[i++] = term;
           }
         
     }

    return results;
  }



}