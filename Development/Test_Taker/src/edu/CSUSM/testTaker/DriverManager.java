/**
 * 
 */
package edu.CSUSM.testTaker;

import edu.CSUSM.testTaker.Backend.Course;
import edu.CSUSM.testTaker.Backend.Question;
import edu.CSUSM.testTaker.Backend.Test;
import edu.CSUSM.testTaker.UI.GUIController;

/**
 * @author Justin
 *
 */
public class DriverManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GUIController gui = new GUIController();
		gui.setVisible(true);
		
		//Load content into library
		Question sample = 		Question.makeExample();
		Test sampleTest = 		Test.makeExample();
		Course sampleCourse = 	Course.makeExample();
		
		System.out.println(sample);
		System.out.println(sampleTest);
		System.out.println(sampleCourse);
	}

}
