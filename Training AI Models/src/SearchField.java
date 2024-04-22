import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
/**
 * This is a panel containing a textfield
 * and a search button 
 * Creating an illusion of buttoned Text Field
 * @author Philasande Ngubo
 */ 
public class SearchField extends JPanel{
	private JTextField textField;
	private coButton img;
	private ImageIcon pic;
	private JFrame container = null;

    /** Constructor 
     *  @param width
     *  Integer width
     * @param hol
     * The container
     */
    public SearchField(int width,JFrame hol){
		this(width);
		container = hol;
  
	}
	/** Constructor 
	 * makes a textField with an image 
	 * @param width 
	 * the width of the TextField
	 */
	public SearchField(int width){
	  super();
	  setLayout(null);
      textField = new JTextField();
      setPreferredSize(new Dimension(width, 60));
      textField.setBounds(0,0,width-57,60);
      add(textField);
      textField.setForeground(new Color(58,66,103));
      textField.setFont(new Font("Arial", Font.BOLD,20));
      pic = new ImageIcon("search.jpg");
      img = new coButton("search",container);
      coButton.buttonToLabel(img);
      img.setBounds(width-57,0,57,60);
      img.setBorder(BorderFactory.createLineBorder(new Color(58,66,103)));
      textField.setBorder(BorderFactory.createLineBorder(new Color(58,66,103)));
      add(img);
      img.setForeground(new Color(58,66,103));
      setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	}

	/**
	 * Changes the text of the text
	 * Field
	 */

	public void setText(String text){
		textField.setText(text);
	}
    /**
     * the content of the text field
     * @return the text field object
     */
	public JTextField field(){
		return this.textField;
	}
    
    /**
     * The content of the the field
     * @return the text Written
     */
	public String getText(){
		return textField.getText();
	}
    /**
     * Sets the action listener for the search button
     * @param command
     * String for ActionCommand
     */
	public void setSearchActionListener(String command){
		img.addActionListener(((Home)((Search) container).mainMenu).messenger );
		img.setActionCommand(command);
	}
} 