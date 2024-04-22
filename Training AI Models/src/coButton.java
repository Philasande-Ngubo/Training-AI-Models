import javax.swing.*;
import java.awt.*;
/**
 * This is a Buttons can keep track of their containers
 * @author Philasande Ngubo;
 */

public class coButton extends JButton{
	/** Constructor for the coButton
	 * @param cap
	 * The Text inside the button
	 * @param sos
	 * The Frame the button is on
	 */
	private JFrame container;
	public coButton(String cap, JFrame sos){
		super(cap);
		this.container = sos;
	}
	/**
	 * Makes buttons to loook like labels
	 * but keeping the methods of JButton
	 * @param a
	 * the JButton
	 */
    public static void buttonToLabel(JButton a){
       a.setFocusPainted(false);
       a.setMargin(new Insets(0,0,0,0));
       a.setContentAreaFilled(false);
       a.setBorderPainted(false);
       a.setOpaque(false);

    }
    /** The container of the button
     * @return The JFrame the button is on
     */
	public JFrame getContainer(){
     return this.container;
	}
} 