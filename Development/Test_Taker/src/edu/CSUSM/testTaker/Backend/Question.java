package edu.CSUSM.testTaker.Backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import edu.CSUSM.testTaker.LibraryController;

public class Question implements Serializable, Registerable {
	public static final long serialVersionUID = 1L;
	
	/**
	 * @deprecated
	 */
	public static int QUESTION_COUNT; //Keeps an always-updating count of questions per init in the program

	String myID;
	
	/**
	 * Return the identifier string of this Question
	 * @return A unique identifier string associated with this object.
	 */
	public String getID(){
		return myID;							//Within the Question HashMap, the ID will be in the key position where the question is the value
	}
	
	String _question, _courseID, _testID;
	ArrayList<String> _answers;			//To easily manage questions added and removed
	/**
	 * @deprecated
	 */
	public ArrayList<Double> _answerPoints;
	
	int _correctIndex = -1;				//The default correct index is 0 because it is not yet assigned;
	//The following has been removed, points value has little meaning outside a containing context like a test.
	//public int _pointValue = 1;					//Sets the default point value to 1
	
	
	/** New question with no details
	 */
	public Question(){
		myID = UUID.randomUUID().toString();
		_answers = new ArrayList<String>();
		_question = "";
		_courseID = "";
		_testID = "";
	}

	/**New Question starting with question text
	 * @author Justin Goulet
	 * @param mainQuestion The main text of the Question : the question being asked.
	 */
	public Question(String mainQuestion) {

		myID = UUID.randomUUID().toString();

		_answers = new ArrayList<String>();
		setQuestion(mainQuestion);
		
		/**Increment the total count of questions*/
		//Question.QUESTION_COUNT++;
		
		myID = UUID.randomUUID().toString();
		LibraryController.storeQuestion(this);
	}
	
	/** Complete question definition, with question, answers, and correct answer index
	 * @author Justin Goulet
	 * @param mainQuestion
	 *            The main question to be read
	 * @param answers
	 *            A list of answers that will be included in the question
	 * @param correctAnsIndex
	 *            The index of the correct answer within the 'answers' array
	 */
	public Question(String mainQuestion, String[] answers, int correctAnsIndex) {

		myID = UUID.randomUUID().toString();

		/* Set the main Question */
		setQuestion(mainQuestion);

		/* Add all possible answers to the list */
		this._answers = new ArrayList<String>(Arrays.asList(answers));

		/* Set the correct answer index */
		setCorrectIndex(correctAnsIndex);
		
		/**Increment the total count of questions*/
		//Question.QUESTION_COUNT++;
		
		myID = UUID.randomUUID().toString();
		LibraryController.storeQuestion(this);
	}
	
	/** Make a sample question.
	 * @return A reference to a Question, a Monty Python reference 
	 */
	public static Question makeExample(){
		Question rval = new Question();
		
		rval.setQuestion("What! is your Quest?");
		rval.addAnswer("What?");
		rval.addAnswer("To find the Holy Grail");
		rval.addAnswer("Aaaaaah");
		rval.setCorrectIndex(1);
		return rval;
	}
	

	/* Mutators */
	/**
	 * Set the question asked by this question.
	 * @author Justin Goulet
	 * @param newQuestion
	 *            overwrites the existing question, if any
	 */
	public void setQuestion(String newQuestion) {
		this._question = newQuestion;
		LibraryController.storeQuestion(this);
	}

	/**
	 * Set/reset an individual answer to this question.
	 * @author Justin Goulet
	 * @param newAnswer
	 *            Provides a new answer for the provided index
	 * @param index
	 *            The current location of the answer that is being modified
	 */
	public void setAnswer(String newAnswer, int index){
		if(index <= _answers.size()){
			this._answers.set(index, newAnswer); 
			LibraryController.storeQuestion(this);
			}
		}
	
	/**
	 * Remove a particular answer from the set of answers to this question
	 * @param index The number of the answer to remove.
	 */
	public void deleteAnswer(int index){
		this._answers.remove(index);
		if(index < this._correctIndex){
			--_correctIndex;
		}
	}
	
