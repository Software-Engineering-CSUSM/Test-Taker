package edu.CSUSM.testTaker.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import edu.CSUSM.testTaker.UI.CustomObjects.CustomButton;
import edu.CSUSM.testTaker.UI.Pages.ManageData;
import edu.CSUSM.testTaker.UI.Pages.QuizAndFlashQuestionPage;

/**
 * 
 * @author Justin
 * @purpose The purpose of this class is to make it easier to create JPanels.
 *          Are panel types are quite simple to create. For simplicity, there
 *          are a few type of panels: • TWO_BUTTON_TYPE - Has a logo and two
 *          buttons (sBs) • THREE_BUTTON_TYPE - Has a logo and three buttons
 *          (2 on top, one centered below) • LOGO_ONLY_TYPE - Has only a logo
 *          • QUESTION_BUILDER_TYPE - has a question input, posible answer
 *          input and radio buttons to selct correct answer
 *
 */
public class CustomPage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BufferedImage mainLogoToDisplay;
	public static Image newImg;
	public static ImageIcon newIcon;
	public JLabel imageLabel = new JLabel();
	protected static int centerOfNewFrame;
	public JButton[] currentActions;
	public String panelTypeString, titleOfCurrentQuestionPanel;
	public NavigationController parentController;

	// Added show/Hide check box to show and hide answer for flashcard
	public JCheckBox showHide = new JCheckBox("Show/Hide Answer");
	public static String FlashcardAnswer = "This is where the answer goes.";;

	// Created an array of string for the button names
	private static final int MAX_NUMBER_OF_BUTTONS = 10;
	protected static String[] buttonName = new String[MAX_NUMBER_OF_BUTTONS];
	/** For the Question Panel */
	JLabel titleLabel;
	JPanel questionsMainPanel;

	/** End of question panel specific vars */

	public static enum PanelType {
		TWO_BUTTON_TYPE, THREE_BUTTON_TYPE, LOGO_ONLY_TYPE, QUESTION_BUILDER_TYPE, Q_and_A_Type, QUESTIONPAGE, FLASHCARDPAGE
	};

	public static enum PageType {
		QUIZ, FLASHCARD
	};

	public CustomPage(PanelType currentPanelType, String imageAddress) {

		super();
		// Create the image from the image address
		try {
			URL url = new URL(imageAddress);
			CustomPage.mainLogoToDisplay = ImageIO.read(url);
		} catch (IOException ex) {
			// handle exception...
			System.out.println(ex.getMessage());
		}

		buildPanel(currentPanelType);
	}

	public CustomPage(PanelType currentPanelType, BufferedImage newImage) {
		super();
		CustomPage.mainLogoToDisplay = newImage;
		buildPanel(currentPanelType);
	}

	/**
	 * @param currentPanelType
	 * @description Call if the image was already found
	 */
	public CustomPage(PanelType currentPanelType) {
		super();
		// Set the layout
		this.setLayout(new BorderLayout());

		// Build the contents
		buildPanel(currentPanelType);

	}

	public CustomPage(PanelType currentPanelType, PageType currentPageType) {
		super();
		// Set the layout
		this.setLayout(new BorderLayout());

		// Build the contents
		buildPanel(currentPanelType);

	}

	/**
	 * @param nc
	 *            Navigation controller used to show the next panel
	 */
	public void setParentController(NavigationController nc) {
		this.parentController = nc;
	}

	/*
<<<<<<< HEAD
	 * added String[] to arguments of createButton Types which is passed through
	 * buildPanel, so I added a String[] argument here as well
	 * 
	 */

	// Set the string value of the panel type
=======
	 *  added String[] to arguments of createButton Types which is passed
	 *  through buildPanel, so I added a String[] argument here as well
	 * 
	 */
		
		//Set the string value of the panel type
