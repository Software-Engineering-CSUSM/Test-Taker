package edu.CSUSM.testTaker.Backend;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {
	
	public static int COURSE_COUNT; 					//Keeps a sum of all existing courses. Will count every time the class is init.
	
	public String _courseID;
	public double _courseGrade, _testsCompleted;
	public HashMap<String, Question> _questionsInCourse; //Used for final exams and practice quizzes
	public ArrayList<Test> _testsInCourse;				//Used for external calculations
	


	/**
	 * @author Justin Goulet
	 * @description Default Constructor
	 */
	public Course(){
		
		/** Increment the course counter */
		Course.COURSE_COUNT++;
		
		/** Compile all questions from all tests into one arraylist from the registry
		 * 		This will also assis in organizing the tests
		 */
		
		compileCourse();
	}
	
	/**
	 * @author Justin Goulet
	 * @description Compiles all of the questions and tests for this particular course
	 * Note that all of the events are happening in the libraryController class
	 */
	private static void compileCourse(){
		
	}
	
	
	/**
	 * @author Justin Goulet
	 * @param courseID the courseID to set
	 */
	public void setCourseID(String courseID) {
		this._courseID = courseID;
	}

	/**
	 * @author Justin Goulet
	 * @param courseGrade the courseGrade to set
	 */
	public void setCourseGrade(double courseGrade) {
		this._courseGrade = courseGrade;
	}

	/**
	 * @author Justin Goulet
	 * @param testsCompleted the testsCompleted to set
	 */
	public void setTestsCompleted(double testsCompleted) {
		this._testsCompleted = testsCompleted;
	}

	/**
	 * @author Justin Goulet
	 * @return the courseID
	 */
	public String getCourseID() {
		return this._courseID;
	}

	/**
	 * @author Justin Goulet
	 * @return the courseGrade
	 */
	public double getCourseGrade() {
		return this._courseGrade;
	}

	/**
	 * @author Justin Goulet
	 * @return the testsCompleted
	 */
	public double getTestsCompleted() {
		return this._testsCompleted;
	}
	
	
	
}