	/**
	 * Set the associated Test to file this question under
	 * @param newID the ID string associated with the Test.
	 */
	public void setTestID(String newID){
		this._testID = newID;
		LibraryController.storeQuestion(this);
	}

	/**
	 * Add a new answer to the set of answers for this question.
	 * @author Justin Goulet
	 * @param additionalAnswer A new answer to add to the array
	 */
	public void addAnswer(String additionalAnswer) {
		this._answers.add(additionalAnswer);
		LibraryController.storeQuestion(this);
	}

	/**
	 * Set the correct answer to this question
	 * @author Justin Goulet
	 * @param index Index of correct answer to this Question.
	 */
	public void setCorrectIndex(int index){
		if(index < _answers.size()){
			this._correctIndex = index;
			LibraryController.storeQuestion(this);
			}
		}

	/**
	 * Set the Course associated with this Question
	 * @author Justin Goulet
	 * @param courseID The ID string of the Course to associate this Question with.
	 */
	public void setCourseID(String courseID){
		this._courseID = courseID;
	}
	
	 

	/* Accessors */
	/**
	 * Get the text of this Question
	 * @author Justin Goulet
	 * @return The current question being asked.
	 */
	public String getQuestion() {
		return this._question;
	}
	
	/**
	 * Get the current number of answers to this Question.
	 * @return An int number of answers.
	 */
	public int numAnswers(){
		return _answers.size();
	}
	

	/**
	 * Get a list of answers to this Question.
	 * @author Justin Goulet
	 * @return A list of the current answer choices to this Question.
	 */
	public String[] getAnswers(){
		return (String[])this._answers.toArray(new String[_answers.size()]);
	}

	/**
	 * Get the answer string for a given index
	 * 
	 * @param dex
	 *            The index number of the answer to get.
	 * @return The String of that answer.
	 */
	public String getAnswer(int dex) {
		return _answers.get(dex);
	}

	/**
	 * Get the index of the correct answer to this question.
	 * @author Justin Goulet
	 * @return the location to the correct answer within the answers array
	 */
	public int getCorrectIndex() {
		return this._correctIndex;
	}
	
	
	/**
	 * Get the Course associated with this Question
	 * @author Justin Goulet
	 * @return The associated course identifier.
	 */
	public String getCourseID(){
		return this._courseID;
	}

	/**
	 * Get the Test associated with this Question
	 * @return An ID String of the Test this question is filed under.
	 */
	public String getTestID(){
		return this._testID;
	}
	
	/** Grades an answer to this question
	 * @author John Orcino
	 * @param location of user's chose of answer
	 * @description returns a 1.0 if answer given by user matches the correct answer for this Question
	 */
	public double pointsValue(int index){
		if(index == _correctIndex)
			return 1.0;
		else 
		return 0.0;
	}
	
	/**
	 * @author John Orcino
	 * @description calls pointsValue method and stores result into an ArrayList
	 * @param location of user's answer
	 * @deprecated
	 */
	public void storePoints(int index){
		if(null == this._answerPoints)
			_answerPoints = new ArrayList<Double>();
		_answerPoints.add(pointsValue(index));
	}
	
	/** (non-Javadoc)
	/**
	 * Return a string representation of this Question.
	 * @see java.lang.Object#toString()
	 * @author Justin Goulet
	 * @return A human readable string of the contents of this question.
<<<<<<< HEAD
=======
	 * 
>>>>>>> Tizzle
	 */
	@Override
	public String toString() {

		// Create the initial question
		String thisQuestionString = "Question: " + this._question;
		thisQuestionString += "\nQuestion ID: " + getID();

		
		// Now, add each of the possible answers in the provided question
		for (int iterator = 0; iterator < this.getAnswers().length; iterator++) {
			thisQuestionString += "\n\t\t " + (iterator + 1) + ") " + this.getAnswers()[iterator];

			// If the answer is correct, add an asterisk to the end
			thisQuestionString += (iterator == this._correctIndex) ? " *correct*" : "";
		}
		
		// Return the result
		return thisQuestionString;
	}

}
