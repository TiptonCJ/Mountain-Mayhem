package main;

// Importing necessary classes
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// KeyHandler class that implements KeyListener to handle key events
public class KeyHandler implements KeyListener{

	// Boolean variables to track the state of the arrow keys
	public boolean upPressed, downPressed, leftPressed, rightPressed;

	// Method that is called when a key is typed (pressed and released)
	@Override
	public void keyTyped(KeyEvent e) {
		// Not used in this class
	}

	// Method that is called when a key is pressed
	@Override
	public void keyPressed(KeyEvent e) {
		// Getting the key code of the pressed key
		int code = e.getKeyCode();

		// Checking which key was pressed and updating the corresponding variable
		if (code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = true;
		}
	}

	// Method that is called when a key is released
	@Override
	public void keyReleased(KeyEvent e) {
		// Getting the key code of the released key
		int code = e.getKeyCode();

		// Checking which key was released and updating the corresponding variable
		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}
	}
}
