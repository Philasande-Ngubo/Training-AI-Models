import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
/**
 * This is the home page for the training model
 * Contains graphics used as an Interface for Both
 * Arrays and BTS
 * @author Philasande Ngubo
 */
public class Home extends JFrame {

		coButton btnSearch ;
		coButton btnUpdate ;
		coButton btnAdd    ;
		coButton btnLoad   ;
		JLabel lblCom = new JLabel("Waiting for base...");
		public UniversalListener messenger =new UniversalListener();
		public Search search ;
		public DataQuery database;
		/**
		 * Contruct a homepage 
		 * @param database
		 * Enter the data query
		 */
	   public Home(DataQuery database){
		super("Train Ai Models");
		this.database =database;
		btnSearch = new coButton("Search Term",this);
		btnUpdate = new coButton("Update Term",this);
		btnAdd    = new coButton("Add Term",this);
		btnLoad   = new coButton("Load Base",this);
		setVisible(true);
		setLayout(null);
		setSize(800,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel temp = new JPanel();
		temp.setBounds(250,0,550,400);
		temp.setBackground(new Color(50,58,81));
		add(temp);
		ImageIcon image,image2;
		JLabel imageFrame,title,slogan;

		title =new JLabel("Train AI Models");
		slogan = new JLabel("help build a better future");
		slogan.setFont(new Font("Courier New", Font.PLAIN,15));
		title.setFont(new Font("Courier New", Font.BOLD,38));
		title.setForeground(Color.WHITE);
		slogan.setForeground(Color.WHITE);
		title.setBounds(10,5,400,100);
		slogan.setBounds(10,105,400,100);
		temp.add(title);
		temp.add(slogan);
		temp.setBorder(BorderFactory.createMatteBorder(0,3,0,0,new Color(58,66,120)));

		lblCom.setFont(new Font("Arial", Font.BOLD,15));
		lblCom.setForeground(new Color(58,66,103));

		disableAll();

      btnLoad.setBounds(10,55,210,70);
		btnSearch.setBounds(10,133,210,70);
		btnUpdate.setBounds(10,211,210,70);
		btnAdd.setBounds(10,289,210,70);
		lblCom.setBounds(10,2,210,50);

		btnLoad.addActionListener(messenger);
		btnSearch.addActionListener(messenger);
		btnAdd.addActionListener(messenger);
		btnUpdate.addActionListener(messenger);

		btnLoad.setActionCommand("HLoad");
		btnSearch.setActionCommand("HSearch");
		btnUpdate.setActionCommand("HUpdate");
		btnAdd.setActionCommand("HAdd");

		btnAdd.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btnLoad.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btnSearch.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btnUpdate.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		add(btnSearch);
		add(btnUpdate);
		add(btnAdd);
		add(btnLoad);
		add(lblCom);

         try{
         	image = new ImageIcon(getClass().getResource("hom.jpg"));
         	image2 =new ImageIcon(getClass().getResource("picc.png"));
         	setIconImage(image2.getImage());
            imageFrame = new JLabel(image);
            temp.add(imageFrame);
            imageFrame.setBounds(160,140,230,200);
         }
		catch(Exception e){
          System.out.println("Directory Corrupted. /n exiting...");
          System.exit(0);
		}
		this.search = new Search(this);
		search.setVisible(false);
	}

	private void enable(JButton b){
			b.setFont(new Font("Georgia", Font.BOLD,20));
			b.setForeground(Color.WHITE);
			b.setBackground(new Color(58,66,103));
			b.setEnabled(true);
		}

	/**
   * Set all the other menu
   * buttons clickable
   */
	public void enableAll(){
		enable(btnSearch);
		enable(btnUpdate);
		enable(btnAdd);
		enable(btnLoad);
	}
  /**
   * Set all the other menu
   * buttons unclickable except Load File
   */
	public void disableAll(){
		disable(btnSearch);
		disable(btnUpdate);
		disable(btnAdd);
		enable(btnLoad);
	}

		private void disable(JButton b){
			b.setFont(new Font("Georgia", Font.BOLD,20));
			b.setForeground(Color.WHITE);
			b.setBackground(new Color(152,175,199));
			b.setEnabled(false);
		}
   
   /**
    * Sets the Label at the top of
    * Load File Button
    * @param msg
    * String message
    */
	public void setFileMessage(String msg){
      lblCom.setText(msg);
	}
}