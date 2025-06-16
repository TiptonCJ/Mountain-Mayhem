package main;

// Importing the JFrame class from the javax.swing package
import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		
		// Creating a new JFrame object
		JFrame window = new JFrame();
		
		// Setting the default close operation for the JFrame
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Making the JFrame non-resizable
		window.setResizable(false);
		
		// Setting the title of the JFrame
		window.setTitle("Mountain Mayhem");
		
		// Creating a new GamePanel object
		GamePanel gamePanel = new GamePanel();
		
		// Adding the GamePanel to the JFrame
		window.add(gamePanel);
		
		// Adjusting the JFrame size to fit the preferred size of its components
		window.pack();
		
		// Centering the JFrame on the screen
		window.setLocationRelativeTo (null);
		
		// Making the JFrame visibles
		window.setVisible(true);
		
		gamePanel.setupGame();
		
		// Starting the game thread
		gamePanel.startGameThread();
		
	}
}

