/**
 * 
 */
package edu.CSUSM.testTaker.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.jtizz.NavigationController.NavigationController;

import edu.CSUSM.testTaker.LibraryController;

/**
 * @author Justin
 *
 */
public class GUIController extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 750, FRAME_HEIGHT = 500;		//Frame dimensions
	private static final double DEFAULT_OFFSET = 5.0;					//Distance between frame and panels
	public static LibraryController currentLib;								//Accesses the current library


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Create the main Frame

		//Set a particular panel to be built and shown
		GUIController newController = new GUIController();
		newController.setVisible(true);

		//Create the library reference
		//currentLib = new LibraryController();
	}

	public GUIController(){
		super();

		//Build the frame
		buildFrame();

		//Add a panel. Note that this one is just a blank template. There will be a new heiarchy when created.
		//Set the layout
		this.setLayout(null);

		//Create the side menu
		SideMenu sm = new SideMenu(new String[]{"Home", "Courses", "Study Tools", "Statistics"});
		this.add(sm, BorderLayout.WEST);

		
		//Add the main Frame
		//Optiom 1
		CustomPage livePage = new CustomPage(CustomPage.PanelType.LOGO_ONLY_TYPE, "https://github.com/Software-Engineering-CSUSM/Test-Taker/blob/master/Team%20Graphics/Test_Taker_LogoOption3.png?raw=true");

		//Option 2
		//CustomPage livePage = new CustomPage(CustomPage.PanelType.LOGO_ONLY_TYPE, "https://cloud.githubusercontent.com/assets/21960249/18531998/20f5cf92-7a8e-11e6-8774-6e881f0f5051.png?raw=true");
		this.add(livePage);

		CustomPage courses = new CustomPage(CustomPage.PanelType.TWO_BUTTON_TYPE);
		this.add(courses);

		CustomPage studyTools = new CustomPage(CustomPage.PanelType.THREE_BUTTON_TYPE);
		this.add(studyTools);

		//Create the page manager. This will take in all created views (just the first page of them) and the buttons from the side menu.
		//Then, it will handle all events
		PageManager pm = new PageManager(SideMenu.menuOptionButtons, new CustomPage[]{livePage, courses, studyTools}, 0);
		

		/** For testing */
		//Create a temp action event for the buttons
		for(int i = 0; i < SideMenu._numberOfButtons; i++){
			SideMenu.menuOptionButtons[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){

					//Prints out the button name
					System.out.println(e.getActionCommand());
					SideMenu.setStatus(false, (JButton)e.getSource());

				}
			});
		}


		/** End of testing */
	}

	private void buildFrame(){

		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Test Taker");

	}



}