package edu.CSUSM.testTaker.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//Manages the interaction between which buttons are pressed and which pages are shown

public class PageManager <CustomViewType>{
	
	public static JButton[] buttonsProvided;
	public CustomViewType[] panelsToDisplay;
	private JPanel parentPanel;
	public static int firstPageShownIndex;
	public static int previousPageIndex;			//Used for the subviews since the parent views don't have a previous. This will be used to return with a back button
	
	public PageManager(JPanel parentPanelVar, JButton[] btns, CustomViewType[] views, int indexOfFirstPageShown){
		PageManager.buttonsProvided = btns;
		PageManager.firstPageShownIndex = indexOfFirstPageShown;
		panelsToDisplay = views;
		this.parentPanel = parentPanelVar;
		
		hideAllPanelsButAtIndex(PageManager.firstPageShownIndex);
		addListenersToButtons();
	}
	
	public void hideAllPanelsButAtIndex(int index){
		
		//Check to see if the index exists
		if(index > panelsToDisplay.length - 1){
			System.out.println("Index To large. View could not be found");
			return;
		}
		
		for(int i = 0; i < panelsToDisplay.length; i++){
			
			//Convert view to a panel
			JPanel temp = (JPanel)panelsToDisplay[i];
			
			if(i == index){
				this.parentPanel.add(temp);
				temp.setVisible(true);
			}
			else{
				this.parentPanel.remove(temp);
				temp.setVisible(false);
			}
		}
	}
	
	//Manage all events from the buttons.
	//Basically, when the user hits a button (from teh side menu), we are just going to display that index of the panel
	private void addListenersToButtons(){
		for(int i = 0; i < PageManager.buttonsProvided.length; i++){
			
			final int index = i;
			
			PageManager.buttonsProvided[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//System.out.println("Testing the Action of button: " + e.getActionCommand());
					hideAllPanelsButAtIndex(index);
				}
			});
		}
	}

}
