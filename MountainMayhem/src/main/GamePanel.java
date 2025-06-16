package main;

// Importing classes
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

// GamePanel class that extends JPanel and implements Runnable for threading
public class GamePanel extends JPanel implements Runnable{

	// Screen settings
	final int originalTileSize = 16; // Original tile size (16x16)
	final int scale = 3; // Scale factor
	public final int tileSize = originalTileSize * scale; // Scaled tile size (48x48)
	public final int maxScreenCol = 16; // Maximum number of columns on the screen
	public final int maxScreenRow = 12; // Maximum number of rows on the screen
	public final int screenWidth = tileSize * maxScreenCol; // Screen width (768 pixels)
	public final int screenHeight = tileSize * maxScreenRow; // Screen height (576 pixels)

	//world map parameters
	public final int maxWorldCol = 150;
	public final int maxWorldRow = 100;
	
	// Frame rate
	int FPS = 60;

	TileManager tileM = new TileManager(this);
	// KeyHandler object to handle key events
	KeyHandler keyH = new KeyHandler();
	Sound music = new Sound();
	Sound sounds = new Sound();
	
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;

	//Entity and Object
	public Player player = new Player(this,keyH);
	//increase from 10 for more objects
	public SuperObject obj[] = new SuperObject[10];
	
	

	// Constructor for the GamePanel class
	public GamePanel () {
		// Setting the preferred size of the panel
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		// Setting the background color of the panel
		this.setBackground(Color.black);
		// Enabling double buffering to avoid flickering
		this.setDoubleBuffered(true);
		// Adding the key listener to the panel
		this.addKeyListener(keyH);
		// Making the panel focusable to receive key events
		this.setFocusable(true);
	}

	
	
	public void setupGame() {
		aSetter.setObject();
		playMusic(0);
	}
	
	
	
	
	
	// Method to start the game thread
	public void startGameThread() {
		// Creating a new thread and starting it
		gameThread = new Thread(this);
		gameThread.start();
	}

	// The run method which will be executed in the new thread
	public void run() {	
		// Variables for controlling the frame rate
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		@SuppressWarnings("unused")
		long timer = 0;
		@SuppressWarnings("unused")
		int drawCount =0;

		// Game loop
		while(gameThread != null) {
			// Getting the current time
			currentTime = System.nanoTime();
			// Calculating the time difference and updating the timer
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			// If enough time has passed, update the game and redraw the screen
			if(delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}

		}
	}

	// Method to update the game state
	public void update() {
		
		
		player.update();
		
	}

	// Method to draw the game state
	public void paintComponent(Graphics g) {
		// Calling the superclass's paintComponent method
		super.paintComponent(g);

		// Casting the Graphics object to Graphics2D for more features
		Graphics2D g2 = (Graphics2D)g;
		
		//tile draw must come before payer draw, think of it as layers
		tileM.draw(g2); 
		
		// call object
		for(int i = 0; i < obj.length; i++) {
			
			if(obj[i] != null) {
				obj[i].draw(g2,  this);
			}
		}
		
		//draw the lil dude
		player.draw(g2);

		//UI
		ui.draw(g2);

		// Disposing the Graphics2D object to free up system resources
		g2.dispose();
	}
public void playMusic(int i){

	music.setFile(i);
	music.play();
	music.loop();
}
public void stopMusic(){

	music.stop();
}
public void playSE(int i){

	sounds.setFile(i);
	sounds.play();
}



}
