package edu.CSUSM.testTaker.UI.Pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import edu.CSUSM.testTaker.LibraryController;
import edu.CSUSM.testTaker.Backend.Course;
import edu.CSUSM.testTaker.UI.CustomPage;
import edu.CSUSM.testTaker.UI.CustomPage.PanelType;
import edu.CSUSM.testTaker.UI.ListView;

public class GamePrep extends CustomPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GamePrep(PanelType currentPanelType) {
		super(currentPanelType);
		// TODO Auto-generated constructor stub
		System.out.println("Printing a new Form");
		updateActions();
	}

	public GamePrep(PanelType currentPanelType, BufferedImage newImage) {
		super(currentPanelType, newImage);
		// TODO Auto-generated constructor stub
		updateActions();
	}

	public GamePrep(PanelType currentPanelType, String imageAddress) {
		super(currentPanelType, imageAddress);
		// TODO Auto-generated constructor stub
		updateActions();
	}

	private void updateActions(){
		// Set the button names
		setButtonNames(new String[] { "Select Course", "How to Play"});

		try {
			for (int i = 0; i < this.currentActions.length; i++) {
				switch (i) {
				case 0:
					this.currentActions[i].addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							
							ListView<Course> tm = new ListView<Course>(LibraryController.getAllCourses(), new String[]{"Play"});
							tm.setName("Courses List");
							tm.parentController = parentController;
							parentController.displayView(tm);
							
						}
					});
					break;
				case 1:
					this.currentActions[i].addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							System.out.print("Under Construction");
						}
					});
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
}