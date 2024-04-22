import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
/**
 * This is the Graphical Interface to interact with user 
 * For Searching A data structure
 * @author Philasande Ngubo
 */
public class Search extends JFrame {
   private ImageIcon icon;
   private JTextField term,term2,sentence;
   private JPanel pnlTerm,pnlSentence,pnlResult;
   private JList lstSugg;
   private final Font uFont = new Font("Arial", Font.BOLD,12);
   private final Color formBlue = new Color(58,66,103);
   private final Color backBlue = new Color(224,250,252);
   public SearchField searchTerm;
   public SearchField searchS;
   private JTextField termField =new JTextField();
   private coButton back;
   JScrollPane scrollPane;
   private JLabel lblResult = new JLabel("Term searches are reliable and convenient");
   public final JFrame mainMenu;

   /**
    * Constructor 
    * Creates The Search Graphical User Interface
    * @param mainMenu 
    * this is the Home main Menu
    */
   public Search(JFrame mainMenu){
      
       this.mainMenu = mainMenu;
       searchTerm= new SearchField(610,this);
       String[] init = {"ghgv","jf"};
       lstSugg = new JList(init);
       lstSugg.setVisible(true);
       lstSugg.setBounds(50,130,553,80);
       lstSugg.setBorder(BorderFactory.createLineBorder(new Color(58,66,103)));
       lstSugg.setForeground(new Color(58,66,103));
       scrollPane = new JScrollPane(lstSugg);
       scrollPane.setVisible(false);
       scrollPane.setBounds(50,130,553,80);
   	 back = new coButton("<",this);
   	 coButton.buttonToLabel(back);
   	 setVisible(true);
	    setSize(700,550);
		setLayout(null);
      setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Search");
      Border raisedbevel = BorderFactory.createRaisedBevelBorder();
      add(back);
      back.setFont(new Font("Arial",Font.BOLD,28));
      back.setBounds(20,1,70,50);
      back.setForeground(formBlue);
      pnlTerm = new JPanel();
      pnlSentence = new JPanel();
      pnlResult = new JPanel();
		pnlTerm.setBorder(BorderFactory.createTitledBorder(raisedbevel,"SEARCH BY TERM :",TitledBorder.LEFT,1,uFont,formBlue));
		pnlSentence.setBorder(BorderFactory.createTitledBorder(raisedbevel,"SEARCH BY TERM AND SENTENCE :",TitledBorder.LEFT,1,uFont,formBlue));
		pnlResult.setBorder(BorderFactory.createTitledBorder(raisedbevel,"RESULTS :",TitledBorder.LEFT,1,uFont,formBlue));

		pnlTerm.setForeground(formBlue);
		pnlSentence.setForeground(formBlue);
		pnlResult.setForeground(formBlue);

		getContentPane().setBackground(backBlue);	
		UniversalListener messenger = ((Home) mainMenu).messenger;

		back.addActionListener(messenger);
		back.setActionCommand("SBack");
		
     
		pnlTerm.setBackground(backBlue);
		pnlSentence.setBackground(backBlue);
		pnlResult.setBackground(backBlue);

		pnlTerm.setBounds(30,50,650,135);
		pnlSentence.setBounds(30,185,650,135);
		pnlResult.setBounds(30,320,650,180);

     
      add( scrollPane);
      
		add(pnlTerm);
		add(pnlSentence);
		add(pnlResult);
      searchS = new SearchField(378,this);

		lblResult.setForeground(formBlue);
	   lblResult.setFont(new Font("Arial",Font.PLAIN,13));
	   pnlResult.add(lblResult);

      SpringLayout  layout = new SpringLayout();
		pnlSentence.setLayout(layout);

		searchTerm.setLocation(20,30);
      searchTerm.setSearchActionListener("STerm");
      pnlTerm.add(searchTerm);

		termField.setPreferredSize(new Dimension(227,60));
		termField.setFont(new Font("Arial", Font.BOLD,20));
		termField.setForeground(formBlue);
      
      searchS.setLocation(0,0);
      searchS.setSearchActionListener("SSentence");
      pnlSentence.add(termField);
      pnlSentence.add(searchS);
      

      Point A = searchS.getLocation();
      Point B = termField.getLocation();

      layout.putConstraint(SpringLayout.EAST, searchS,  
                       -8, SpringLayout.EAST, pnlSentence);
		layout.putConstraint(SpringLayout.WEST, termField,  
                       8, SpringLayout.WEST, pnlSentence);
		layout.putConstraint(SpringLayout.NORTH, searchS,  
                       6, SpringLayout.NORTH, pnlSentence);

      layout.putConstraint(SpringLayout.NORTH, termField,  
                       6, SpringLayout.NORTH, pnlSentence);
      termField.setBorder(BorderFactory.createLineBorder(new Color(58,66,103)));
		try{
			icon = new ImageIcon("picc.png");
            setIconImage(icon.getImage());
		}
		catch(Exception e){}
		setLocationRelativeTo(null);

      searchTerm.field().getDocument().addDocumentListener(new DocumentListener() {
      public void changedUpdate(DocumentEvent e) {
        suggestions();
       }
      public void removeUpdate(DocumentEvent e) {
        suggestions();
        }
      public void insertUpdate(DocumentEvent e) {
        suggestions();
       }

  public void suggestions() {
       scrollPane.setVisible(true);
       lstSugg.setListData(((Home) mainMenu).database.compileSug(searchTerm.getText()));

      
     }
  }
);

      lstSugg.addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            String selectedValue =(String) lstSugg.getSelectedValue();
            
            searchTerm.setText(selectedValue);
        }
    }
});

      searchTerm.field().addFocusListener(new FocusListener() {
         public void focusGained(FocusEvent focusEvent){}
         public void focusLost(FocusEvent focusEvent) {
            hideSearch();
         }
      });
      setLocationRelativeTo(null);


   }
   /**
    * The main menu is returned
    * @return main menu JFrame
    */
   public JFrame mainMenu(){
      return this.mainMenu;
   }
   /**
    * Navigates back to the Main Menu home Page
    */
   public void back(){
   	mainMenu.setVisible(true);
   	this.setVisible(false);
   }

   /**
    * This sets the results Display
    * @param results 
    * String of Results
    */
   public void setResults(String results){
      lblResult.setText(results);
     
   }
   /**
    * The content of the textField term
    * @return the text written on the term field
    */
   public String getWrittenTerm(){
      return searchTerm.getText().trim().toLowerCase();
   }
   /**
    * The content of the second term field
    *  @return the term written
    * in the searchTerm field
    */
   public String getWTerm(){
      return termField.getText().trim().toLowerCase();
   }
    /**
     * the content of the sentence field
     *  @return the sentence written
    * in the sentence field
    */
   public String getSentence(){
      return searchS.getText().trim().toLowerCase();
   }
   /**
    * Hides the search suggestion list
    */
   public void hideSearch(){
      scrollPane.setVisible(false);
   }
   

}