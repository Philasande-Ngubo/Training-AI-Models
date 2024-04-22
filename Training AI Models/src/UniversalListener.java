import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.*;
import java.io.*;
/**
 * This is the action listener for the whole assignment
 * every event is listened here and this is strictly for this
 * Assignment no other use strictly for buttons
 * @author Philasande Ngubo
 */
public class UniversalListener implements ActionListener{
	private Home uhome ;
	private Statement priorStatement;
	private String priorTerm;
	public UniversalListener(){}
	public void actionPerformed(ActionEvent e){

		String command = e.getActionCommand();

		if (command.equals("HLoad")){
          JFileChooser fileChooser = new JFileChooser();
          int option = fileChooser.showSaveDialog(null);
          Home temp =(Home) ((coButton) e.getSource()).getContainer();
          temp.disableAll();
          uhome = temp;
          if ( option == JFileChooser.APPROVE_OPTION){
          	fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
          	fileChooser.addChoosableFileFilter( new FileNameExtensionFilter("Knowlegde base","txt") );
          	fileChooser.setAcceptAllFileFilterUsed(false);
          	temp.database.updateFile(fileChooser.getSelectedFile());
          	try{
          		temp.database.load();
          		temp.setFileMessage(temp.database.getFileName());
          		temp.enableAll();

          	}
          	catch(Exception exception){
          		JOptionPane.showMessageDialog(
                  temp, "File not in knolwegde base Format", "Knolwegde Base", JOptionPane.ERROR_MESSAGE);
          		    temp.setFileMessage("Waiting for a base...");
          	}
          }
		}

		if (command.equals("HSearch")){
			Home home =(Home) ((coButton) e.getSource()).getContainer();
			home.search.setVisible(true);
			home.search.setLocationRelativeTo(null);
			home.setVisible(false);

		}


		if (command.equals("URequest")){
			 Update update = (Update)  ((coButton) e.getSource()).getContainer();
			 Statement results = uhome.database.search(update.getTerm());
		}

		if (command.equals("SBack")){
			((Search) ((coButton) e.getSource()).getContainer()).back();
		}

		if (command.equals("UBack")){
			((Update) ((coButton) e.getSource()).getContainer()).back();
		}
		if (command.equals("HUpdate")){
			new Update(Update.UPDATE,((coButton) e.getSource()).getContainer());
			uhome.setVisible(false);
		}

		if (command.equals("HAdd")){
			new Update(Update.ADD,((coButton) e.getSource()).getContainer());
			uhome.setVisible(false);
		}

		if (command.equals("STerm")){
			Home temp = this.uhome;
			Search search = temp.search;
			search.hideSearch();
			String term =search.getWrittenTerm();
			Statement results =  temp.database.search(term);
			if (results == null){
				search.setResults("<html><br/><br/>No statement with this term "+ term+".<br/><br/>You can add it on the add feature </html>");

			}
			else{
				search.setResults("<html><br/><br/><b>SENTENCE:</b> "+results.sentence()+"<br/><br/><b>CONFIDENCE SCORE:</b> "+results.score()+"</html>");

			}

		}

		if (command.equals("SSentence")){
			Search search = uhome.search; 
			String term = search.getWTerm();
			String sentence = search.getSentence();
			Statement results =  uhome.database.search(term,sentence);
			if (results == null){
				search.setResults("<html><br/><br/>No statement with this term "+ term+".<br/><br/>You can add it on the add feature </html>");

			}
			else{
				search.setResults("<html><br/><br/><br/><br/><b>CONFIDENCE RATE: </b>"+results.score()+"</html>");

			}


		}

        if (command.equals("UUPDATE") ){
        	Update update = (Update) ((coButton) e.getSource()).getContainer();
        	String term = update.getTerm();
        	Statement temp = uhome.database.search(term);
        	if (temp == null){
        		JOptionPane.showMessageDialog(
                  update, "Term not in database \n you can add it by going to the add menu", "Admin", JOptionPane.INFORMATION_MESSAGE);
        		  update.hideOptions();

        	}
        	else{
        		update.showOptions();
        		priorStatement = temp;

        	}
        }

        if (command.equals("UADD") ){
        	Update update = (Update) ((coButton) e.getSource()).getContainer();
        	String term = update.getTerm();
        	Statement temp = uhome.database.search(term);
        	if ( !(temp == null)){
        		JOptionPane.showMessageDialog(
                  update, "Term already  exists.\n you can only update it", "Admin", JOptionPane.INFORMATION_MESSAGE);
        		  update.hideOptions();

        	}
        	else{
        		if (! term.equals("")){
        	     priorTerm =term;
        		 update.showOptions();
        		}

        	}
        }

        if (command.equals("UUpdatePro") ){
         Update update = (Update) ((coButton) e.getSource()).getContainer();
         String sentence =update.getSentence();
         double score;	
         try{
         	score = update.getScore();
            if (score <= 1){
            	 if ( sentence.trim().length() > 1){

         		if ( priorStatement.score() <= score){
         			uhome.database.update(priorStatement.term().trim().toLowerCase(),sentence,score);
         			JOptionPane.showMessageDialog(
                    update, "The term "+priorStatement.term()+" has been successfully updated.", "Update", JOptionPane.INFORMATION_MESSAGE);
        		    update.hideOptions();
        		    update.clearTextFields();

         		}
         		else{

         			String[] buttons = { "Change Sentence", "Cancel"};
         			int feedback = JOptionPane.showOptionDialog(
                                    update,"Confidence score is lower than the one present","Update",2,0,null, buttons,null);
         			if (feedback == 1){
         				update.clearTextFields();
                        update.hideOptions();
         			}
        		    
         		}

         	}
         	else{
         		JOptionPane.showMessageDialog(
                  update, "Invalid Sentence", "Data", JOptionPane.ERROR_MESSAGE);
         	}
            }
            else
            {
               JOptionPane.showMessageDialog(
                 update, "Invalid Confidence Score", "Data", JOptionPane.ERROR_MESSAGE);	
            }


         }
         catch (Exception o){
         	JOptionPane.showMessageDialog(
                  update, "Invalid Score", "Data", JOptionPane.ERROR_MESSAGE);
   

         }


        }

        if (command.equals("UAddPro") ){
         Update update = (Update) ((coButton) e.getSource()).getContainer();
         String sentence =update.getSentence();
         double score;	
         try{
         	score = update.getScore();

         	if (score <= 1){
         	  if ( sentence.trim().length() > 1){
                Statement tempStatement = new Statement(priorTerm.trim().toLowerCase(),Guru.toSentenceFormat(sentence),score);
         	  	uhome.database.add(tempStatement.toString());
         	  	JOptionPane.showMessageDialog(
                update, "The term "+priorTerm+" has been successfully added.", "Add", JOptionPane.INFORMATION_MESSAGE);
                update.clearTextFields();
                update.hideOptions();

         	  }
         	  else{
         		JOptionPane.showMessageDialog(
                  update, "Invalid Sentence", "Data", JOptionPane.ERROR_MESSAGE);
      
         	  }
         	}
         	else
         	{
         		JOptionPane.showMessageDialog(
                  update, "Invalid Confidence Score", "Data", JOptionPane.ERROR_MESSAGE);
         	}

         }
         catch (Exception o){
         	JOptionPane.showMessageDialog(
                  update, "Invalid Score", "Data", JOptionPane.ERROR_MESSAGE);

         }


        }




	}
} 