package edu.CSUSM.testTaker.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//Manages the interaction between which buttons are pressed and which pages are shown

public class PageManager {
	
	public static JButton[] buttonsProvided;
	public static CustomPage[] panelsToDisplay;
	public static int firstPageShownIndex;
	public static int previousPageIndex;			//Used for the subviews since the parent views don't have a previous. This will be used to return with a back button
	
	public PageManager(JButton[] btns, CustomPage[] views, int indexOfFirstPageShown){
		PageManager.buttonsProvided = btns;
		PageManager.panelsToDisplay = views;
		PageManager.firstPageShownIndex = indexOfFirstPageShown;
		
		hideAllPanelsButAtIndex(PageManager.firstPageShownIndex);
		addListenersToButtons();
	}
	
	private static void hideAllPanelsButAtIndex(int index){
		
		//Check to see if the index exists
		if(index > panelsToDisplay.length - 1){
			System.out.println("Index To large. View could not be found");
			return;
		}
		
		for(int i = 0; i < panelsToDisplay.length; i++){
			if(i == index)
				panelsToDisplay[i].setVisible(true);
			else
				panelsToDisplay[i].setVisible(false);
		}
	}
	
	public static void displayPageAtIndex(int index){
		hideAllPanelsButAtIndex(index);
	}
	
	//Manage all events from the buttons.
	//Basically, when the user hits a button (from teh side menu), we are just going to display that index of the panel
	private static void addListenersToButtons(){
		for(int i = 0; i < PageManager.buttonsProvided.length; i++){
			
			final int index = i;
			
			PageManager.buttonsProvided[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("Testing the Action of button: " + e.getActionCommand());
					displayPageAtIndex(index);
				}
			});
		}
	}

}