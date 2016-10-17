package edu.CSUSM.testTaker.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.ImageView;

/**
 * 
 * @author Justin
 * @purpose The purpose of this class is to make it easier to create JPanels. Are panel types are quite simple to create.
 * 			For simplicity, there are a few type of panels:
 * 				• TWO_BUTTON_TYPE 		- Has a logo and two buttons (sBs)
 * 				• THREE_BUTTON_TYPE 	- Has a logo and three buttons (2 on top, one centered below)
 * 				• LOGO_ONLY_TYPE		- Has only a logo
 * 				• QUESTION_BUILDER_TYPE	- has a question input, posible answer input and radio buttons to selct correct answer
 *
 */
public class CustomPage2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BufferedImage mainLogoToDisplay;
	public static Image newImg;
	public static ImageIcon newIcon;
	public JLabel imageLabel = new JLabel();
	private static int centerOfNewFrame;
	public JButton[] currentActions;
	public String panelTypeString;



	public static enum PanelType{
		TWO_BUTTON_TYPE,
		THREE_BUTTON_TYPE,
		LOGO_ONLY_TYPE,
		QUESTION_BUILDER_TYPE
	};

	public CustomPage2(PanelType currentPanelType, String imageAddress){

		super();

		//Create the image from the image address
		try {                
			URL url = new URL(imageAddress);
			CustomPage2.mainLogoToDisplay = ImageIO.read(url);
		} catch (IOException ex) {
			// handle exception...
			System.out.println(ex.getMessage());
		}

		buildPanel(currentPanelType);
	}
	
	public CustomPage2(PanelType currentPanelType, BufferedImage newImage){
		super();
		CustomPage2.mainLogoToDisplay = newImage;
		buildPanel(currentPanelType);
	}


	/**
	 * @param currentPanelType
	 * @description Call if the image was already found
	 */
	public CustomPage2(PanelType currentPanelType){
		super();
		//Set the layout
		this.setLayout(new BorderLayout());
		
		//Build the contents
		buildPanel(currentPanelType);

	}

	private void buildPanel(PanelType currentPanelType){
		
		//Set the string value of the panel type
		this.panelTypeString = currentPanelType.toString();

		//Set the size of the panel
		this.setBounds(SideMenu.WIDTH, 0, GUIController.FRAME_WIDTH - SideMenu.WIDTH, GUIController.FRAME_HEIGHT);

		switch(currentPanelType){
		case TWO_BUTTON_TYPE:
			createTwoButtonType();
			break;

		case THREE_BUTTON_TYPE:
			createThreeButtonType();
			break;

		case LOGO_ONLY_TYPE:
			createLogoType();
			break;

		case QUESTION_BUILDER_TYPE:
			break;

		default:
			System.out.println("Panel Type Not Found");
			break;
		}
	}

	private void createLogoType(){

		//Set the background color
		this.setBackground(Color.WHITE);				//Option 1
		//this.setBackground(new Color(39, 72, 155));	//Option 2

		//Just display an image in the panel
		imageLabel = new JLabel();
		try{

			Image img = CustomPage2.mainLogoToDisplay;
			newImg = img.getScaledInstance((this.getWidth() == 0) ? 600 : this.getWidth(), (this.getHeight()/2 == 0) ? 250 : this.getHeight()/2,  java.awt.Image.SCALE_SMOOTH);
			newIcon = new ImageIcon(newImg);
			imageLabel.setIcon(newIcon);
		}
		catch(NullPointerException e){
			System.out.println("No Logo could be found. Please check the project directory");
		}
		catch(Exception e){
			System.out.println("Error Finding image: " + e.getMessage());
		}
		imageLabel.setBounds(0, 0, this.getWidth(), (int) (this.getHeight()/2.25));

		//Align to center
		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		imageLabel.setVerticalAlignment(JLabel.CENTER);
		this.add(imageLabel, BorderLayout.CENTER);

	}


	private void createTwoButtonType(){
		this.setBackground(Color.WHITE);

		/** Later
		//Add the image to the top of the screen. We are going to have 3 objects at the top: Back btn, logo, and currentpage title
		 * */
		JLabel iconLabel = new JLabel();
		iconLabel.setBounds(0, 0, this.getWidth(), (int) (this.getHeight()/2.25));
		iconLabel.setIcon(newIcon);
		//this.add(iconLabel);
		this.add(iconLabel, BorderLayout.CENTER);

		//Align to center
		iconLabel.setHorizontalAlignment(JLabel.CENTER);
		iconLabel.setVerticalAlignment(JLabel.CENTER);

		centerOfNewFrame = iconLabel.getHeight() - iconLabel.getY();
		
		addButtons(2);

	}

	private void createThreeButtonType(){
		this.setBackground(Color.WHITE);

		JLabel iconLabel = new JLabel();
		iconLabel.setBounds(0, 0, this.getWidth(), (int) (this.getHeight()/2.25));
		iconLabel.setIcon(newIcon);
		//this.add(iconLabel);
		this.add(iconLabel);
		
		//Align to center
		iconLabel.setHorizontalAlignment(JLabel.CENTER);
		iconLabel.setVerticalAlignment(JLabel.CENTER);

		//centerOfNewFrame = (this.getHeight() - (this.getHeight() - iconLabel.getHeight()));

		addButtons(3);

	}

	private void addButtons(int count){
		
		/*
		currentActions = new JButton[count+1];
		int originOfButton = 0;
		int yValue = centerOfNewFrame + 25;	//Added 25 to move the first button down (25 px after logo)
		int buttonWidth = this.getWidth()/3;

		for(int i = 1; i <= count; i++){

			currentActions[i] = new JButton("Button " + i);

			if(i % 2 == 1){		//If the number is odd, start on the left
				originOfButton = this.getWidth()/3 - (this.getWidth()/3)/2 - 25;
				//originOfButton = 0;
			}else{				//Start on the right
				originOfButton = (this.getWidth()/3)*2 - (this.getWidth()/3)/2 + 25;
				//originOfButton = buttonWidth;
			}

			//If the count is odd, we need to center the last button
			if((count == i) && (count % 2 == 1)){
				//originOfButton = this.getWidth()/2 - this.getWidth()/6;
				//originOfButton = buttonWidth - buttonWidth/2;
				originOfButton = this.getWidth()/3 - (this.getWidth()/3)/2 - 25;
				buttonWidth = this.getWidth()/3 * 2 + 50;	//The sum of btns 1 & 2, and the distance between
			}

			//System.out.println("Stats: \nOrigin:\t" + originOfButton + "\nCenter:\t" + centerOfNewFrame + "\nWidth:\t" + this.getWidth()/3);
			currentActions[i].setBounds(originOfButton, yValue, buttonWidth, 100);
			//btn[i].setBorder(new RoundedBorder(50));
			currentActions[i].setBorder(new EmptyBorder(5, 5, 5, 5));
			currentActions[i].setBackground(new Color(85, 85, 85));
			currentActions[i].setOpaque(true);
			currentActions[i].setForeground(Color.WHITE);
			currentActions[i].setFont(new Font(Font.SERIF, Font.BOLD | Font.ITALIC, 24));
			this.add(currentActions[i]);

			//Move the y location for hte next one, if applicable
			if(i % 2 == 0)
				yValue += 125;
		}
	*/
		//Add a panel to the south for the buttons
		
		JPanel buttonHolder = new JPanel();
		buttonHolder.setLayout(new GridLayout(1, 1, 10,10));	//May need to be gridbaglayout
		this.add(buttonHolder, BorderLayout.SOUTH);
		
		this.currentActions = new JButton[count];
		
		for(int i = 0; i < count; i++){
			this.currentActions[i] = new JButton("Button " + (i+1));
			this.currentActions[i].setBackground(new Color(85,85,85));
			this.currentActions[i].setOpaque(true);
			this.currentActions[i].setBorder(new EmptyBorder(50,0,50,0));
			buttonHolder.add(this.currentActions[i]);
			this.currentActions[i].setForeground(Color.WHITE);
			this.currentActions[i].setFont(new Font(Font.SERIF, Font.BOLD | Font.ITALIC, 24));
		}
	}



	/** Accessors and mutators */

	public static BufferedImage getMainLogoToDisplay() {
		return mainLogoToDisplay;
	}

	public static void setMainLogoToDisplay(BufferedImage mainLogoToDisplay) {
		CustomPage2.mainLogoToDisplay = mainLogoToDisplay;
	}

}
