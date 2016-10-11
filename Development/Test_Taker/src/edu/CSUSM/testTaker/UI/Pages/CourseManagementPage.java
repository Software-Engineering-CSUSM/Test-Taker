package edu.CSUSM.testTaker.UI.Pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import edu.CSUSM.testTaker.UI.CustomPage;

public class CourseManagementPage extends CustomPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseManagementPage(PanelType currentPanelType) {
		super(currentPanelType);
		// TODO Auto-generated constructor stub
		// System.out.println("Printing a new Form");
		updateActions();
	}

	public CourseManagementPage(PanelType currentPanelType, BufferedImage newImage) {
		super(currentPanelType, newImage);
		// TODO Auto-generated constructor stub
		updateActions();
	}

	public CourseManagementPage(PanelType currentPanelType, String imageAddress) {
		super(currentPanelType, imageAddress);
		// TODO Auto-generated constructor stub
		updateActions();
	}

	public void updateActions() {

		// Set the button names
		setButtonNames(new String[] { "Course Management", "Other 1", "Other 2" });

		for (int i = 0; i < this.currentActions.length; i++) {
			switch (i) {
			case 0:
				this.currentActions[i].addActionListener(new OpenCourseManagement());
				break;
			case 1:
				this.currentActions[i].addActionListener(new OpenCourseManagement());
				break;
			case 2:
				this.currentActions[i].addActionListener(new OpenCourseManagement());
				break;
			default:
				System.out.println("Not enough implemented classes");
				break;
			}
		}
	}

	private static class OpenCourseManagement implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Opening " + this.getClass());

		}

	}
	/*
	 * 
	 * private static class OpenContentManagement implements ActionListener{
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * System.out.println("Opening " + this.getClass()); }
	 * 
	 * }
	 */

}