>>>>>>> Tizzle
	private void buildPanel(PanelType currentPanelType) {

		this.panelTypeString = currentPanelType.toString();

		// Set the size of the panel
		this.setBounds(SideMenu.WIDTH, 0, GUIController.FRAME_WIDTH - SideMenu.WIDTH, GUIController.FRAME_HEIGHT);

		// Set the background color
		this.setBackground(Color.WHITE);

		switch (currentPanelType) {
		case TWO_BUTTON_TYPE:
<<<<<<< HEAD

=======
>>>>>>> Tizzle
			createTwoButtonType();
			break;

		case THREE_BUTTON_TYPE:
			createThreeButtonType();
			break;

		case LOGO_ONLY_TYPE:
			createLogoType();
			break;

		case Q_and_A_Type:
			createQandAype();
			break;

		case QUESTIONPAGE:
			createQuestionPageType();
			break;

		case FLASHCARDPAGE:
			createFlashcardPageType();
			break;

		case QUESTION_BUILDER_TYPE:
			createQuestionBuilderType();
			break;

		default:
			System.out.println("Panel Type Not Found");
			break;
		}
	}

	protected void createLogoType() {

		// Set the background color // Option 1
		// this.setBackground(new Color(39, 72, 155)); //Option 2

		// Just display an image in the panel
		imageLabel = new JLabel();
		try {
			Image img = CustomPage.mainLogoToDisplay;
			newImg = img.getScaledInstance((this.getWidth() == 0) ? 600 : this.getWidth(),
					(this.getHeight() / 2 == 0) ? 250 : this.getHeight() / 2, java.awt.Image.SCALE_SMOOTH);
			newIcon = new ImageIcon(newImg);
			imageLabel.setIcon(newIcon);
		} catch (NullPointerException e) {
			System.out.println("No Logo could be found. Please check the project directory");
		} catch (Exception e) {
			System.out.println("Error Finding image: " + e.getMessage());
		}
		imageLabel.setBounds(0, 0, this.getWidth(), (int) (this.getHeight() / 2.25));

		// Align to center
		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		imageLabel.setVerticalAlignment(JLabel.CENTER);
		this.add(imageLabel, BorderLayout.CENTER);

	}
	
/*
 *  	added String[] to arguments of createButton Types
 *	    to name the buttons with the string passed from
 *	    the GUIController
 * 
 */
	

	/*
	 * added String[] to arguments of createButton Types to name the buttons
	 * with the string passed from the GUIController
	 * 
	 */

