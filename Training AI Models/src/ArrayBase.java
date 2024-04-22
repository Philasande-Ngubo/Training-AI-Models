import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
public class ArrayBase extends DataQuery{

   private Statement[] base;
   private int nextFree;
   public ArrayBase(){
   	super();
   }

   @Override
   public void add(String statement){
    try{
   	 base[nextFree++] = new Statement(Guru.toStatement(statement));
    }
    catch (Exception f){
        JOptionPane.showMessageDialog(
                  null, "Error adding statement\n Please restart", "Data", JOptionPane.ERROR_MESSAGE);
                  System.exit(0);

    }
     
   }

   @Override
   public Statement search(String item){
   	 Statement results = null;
   	 String temp =item;
     for (int i = 0 ;i < nextFree ;i++){
     	if ( base[i].term().trim().toLowerCase().equals(temp)    ){
     		results = new Statement(base[i]);
     		break;

     	}
     }
     return results;
   }

   @Override
   public void update(String term, String sentence,double score){
      for (int i= 0 ;i <nextFree;i++){
      	boolean termEquals = base[i].term().toLowerCase().equals(term);

     	if ( termEquals ) {
     		base[i].update(sentence,score);
     		break;
     	}
     }
   }

   @Override
   public Statement search(String item,String sentence){

   	 Statement results = null;
     for (int i = 0 ;i <nextFree;i++){
     	boolean termEquals = base[i].term().toLowerCase().equals(item.toLowerCase());
        boolean sentenceEquals = base[i].sentence().toLowerCase().indexOf(sentence) > -1;
     	if ( termEquals && sentenceEquals  ){
     		results = new Statement(base[i]);
     		break;
     	}
     }
     return results;

   }
   @Override
   public void post(){
   	FileWriter writer;
   	 try{
         writer = new FileWriter(super.baseKnolwegde,false);
          for (Statement s:base){
     	   writer.write(s.toString());
          }
         writer.close();
        }
        catch(Exception e){

        }
    
   }
   @Override
   public void load(){

   	int count = 0;
   	Scanner reader;
   	try{
   	   reader = new Scanner(super.baseKnolwegde);
       while (reader.hasNext() ){
       	 count++;
       	 reader.nextLine();
       }
       nextFree = count;
       base = new Statement[count+100];
       reader = new Scanner(super.baseKnolwegde);
       count =0;
       try{
        while ( reader.hasNextLine()){
          base[count++] = Guru.toStatement(reader.nextLine());
        }
       }
       catch (Exception c){

       }

   	 }
   	 catch (Exception e){
   	 	
   	 }
   }

   @Override
   public String[] compileSug(String trial){
   	String[] temp =new String[nextFree];
   	int count =0;
   	for (int i =0;i< nextFree;i++){
   		if ( base[i].term().toLowerCase().indexOf(trial) > -1){
   		    temp[count++] = base[i].term();
   		}
   	}
   	String[] results = new String[count];
   	for (int i =0;i<count;i++){
   		results[i] = temp[i];
   	}
    return results;
   }

}