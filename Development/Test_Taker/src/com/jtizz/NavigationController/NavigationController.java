package com.jtizz.NavigationController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.CSUSM.testTaker.UI.CustomPage;

public class NavigationController extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Set default values
	 */
	public static String DEFAULT_BACK_BUTTON_TITLE = "<- Back";
	public static int DEFAULT_NAVIGATION_BAR_HEIGHT = 50;

	public JButton backButton;
	public JLabel currentPageDescriptionLabel;

	private JPanel navigationPanel;
	private static Image applicationImage;

	public NavigationController(){


		//For visibility, make the background black;
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		addNavigationBar();

	}

	public NavigationController(Image applicationImage){
		this.setLayout(new BorderLayout());
		NavigationController.applicationImage = applicationImage;
		addNavigationBar();
	}

	private void addNavigationBar(){


		/** For Testing */
		URL url;
		try {
			url = new URL("https://github.com/Software-Engineering-CSUSM/Test-Taker/blob/master/Team%20Graphics/Test_Taker_LogoOption3.png?raw=true");
			NavigationController.applicationImage = ImageIO.read(url);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/** End of Testing */ 

		navigationPanel  = new JPanel();
		navigationPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
		navigationPanel.setBackground(Color.WHITE);
		navigationPanel.setMinimumSize(new Dimension(this.getWidth(), DEFAULT_NAVIGATION_BAR_HEIGHT));
		navigationPanel.setBounds(0, 0, this.getWidth(), DEFAULT_NAVIGATION_BAR_HEIGHT);

		//Add the back buton
		backButton = new JButton(DEFAULT_BACK_BUTTON_TITLE);
		gbc.gridx = 0;
		gbc.gridy = 0;
		//gbc.fill = GridBagConstraints.EAST;
		navigationPanel.add(backButton, gbc);	

		//Add the application Logo
		//Just display an image in the panel
		JLabel imageLabel = new JLabel();
		try{
			Image newImg = NavigationController.applicationImage.getScaledInstance(DEFAULT_NAVIGATION_BAR_HEIGHT*2, DEFAULT_NAVIGATION_BAR_HEIGHT,  java.awt.Image.SCALE_SMOOTH);
			ImageIcon newIcon = new ImageIcon(newImg);
			imageLabel.setIcon(newIcon);
		}
		catch(NullPointerException e){
			System.out.println("No Logo could be found. Please check the project directory");
		}
		catch(Exception e){
			System.out.println("Error Finding image: " + e.getMessage());
		}
		gbc.gridx ++;
		gbc.gridwidth = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		imageLabel.setBorder(new EmptyBorder(0, DEFAULT_NAVIGATION_BAR_HEIGHT, 0, DEFAULT_NAVIGATION_BAR_HEIGHT));
		navigationPanel.add(imageLabel, gbc);
		
		//Add the current Page title
		currentPageDescriptionLabel = new JLabel("Current Page Description");
		gbc.gridx+= 6;
		gbc.gridwidth = 1;
		//gbc.fill = GridBagConstraints.WEST;
		navigationPanel.add(currentPageDescriptionLabel, gbc);

		this.add(navigationPanel, BorderLayout.NORTH);
		System.out.println("Size of Navigation Bar:\nW: " + navigationPanel.getWidth() + "\nH: " + navigationPanel.getHeight());
	}


}
