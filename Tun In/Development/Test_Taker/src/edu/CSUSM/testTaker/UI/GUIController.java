/**
 * 
 */
package edu.CSUSM.testTaker.UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.CSUSM.testTaker.LibraryController;
import edu.CSUSM.testTaker.UI.Pages.ContentManagementPage;
import edu.CSUSM.testTaker.UI.Pages.CoursesMain;
import edu.CSUSM.testTaker.UI.Pages.QuizAndFlashMain;
import edu.CSUSM.testTaker.UI.Pages.StudyToolsMain;

/**
 * @author Justin
 *
 */
public class GUIController extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 950, FRAME_HEIGHT = 700; // Frame
																	// dimensions
	// private static final double DEFAULT_OFFSET = 5.0; //Distance between
	// frame and panels
	public static LibraryController currentLib; // Accesses the current library
	private JPanel parentPanel;
	public static NavigationController navCont;
	private NavigationController mainNavigationController, coursesNC, studyToolsNC, statsNC;

	public static enum PageName {
		ManageCourses, ManageContent, TakeFlashCards, ViewQuestions, ManageQuestions, ViewStats, HomePage, StudyToolsMain
	}

	/**
	 * --------------------------------Define All
	 * Classes--------------------------------
	 */
	private static CoursesMain courses;
	private static QuizAndFlashMain quizzes;
	private static ContentManagementPage contentMgr;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Create the main Frame

		// Set a particular panel to be built and shown
		GUIController newController = new GUIController();
		newController.setVisible(true);

		// Create the library reference
		// currentLib = new LibraryController();
	}

	/**
	 * @Description Builds the side menu, the main navigation controllers (One
	 *              for each side menu option) and the Page Manager (to control
	 *              the Side Menu actions)
	 * @author Justin Goulet
	 * @DateModified Oct 5, 2016
	 */
	public GUIController() {
		super();

		// Build the frame
		buildFrame();

		// Add the navigation Controller
		/** Main Page */
		mainNavigationController = new NavigationController();

		CustomPage mainPage = new CustomPage(SideMenu.menuOptionButtons[0].getText(), CustomPage.PanelType.LOGO_ONLY_TYPE, NavigationController.applicationImage);
		mainNavigationController.setInitialView(mainPage);
		mainPage.parentController = mainNavigationController;

		// After we create the main page, we need to create more.
		// Note that each subview will have its own nvaigation controller
		/** Courses */
		coursesNC = new NavigationController();

		/*
		 * CustomPage coursesMain = new
		 * CustomPage(CustomPage.PanelType.TWO_BUTTON_TYPE);
		 * coursesMain.setName(SideMenu.menuOptionButtons[1].getText());
		 * coursesNC.setInitialView(coursesMain);
		 */
		
		// Set number of buttons for question builder type before calling constructor
		CustomPage.setqBuilderNumButtons(3);
		CustomPage.setQBRowHeaders(LibraryController.getAllCoursesAvailable());
		CustomPage.setQBRowIDs(LibraryController.getAllCourseIDsAvailable());
		courses = new CoursesMain(SideMenu.menuOptionButtons[1].getText(), CustomPage.PanelType.QUESTION_BUILDER_TYPE);
		coursesNC.setInitialView(courses);
		courses.parentController = coursesNC;

		// For testing purposes, add a second page to the courses page.
		/**
		 * Ideally, the courses main will extend the CustomPage class and become
		 * its own class. All that is going to happen in the next few lines will
		 * be in that class.
		 */
		/** start Sample */
		/*
		 * quiz.currentActions[0].addActionListener(new ActionListener(){ public
		 * void actionPerformed(ActionEvent e){ CustomPage testPage = new
		 * CustomPage(CustomPage.PanelType.THREE_BUTTON_TYPE);
		 * coursesNC.displayView(testPage); } });
		 */

		/** end Sample */

		/** Study Tools */
		studyToolsNC = new NavigationController();

		/*StudyToolsMain studyToolsMain = new StudyToolsMain(SideMenu.menuOptionButtons[2].getText(), CustomPage.PanelType.TWO_BUTTON_TYPE);
		studyToolsNC.setInitialView(studyToolsMain);
		studyToolsMain.parentController = studyToolsNC;*/
		
		// Set number of buttons for question builder type before calling constructor
		CustomPage.setqBuilderNumButtons(2);
		CustomPage.setQBRowHeaders(LibraryController.getAllCoursesAvailable());
		CustomPage.setQBRowIDs(LibraryController.getAllCourseIDsAvailable());
		StudyToolsMain studyToolsMain = new StudyToolsMain(SideMenu.menuOptionButtons[1].getText(), CustomPage.PanelType.QUESTION_BUILDER_TYPE);
		studyToolsNC.setInitialView(studyToolsMain);
		studyToolsMain.parentController = studyToolsNC;

		/** Statistics */
		final NavigationController statsNC = new NavigationController();
		CustomPage statsMain = new CustomPage(SideMenu.menuOptionButtons[3].getText(), CustomPage.PanelType.SINGLE_BUTTON_TYPE);
		statsNC.setInitialView(statsMain);
		statsMain.parentController = statsNC;

		/** Page manager to control the side menu use */
		PageManager<NavigationController> pm = new PageManager<NavigationController>(this.parentPanel,
				SideMenu.menuOptionButtons,
				new NavigationController[] { mainNavigationController, coursesNC, studyToolsNC, statsNC }, 0);
		pm.hideAllPanelsButAtIndex(0);

		// When the side buttons are selected, update the title in the
		// navigation controller
		for (int i = 0; i < SideMenu.menuOptionButtons.length; i++) {
			SideMenu.menuOptionButtons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Anything else that needs to be added to all of the side
					// buttons
					/**
					 * Reset all Navigation Controllers to return to the first
					 * page
					 */
					mainNavigationController.reset();
					coursesNC.reset();
					studyToolsNC.reset();
					statsNC.reset();
				}
			});
		}

	}

	/**
	 * @Description Builds the standard frame
	 * @author Justin Goulet
	 * @DateModified Oct 5, 2016
	 */
	private void buildFrame() {

		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle("Testing Application");
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
		this.parentPanel = new JPanel();
		this.parentPanel.setLayout(new BorderLayout());
		this.add(this.parentPanel, BorderLayout.CENTER);

		// Add the side menu
		SideMenu sm = new SideMenu(new String[] { "Home", "Courses", "Study Tools", "Statistics" });
		this.add(sm, BorderLayout.WEST);

	}

	/*
	 * Pop Up Window Frame
	 * 
	 * Added new constructor for the pop up window for saving questions and
	 * quizzes. Gave it an int parameter (dummy parameter) to add a constructor
	 * to build the frame for the pop up windows
	 */
	public GUIController(int x) {

		this.setSize(500, 250);

		// If there is no title provided from the PopUp class
		// set the frame title to Pop Up Window
		if (this.getTitle() == "")
			this.setTitle("Pop Up Window");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		this.setVisible(true);

	}

	/**
	 * --------------------------------Manage Page
	 * Controls--------------------------------
	 */
	private void setCoursesMainEvents() {

	}

}
