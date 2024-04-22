import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
/**
 * This is the graphics class for updating a Statement
 * @author Philasande Ngubo
 */
public class Update extends JFrame{
	private ImageIcon icon ;
	private final Color formBlue = new Color(58,66,103);
	private final Font uFont = new Font("Arial", Font.BOLD,18);
	private final Font aFont = new Font("Arial", Font.BOLD,20);
	private JLabel prompt = new JLabel("Enter the term you want to update:");
	private JLabel prompt1 = new JLabel("Enter the new sentence:");
	private JLabel prompt2 = new JLabel("Enter the confidence rate:");
	public static final int UPDATE = 1;
	public static final int ADD = 2;
	private int menu;

	private coButton back;

	private JTextArea term = new JTextArea();
	private JTextArea sentence = new JTextArea();
	private JTextArea confidence = new JTextArea();

	private coButton request;
	private coButton process;

	private JPanel pane = new JPanel();
	private JFrame mainMenu;
	private UniversalListener messenger =new UniversalListener();

	/**
	 * Constructor
	 * Creates an update GUI Form
	 * @param menu
	 * select between Update and Add Menu
	 */
	public Update(int menu,JFrame parent){
		this.mainMenu =parent;
		request = new coButton("Request",this);
		process = new coButton("Proceed",this);
		process.addActionListener(((Home) mainMenu).messenger );
		process.setActionCommand("UUpdatePro");
		back = new coButton("<",this);
		back.addActionListener(messenger);
		back.setActionCommand("UBack");
		coButton.buttonToLabel(back);
		request.addActionListener( ((Home) mainMenu).messenger);

		  request.setActionCommand("UUPDATE");
		if (menu == Update.ADD){
			request.setActionCommand("UADD");
			setTitle("Add new term");
			process.setActionCommand("UAddPro");
			process.setText("Proceed");
			prompt.setText("Enter the term you want to add");

		}
		setVisible(true);
		setSize(700,550);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Update");
		prompt.setBounds(30,65,400,30);
		prompt.setFont(aFont);
		prompt.setForeground(formBlue);
		add(prompt);
		getContentPane().setBackground(new Color(224,250,252));

		term.setBounds(30,110,400,50);
		term.setFont(aFont);
		term.setForeground(formBlue);
		add(term);

		back.setBounds(10,0,70,80);
		setResizable(false);
		back.setForeground(formBlue);
		add(back);

		request.setBackground(formBlue);
		request.setForeground(Color.WHITE);
		request.setFont(aFont);
		request.setBounds(445,110,230,50);
		request.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		process.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(request);

		pane.setBounds(30,180,644,300);
		pane.setVisible(true);
		pane.setLayout(null);
		pane.setBackground(new Color(224,250,252));
		add(pane);

		prompt1.setFont(aFont);
		prompt1.setForeground(formBlue);
		prompt2.setFont(aFont);
		prompt2.setForeground(formBlue);

		prompt1.setBounds(20,20,250,30);
		prompt2.setBounds(20,145,400,30);
		back.setFont(new Font("Arial",Font.BOLD,27) );


		confidence.setFont(aFont);
		sentence.setFont(aFont);
		confidence.setForeground(formBlue);
		sentence.setForeground(formBlue);

		term.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		sentence.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		confidence.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        

		sentence.setBounds(20,65,380,50);
		confidence.setBounds(20,193,380,50);

		process.setBackground(formBlue);
		process.setFont(uFont);
		process.setForeground(Color.WHITE);
		process.setBounds(420,193,210,50);

        pane.add(prompt1);
        pane.add(sentence);
        pane.add(prompt2);
        pane.add(confidence);
        pane.add(process);
        pane.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        hideOptions();
        clearTextFields();
		try{
			icon = new ImageIcon("picc.png");
            setIconImage(icon.getImage());
		}
		catch(Exception e){}
	}

	public void hideOptions(){
		pane.setVisible(false);
	}

	public void showOptions(){
		pane.setVisible(true);
	}

	public void back(){
		mainMenu.setVisible(true);
		this.setVisible(false);
	}
    /**
     * The content of the  text field
     * @return the term written on the Term field 
     */
	public String getTerm(){
		return term.getText().trim().toLowerCase();
	}
	/**
	 * the content of the sentence field
	 * @return the sentence written in the textField
	 */

	public String getSentence(){
		return Guru.toSentenceFormat(sentence.getText());
	}
	/**
	 * The content of the score field as a double
	 * @return the  score written on the textfield
	 */

	public double getScore(){
		return Double.parseDouble(confidence.getText().trim());
	}

	/**
	 * Clears all text fields 
	 */
	public void clearTextFields(){
		sentence.setText(" ");
		confidence.setText(" ");
		term.setText(" ");
	}


}