<<<<<<< HEAD
	/**
	 * Later //Add the image to the top of the screen. We are going to have 3
	 * objects at the top: Back btn, logo, and currentpage title
	 */
	protected void createTwoButtonType() {
=======
		/**
		 * Later //Add the image to the top of the screen. We are going to have
		 * 3 objects at the top: Back btn, logo, and currentpage title
		 */
	protected void createTwoButtonType(){
>>>>>>> Tizzle
		JLabel iconLabel = new JLabel();
		iconLabel.setBounds(0, 0, this.getWidth(), (int) (this.getHeight() / 2.25));
		iconLabel.setIcon(newIcon);
		// this.add(iconLabel);
		this.add(iconLabel, BorderLayout.CENTER);

		// Align to center
		iconLabel.setHorizontalAlignment(JLabel.CENTER);
		iconLabel.setVerticalAlignment(JLabel.CENTER);

		CustomPage.centerOfNewFrame = iconLabel.getHeight() - iconLabel.getY();

		addButtons(2);
		
	
		/* 
		 * Modified same as createTwoButtonType 
		 */
		

		/*
		 * Modified same as createTwoButtonType
		 */

	}

	protected void createQandAype() {
		JLabel iconLabel = new JLabel();

		// I changed the parameter for height dividing by 5 do keep the
		// logo from covering the text fields. However, the width is not
		// getting placed in the correct spot.
		iconLabel.setBounds(0, 0, this.getWidth(), this.getHeight() / 5);
		iconLabel.setIcon(newIcon);
		this.add(iconLabel);
		// ******************
		// this line was commented out because it was hiding the text areas
		// ****************
		// this.add(iconLabel, BorderLayout.NORTH);

		// Align to center
		iconLabel.setHorizontalAlignment(JLabel.CENTER);
		iconLabel.setVerticalAlignment(JLabel.CENTER);

		CustomPage.centerOfNewFrame = iconLabel.getHeight() - iconLabel.getY();

		// Create a text area for the question and a text area for the answer
		JTextArea question = new JTextArea("Question", 10, 10);
		JTextArea answer = new JTextArea("Answer", 10, 10);

		// Constraints for the panel holding the text areas for
		// resizing purposes.
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = 10;
		c.gridheight = 10;
		c.weightx = .5;
		c.gridx = 1;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 10, 10, 10);

		// Create border for text areas
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		question.setBorder(border);
		answer.setBorder(border);

		// Set text area sizes and word wrapping
		question.setMinimumSize(question.getMinimumSize());
		answer.setMinimumSize(answer.getMinimumSize());
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		answer.setLineWrap(true);

		// Create panel to hold the question and answer text areas
		JPanel QandAPanel = new JPanel();
		QandAPanel.setBackground(Color.WHITE);
		QandAPanel.setLayout(new GridBagLayout());

		// Create a vertical box for the question text area
		// placing a label about the text area
		Box questionBox = Box.createVerticalBox();
		questionBox.add(new JLabel("Question"));
		questionBox.add(Box.createVerticalStrut(5));
		questionBox.add(question);

		// Create a vertical box for the answer text area
		// placing a label about the text area
		Box answerBox = Box.createVerticalBox();
		answerBox.add(new JLabel("Answer"));
		answerBox.add(Box.createVerticalStrut(5));
		answerBox.add(answer);

		// Create a horizontal box to hold the question and
		// answer text areas and use Strut to place space between them
		Box QandABox = Box.createHorizontalBox();
		QandABox.add(questionBox);
		QandABox.add(Box.createHorizontalStrut(100));
		QandABox.add(answerBox);

		// This box was created to make a space between the logo
		// it was otherwise cutting off the boxes
		Box VertQandABox = Box.createVerticalBox();
		VertQandABox.add(Box.createVerticalStrut(91));
		VertQandABox.add(QandABox);

		// Add the question and answer boxes to the panel that is
		// using a gridbaglayout
		QandAPanel.add(VertQandABox);

		// Add the Q&A panel to the frame and place it in the center
		// then add constraints for the gridbag panel
		this.add(QandAPanel, BorderLayout.CENTER);
		QandAPanel.add(VertQandABox, c);
		addButtons(2);

	}

	private void createThreeButtonType() {

		JLabel iconLabel = new JLabel();
		iconLabel.setBounds(0, 0, this.getWidth(), (int) (this.getHeight() / 2.25));
		iconLabel.setIcon(newIcon);
		this.add(iconLabel);

		// Align to center
		iconLabel.setHorizontalAlignment(JLabel.CENTER);
		iconLabel.setVerticalAlignment(JLabel.CENTER);

		// centerOfNewFrame = (this.getHeight() - (this.getHeight() -
		// iconLabel.getHeight()));
		
		addButtons(3);

	}

	private void createQuestionBuilderType() {
<<<<<<< HEAD
		/*
		 * Modified addButtons to rename to string
		 */
=======
	/* 
	 * Modified addButtons to rename to string
	 */
>>>>>>> Tizzle

		/** Testing - Move to actual class before release */
		this.titleOfCurrentQuestionPanel = "Question Builder";
		/** end of testing */

		// Create a title label to demonstrate what is shown

		// Now, add a panel for the questions
		/*
		 * this.questionsMainPanel = new JPanel();
		 * this.questionsMainPanel.setBackground(Color.RED);
		 * this.add(questionsMainPanel, BorderLayout.CENTER);
		 */

		// We need to add a few components to this view:
		// JComboBox - Allows the user to
		ManageData<String> newDataManager = new ManageData<String>(this.titleOfCurrentQuestionPanel,
				new String[] { "Cell 1" }, new String[] { "No ID" });
		this.add(newDataManager, BorderLayout.CENTER);

		addButtons(2);
		// setQuestionLayout();
	}

	// Create a question and answer type which displays the quesiton
	// string as a jlabel and put the answer in the answer text area
	protected void createQuestionPageType() {

		JLabel iconLabel = new JLabel();
		iconLabel.setBounds(0, 0, this.getWidth(), (int) (this.getHeight() / 2.25));
		iconLabel.setIcon(newIcon);
		// this.add(iconLabel);

		// Align to center
		iconLabel.setHorizontalAlignment(JLabel.CENTER);
		iconLabel.setVerticalAlignment(JLabel.CENTER);

		centerOfNewFrame = (this.getHeight() - (this.getHeight() - iconLabel.getHeight()));

		// String to hold questions. To be updated with function that passes
		// the string of the actual question
		String questionStr = new String("This is where the question goes.");

		// Create a JLabel to display thew question, set its
		// alignment, font type and size
		JLabel questionLabel = new JLabel(questionStr);
		questionLabel.setAlignmentX(centerOfNewFrame);
		questionLabel.setOpaque(false);
		Font font = new Font("Courier", Font.BOLD, 16);
		questionLabel.setFont(font);

		// Set the question jlabel's max size
		questionLabel.setMaximumSize(getMaximumSize());

		// Create a text area to enter the answer in and make it into
		// a scroll pane with scrollbars created as needed.
		JTextArea answer = new JTextArea("Answer goes Here", 10, 10);
		answer.setLineWrap(true);
		answer.setFont(font);
		JScrollPane jScrollPane = new JScrollPane(answer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Create border for the answer area
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		jScrollPane.setBorder(border);

		// Create a vertical box to place the question jlabel on top
		// of the answer text area
		Box questionBox = Box.createVerticalBox();
		questionBox.add(questionLabel);
		questionBox.add(Box.createVerticalStrut(40));
		questionBox.add(jScrollPane);

		// Constraints for the panel holding the text areas for
		// resizing purposes.
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = .5;
		c.gridx = 1;
		c.gridy = 1;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(50, 50, 50, 50);

		// Create a panel to hold box with the question jlabel
		// and answer test area
		JPanel QandA = new JPanel(new GridBagLayout());
		QandA.add(questionBox, c);

		this.add(QandA, BorderLayout.CENTER);

		if (QuizAndFlashQuestionPage.questionPageNumber == 1)
			addButtons(2);
		else
			addButtons(3);

	}

	// Creates flashcard page type that shows the question and has a
	// pop up window that shows the answer. Again having issues with
	// keeping the logo on the page. It uses FlashcardAnswer as a public
	// String which can be set by the backend function with the appropriate
	// string
	private void createFlashcardPageType() {

		JLabel iconLabel = new JLabel();
		iconLabel.setBounds(0, 0, this.getWidth(), (int) (this.getHeight() / 2.25));
		iconLabel.setIcon(newIcon);
		/**
		 * 
		 * commened out the logo due to issues with it covering the question and
		 * checkbox
		 * 
		 */
		// this.add(iconLabel);

		// Align to center
		iconLabel.setHorizontalAlignment(JLabel.CENTER);
		iconLabel.setVerticalAlignment(JLabel.CENTER);

		centerOfNewFrame = (this.getHeight() - (this.getHeight() - iconLabel.getHeight()));

		// String to hold questions. To be updated with function that passes
		// the string of the actual question
		String questionStr = "This is where the question goes";

		// Create a JLabel to display the question, set its
		// alignment, font type and size
		JLabel questionLabel = new JLabel(questionStr);
		// JLabel answerLabel = new JLabel(FlashcardAnswer);
		questionLabel.setAlignmentX(centerOfNewFrame);
		questionLabel.setOpaque(false);
		// answerLabel.setAlignmentX(centerOfNewFrame);
		// answerLabel.setOpaque(false);
		Font font = new Font("Courier", Font.BOLD, 16);
		questionLabel.setFont(font);
		// answerLabel.setFont(font);

		// Set the question jlabel's max size
		questionLabel.setMaximumSize(getMaximumSize());
		// answerLabel.setMaximumSize(getMaximumSize());

		showHide.setAlignmentX(centerOfNewFrame);

		// Create a vertical box to place the question string on top
		// of the hide check box
		Box questionBox = Box.createVerticalBox();
		questionBox.add(questionLabel);
		questionBox.add(Box.createVerticalStrut(40));
		questionBox.add(showHide);
		// questionBox.add(Box.createVerticalStrut(40));
		// questionBox.add(answerLabel);

		// Constraints for the panel holding the text areas for
		// resizing purposes.
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = .5;
		c.gridx = 1;
		c.gridy = 10;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(50, 50, 50, 50);

		// Create a panel to hold box with the question jlabel
		// and answer test area
		JPanel QandA = new JPanel(new GridBagLayout());
		QandA.add(questionBox, c);

		this.add(QandA, BorderLayout.CENTER);

		// If it is the first question page, it will only have 2
		// buttons, every other page will have 3
		if (QuizAndFlashQuestionPage.questionPageNumber == 1)
			addButtons(2);
		else
			addButtons(3);

	}

	private void addButtons(int count) {
		// Add a panel to the south for the buttons

		JPanel buttonHolder = new JPanel();
		buttonHolder.setLayout(new GridBagLayout()); // May need to be
														// gridbaglayout
		buttonHolder.setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();
		this.add(buttonHolder, BorderLayout.SOUTH);

		this.currentActions = new CustomButton[count];

		for (int i = 0; i < count; i++) {

			c.gridwidth = 1;
			c.gridheight = 1;
			c.weightx = 0.5;
			c.gridx = i % 2;
			c.gridy = (i % 2 == 0 && i > 0) ? c.gridy++ : c.gridy;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(10, 10, 10, 10);

			// If the last button is an odd one, make it the same size as both
			// buttons above it, combined
			if (count % 2 == 1 && i == count - 1) {
				// System.out.println(this.panelTypeString + " for button: " +
				// (i));
				c.gridwidth = 2;
			}

			this.currentActions[i] = new CustomButton("Button " + (i + 1));
			buttonHolder.add(this.currentActions[i], c);
		}
	}

	public void setButtonNames(String[] btnNames) {
		// System.out.println("Modifying Buton names");

		try {
			for (int i = 0; i < this.currentActions.length; i++) {
				try {
					this.currentActions[i].setText(btnNames[i]);
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	/** Accessors and mutators */

	public static BufferedImage getMainLogoToDisplay() {
		return mainLogoToDisplay;
	}

	public static void setMainLogoToDisplay(BufferedImage mainLogoToDisplay) {
		CustomPage.mainLogoToDisplay = mainLogoToDisplay;
	}

}
