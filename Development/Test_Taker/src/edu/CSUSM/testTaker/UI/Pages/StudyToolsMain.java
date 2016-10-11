package edu.CSUSM.testTaker.UI.Pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import edu.CSUSM.testTaker.UI.CustomPage;

public class StudyToolsMain extends CustomPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudyToolsMain(PanelType currentPanelType) {
		super(currentPanelType);
		// TODO Auto-generated constructor stub
		System.out.println("Printing a new Form");
		updateActions();
	}

	public StudyToolsMain(PanelType currentPanelType, BufferedImage newImage) {
		super(currentPanelType, newImage);
		// TODO Auto-generated constructor stub
		updateActions();
	}

	public StudyToolsMain(PanelType currentPanelType, String imageAddress) {
		super(currentPanelType, imageAddress);
		// TODO Auto-generated constructor stub
		updateActions();
	}

	public void updateActions() {

		// Set the button names
		setButtonNames(new String[] { "Play Game", "Do Something", "Practice With Flash Cards" });

		try {
			for (int i = 0; i < this.currentActions.length; i++) {
				switch (i) {
				case 0:
					this.currentActions[i].addActionListener(new OpenStudyGame());
					break;
				case 1:
					// this.currentActions[i].addActionListener(new
					// OpenStudyGame());
					break;
				case 2:
					this.currentActions[i].addActionListener(new OpenFlashCards());
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

	private class OpenStudyGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Opening " + this.getClass());
			/*
			 * StudyGame cm = new StudyGame(parentController.getWidth(),
			 * parentController.getHeight(), null); cm.setName("Study Game");
			 * parentController.displayView(cm);
			 */

		}

	}

	private class OpenFlashCards implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Opening " + this.getClass());

		}

	}

}