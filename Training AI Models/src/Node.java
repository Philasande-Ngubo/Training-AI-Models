/**
 * The node of  a binary search tre
 * @author Philasande Ngubo
 */
public class Node{
	Statement data;
	Node right;
	Node left;
/** Constructs a Node
 */
public Node(Statement data){
 this.data = new Statement(data);
 this.right = null;
 this.left = null;
}


}