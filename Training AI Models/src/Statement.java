/**
 * This is a Statement type class it contains a name 
 * and a sentence that relates or define that name as general knowlegde
 * @author Philasande Ngubo (NGBPHI016)
 */
public class Statement{
    //instances
	private String term;
	private String sentence;
	private double score;

	/**
	 * Constructor
	 * creates a statement instance with name sentence and confidence
	 * @param term
	 * the term described
	 * @param sentence 
	 * gives general knowlegde on the term
	 * @param score
	 * Confidence rate of the knolwegde given
	 */
	public Statement(String term, String sentence , double score){
		this.term = term;
		this.sentence = sentence;
		this.score = score;
	}
    /**
     * Copy Constructor
     * @param other 
     * the Statement you want to copy
     */
	public Statement(Statement other){
	 this.term = other.term;
	 this.sentence = other.sentence;
	 this.score = other.score;
	}
    /**
     * @return the term the statement is about
     */
	public String term(){
		return this.term;
	}
	/**
	 * The Description related to the term
	 * @return general knowlegde on the term
	 */

	public String sentence(){
		return this.sentence;
	}
    /**
     * The double score rate
     * @return the confidence rate on the truth about 
     * a statement as a double
     */
	public double score(){
		return this.score;
	}
   /**
    * Changes the general knowlege and confidence rate
    * @param sentence
    * new general knolwegde
    * @param score
    * new connfidence rate on the truth
    */
	public void update(String sent, double scor){
		this.sentence = sent;
		this.score = scor;
	}

    @Override
	public boolean equals(Object o){
		if (! (o instanceof Statement)){
			return false;
		}
		else{
			 Statement other = (Statement) o;
			return other.toString().equals(this.toString());
		}
	}
    @Override
	public String toString(){
		return this.term+"\t"+this.sentence+"\t"+this.score;
	}

}