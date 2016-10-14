package edu.CSUSM.testTaker.Backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.io.Serializable;

public class Question implements Serializable, Registerable{
	public static final long serialVersionUID = 1L;
	public static int QUESTION_COUNT; //Keeps an always-updating count of questions per init in the program

	public String myID;
	
	public String getID(){
		return myID;							//Within the Question HashMap, the ID will be in the key position where the question is the value
	}
	
	public String _question, _courseID, _testID;
	public ArrayList<String> _answers;			//To easily manage questions added and removed
	public int _correctIndex = -1;				//The default correct index is 0 because it is not yet assigned;
	//The following has been removed, points value has little meaning outside a containing context like a test.
	//public int _pointValue = 1;					//Sets the default point value to 1
	

	/**
	 * @author Justin Goulet
	 * @param mainQuestion
	 */
	public Question(String mainQuestion){
		_answers = new ArrayList<String>();
		setQuestion(mainQuestion);
		
		/**Increment the total count of questions*/
		Question.QUESTION_COUNT++;
		
		myID = UUID.randomUUID().toString();
		QuestionRegistry.store(this);
	}
	
	/**
	 * @author Justin Goulet
	 * @param mainQuestion The main question to be read
	 * @param answers A list of answers that will be included in the question
	 * @param correctAnsIndex The index of the correct answer within the 'answers' array
	 */
	public Question(String mainQuestion, String[] answers, int correctAnsIndex){
		
		/* Set the main Question */
		setQuestion(mainQuestion);
		
		/* Add all possible answers to the list */
		this._answers = new ArrayList<String>(Arrays.asList(answers));
		
		/* Set the correct answer index */
		setCorrectIndex(correctAnsIndex);
		
		/**Increment the total count of questions*/
		Question.QUESTION_COUNT++;
		
		myID = UUID.randomUUID().toString();
		QuestionRegistry.store(this);
	}
	
	/* Mutators */
	/**
	 * @author Justin Goulet
	 * @param newQuestion overwrites the existing question, if any
	 */
	public void setQuestion(String newQuestion){
		this._question = newQuestion;
		QuestionRegistry.store(this);
		}
	
	/**
	 * @author Justin Goulet
	 * @param newAnswer Provides a new answer for the provided index
	 * @param index The current location of the answer that is being modified
	 */
	public void setAnswer(String newAnswer, int index){
		this._answers.set(index, newAnswer); 
		QuestionRegistry.store(this);
		}
	
	public void setTestID(String newID){
		this._testID = newID;
		QuestionRegistry.store(this);
	}
	
	/**
	 * @author Justin Goulet
	 * @param additionalAnswer Adds a new answer the array
	 */
	public void addAnswer(String additionalAnswer){
		this._answers.add(additionalAnswer);
		QuestionRegistry.store(this);
	}
	
	/**
	 * @author Justin Goulet
	 * @param index of which references index of answers array
	 */
	public void setCorrectIndex(int index){
		this._correctIndex = index;
		QuestionRegistry.store(this);
		}
	
	/* Accessors */
	/**
	 * @author Justin Goulet
	 * @return The current question
	 */
	public String getQuestion(){
		return this._question;
	}
	
	/**
	 * @author Justin Goulet
	 * @return a list of the correct answers
	 */
	public String[] getAnswers(){
		return this._answers.toArray(new String[this._answers.size()]);
	}

	/**
	 * Get the answer string for a given index
	 * @param dex The index number of the answer to get.
	 * @return The String of that answer.
	 */
	public String getAnswer(int dex){
		return _answers.get(dex);
	}
	
	/**
	 * @author Justin Goulet
	 * @return the location to the correct answer within the answers array
	 */
	public int getCorrectIndex(){
		return this._correctIndex;
	}
	
	/**
	 * @author Justin Goulet
	 * @param courseID sets the current course identifier
	 */
	public void setCourseID(String courseID){
		this._courseID = courseID;
	}
	
	/**
	 * @author Justin Goulet
	 * @return the associated course identifier
	 */
	public String getCourseID(){
		return this._courseID;
	}
	
	/**
	 * @author John Orcino
	 * @description 
	 */
	public double pointsValue(double index){
		if(index == _correctIndex)
			return 1.0;
		else 
		return 0.0;
	}
	
	
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @author Justin Goulet
	 */
	
	
	@Override
	public String toString(){
		
		//Create the initial question
		String thisQuestionString = "Question: " + this._question;
		thisQuestionString += "\nQuestion ID: " + getID();
				
		//Now, add each of the possible answers in the provided question
		for(int iterator = 0; iterator < this.getAnswers().length; iterator++){
			thisQuestionString += "\n\t\t " + (iterator+1) + ") " + this._answers.get(iterator);
			
			//If the answer is correct, add an asterisk to the end
			thisQuestionString += (iterator == this._correctIndex) ? " *correct*" : "";
		}
		
		//Return the result
		return thisQuestionString;
	}
}
