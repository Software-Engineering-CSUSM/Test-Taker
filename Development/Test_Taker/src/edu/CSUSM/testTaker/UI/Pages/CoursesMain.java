package edu.CSUSM.testTaker.UI.Pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import edu.CSUSM.testTaker.UI.CustomPage;
import edu.CSUSM.testTaker.UI.CustomPage.PanelType;

public class CoursesMain extends CustomPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CoursesMain(String panelName, PanelType currentPanelType) {
		super(panelName, currentPanelType);
		// TODO Auto-generated constructor stub
		// System.out.println("Printing a new Form");
		updateActions();
	}

	public CoursesMain(String panelName, PanelType currentPanelType, BufferedImage newImage) {
		super(panelName, currentPanelType, newImage);
		// TODO Auto-generated constructor stub
		updateActions();
	}

	public CoursesMain(String panelName, PanelType currentPanelType, String imageAddress) {
		super(panelName, currentPanelType, imageAddress);
		// TODO Auto-generated constructor stub
		updateActions();
	}

	public void updateActions() {

		// Set the button names
		setButtonNames(new String[] { "Add Course", "Delete Course", "Manage Selected Course" });

		try {
			for (int i = 0; i < this.currentActions.length; i++) {
				switch (i) {
				case 0:
					this.currentActions[i].addActionListener(new AddCourse());
					break;
				case 1:
					this.currentActions[i].addActionListener(new DeleteCourse());
					break;
				case 2:
					this.currentActions[i].addActionListener(new ManageSelectedCourse());
					break;
				default:
					System.out.println("Not enough implemented classes");
					break;
				}
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	// Creates a Pop up window to add a course.  To actually add a course, implement
		// method from the PopUp class in the action listener for add course
		private class AddCourse implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("Opening " + this.getClass());

				// Constructor uses a main window with just a logo type, and
				// an SaveQuiz to create the correct popUp window in the
				// PopUp class
				PopUp popup = new PopUp( "",PopUp.PanelType.LOGO_ONLY_TYPE, PopUpType.AddCourse);
				
				
				//After saving course name in the pop up, call courses main and refresh
				CustomPage.setqBuilderNumButtons(3);
				CoursesMain cm = new CoursesMain("Courses Main", CoursesMain.PanelType.QUESTION_BUILDER_TYPE);
				//cm.setName("Courses Main");
				cm.parentController = parentController;
				parentController.displayView(cm);
				
				cm.revalidate();

			}

		}
		// Creates a Pop up window to delete course.  To actually delete the course, implement
		// method from the PopUp class in the action listener for delete
		private class DeleteCourse implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("Opening " + this.getClass());

				// Call Pop Up window to confirm deleting course.  To actually delete course upon clicking
				// "yes", implement the function in the action listener in the PopUp class
				PopUp popup = new PopUp("",PopUp.PanelType.LOGO_ONLY_TYPE, PopUpType.DeleteCourse);
				
				
				//After deleting a course from the pop up, call courses main and refresh
				CustomPage.setqBuilderNumButtons(3);
				CoursesMain cm = new CoursesMain("Courses Main", CoursesMain.PanelType.QUESTION_BUILDER_TYPE);
				//cm.setName("Courses Main");
				cm.parentController = parentController;
				parentController.displayView(cm);
				
				cm.revalidate();

			}

		}
		
		private class ManageSelectedCourse implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				 System.out.println("Opening " + this.getClass());
				 
				CustomPage.setqBuilderNumButtons(3);
				TestListManager tm = new TestListManager("Test List Manager", CustomPage.PanelType.QUESTION_BUILDER_TYPE);
				//tm.setName("Test List Manager");
				tm.parentController = parentController;
				parentController.displayView(tm);

			}

		}



	}
