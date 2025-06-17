package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
	
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	public void draw(Graphics2D g2, GamePanel gp) {
		
		// Draw at world position (no camera offset)
		int screenX = worldX;
		int screenY = worldY;

		if (image != null) {
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		} else {
			System.out.println("SuperObject: image is null for " + name);
		}
	}
}
		
		
	

