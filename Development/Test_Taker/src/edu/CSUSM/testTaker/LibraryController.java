package edu.CSUSM.testTaker;


import edu.CSUSM.testTaker.Backend.*;
import java.util.HashMap;

/**
 * 
 * @author Justin
 * @Description This class controls the library. This class loads in the library once and is used by many GUI classes throughout.
 * 		For successful implementation, this class should not be created more than once. Many of the variables are static, so if it is created more
 * 			than once, the variables will not need to be re-initialized.
 *
 */
public class LibraryController{

	/** 
	 * For Implementation, we are going to use Hashmaps. This is how:
	 * 		• The string used in the map (as the 'key') will be the identifier of the test
	 * 		• The 'value' of the map will be the actual object.
	 * 
	 * The reason we are using maps is because the time complexity is W(1) and the list will not have to loop
	 * 	through the data every time it is required.
	 */
	private static HashMap<String, Test> testArray;			//String is the testID
	private static HashMap<String, Question> questionArray;	//String is the questionID
	private static HashMap<String, Course> classArray;
	
	/**The below static variables are for the current class, not all information as done above */
	public static HashMap<String, Test> _currentTestsInCourse;			//String is the testID
	public static HashMap<String, Question> _currentQuestionsInCourse;	//String is the questionID 
	public static String _currentClassID;			


	public static boolean hasInitialized = false;

	/**
	 * @description Default constructor for class. Inits variables, if needed and allows access to all library objects
	 */
	public LibraryController(){

		/** If the library controller has been initialized already, skip the re-init of variables */
		if(!LibraryController.hasInitialized){
			
			LibraryController.hasInitialized = true;

			/**Init the hash maps*/
			loadData();	
		}else{
			System.out.println("Did not re-init library. Current lib in use.");
		}
		
		/**When data is initialized, do something else.. if needed*/
		//----------------------------------------------//
		//----------------------------------------------//
		//----------------------------------------------//
		//----------------------------------------------//
		//----------------------------------------------//
	}

	/**
	 * @description Loads the data from where-ever it is stored
	 */
	private static void loadData(){
		/**For now, just create empty maps, then add test data to them */
		testArray = new HashMap<String, Test>();
		questionArray = new HashMap<String, Question>();
		classArray = new HashMap<String, Course>();
		
		addTestData();
	}
	
	/**
	 * @description Adds sample data for testing purposes
	 */
	private static void addTestData(){
		testQuestion();
		sampleCourse();
	}
	
	
	/**
	 * @param ID - Identifier of currentCourse
	 * @description Compiles the information/data that is relative to the current course
	 */
	public static void gatherCourseMaterialsForID(String ID){
		
		/** First, locate all of the tests within the library and add all of the questions to the currentCourseLib */
		LibraryController._currentClassID = ID; 					//Set the currentClassID value
		
		/**
		 * The way we are currently loading the course, DNE, we have to now sort the questions for this particular course.
		 * This should be done as we read them in
		 */
		LibraryController._currentQuestionsInCourse.clear();		//Remove all questions from the currentClass Question map
		
		for(Question currentQuestion : LibraryController.questionArray.values()){
			/** We need to gather the courseID from the question */
			//If the testID of the question equals the currentTestID, we can add it to the map
			if(ID.equalsIgnoreCase(currentQuestion.getCourseID()))
				LibraryController._currentQuestionsInCourse.put(currentQuestion.getID(), currentQuestion);
		}
		
	}
	
	
	

	/**
	 * 	@description Creates a test question to ensure the question class works as expected
	 */
	private static void testQuestion(){
		
		//Initialize the question using the first constructor
		Question aSampleQuestion = new Question("What is 5 * 5?");
		
		//Add some possible answers
		aSampleQuestion.addAnswer("15");
		aSampleQuestion.addAnswer("25");
		aSampleQuestion.addAnswer("5");
		aSampleQuestion.addAnswer("10");
		
		//Tell the program where the correct answer lies within the array
		aSampleQuestion.setCorrectIndex(1);
		
		//Display the question in its entirety
		//System.out.println(aSampleQuestion.toString());
		
		//Add another question using the other constructor
		Question anotherQuestion = new Question("What is 5-5?", new String[]{"3", "4", "1", "7", "10", "0"}, 5);
		//System.out.println(anotherQuestion.toString());
		
		//Add the sample questions to the hashmap
		questionArray.put("1", aSampleQuestion);
		questionArray.put("2", anotherQuestion);
	}
	
	/**
	 * @description Creates a sample course to ensre the course class works as expected
	 * @NOTE Not yet completed. Awaiting Test Class
	 */
	private static void sampleCourse(){
		
	}
	
	/**
	 * @return Customized String that displays all of the relative data within the class
	 */
	public String toString(){
		
		//Create the string for questions
		String questionString = "Questions in Library: \n--------------------";
		
		//Add the question hashmap to the question string
		for(Question questionInLib : questionArray.values()){
			questionString += "\n" + questionInLib + "\n";
		}
		
		//For now, just return the question string
		return questionString;
	}

	/**Accesors */
	/**
	 * @return amount of total questions in Library
	 */
	public int getTotalQuestionCount(){
		return LibraryController.questionArray.size();
	}
	
	/**
	 * @return amount of total courses in Library
	 */
	public int getTotalCourseCount(){
		return LibraryController.classArray.size();
	}
	
	/**
	 * @return amount of total tests in Library
	 */
	public int getTotalTestCount(){
		return LibraryController.testArray.size();
	}
}
