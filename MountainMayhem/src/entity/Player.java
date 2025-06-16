package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;



@SuppressWarnings("unused")
public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;

	public final int screenX;
	public final int screenY;
	public int hasCoin = 0;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
	this.gp = gp;
	this.keyH = keyH;
	
	screenX = gp.screenWidth/2 - (gp.tileSize/2);
	screenY = gp.screenHeight/2 - (gp.tileSize/2);
	
	solidArea = new Rectangle();
	solidArea.x = 8;
	solidArea.y = 16;
	solidAreaDefaultX = solidArea.x;
	solidAreaDefaultY = solidArea.y;
	solidArea.width = 32;
	solidArea.height = 32;


	setDefaultValues();
	getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		//starting pos in the world
		worldX = gp.tileSize * 50;
		worldY = gp.tileSize * 50;
		
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/YOSEF_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/YOSEF_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/YOSEF_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/YOSEF_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/YOSEF_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/YOSEF_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/YOSEF_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/YOSEF_right_2.png"));
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void update() {
		
		
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || 
				keyH.rightPressed == true) {
			
			// Moving the player based on the keys pressed
			if(keyH.upPressed == true) {
				direction = "up";
				
			}
			else if(keyH.downPressed == true) {	
				direction = "down";

			}
			else if(keyH.leftPressed == true) {	
				direction = "left";

			}
			else if(keyH.rightPressed == true) {	
				direction = "right";

			}
		
			
			//check collision with tile
			collisionOn =  false;
			gp.cChecker.checkTile(this);
			
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			//if false can move
			if(collisionOn == false) {
				
				switch(direction) {
				case "up":
				worldY -= speed;
				break;
				case "down":
				worldY += speed;
				break;
				case "left":
				worldX -= speed;
				break;
				case "right":
				worldX += speed;
				break;
				}
			}
			
			
			
			//change animation of YOSEF so it walks
			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
		
		
	}
	
public void pickUpObject(int i) {

if(i !=999){

	String objectName = gp.obj[i].name;

	switch(objectName){
		case "BitCoin":
		gp.playSE(1);
		hasCoin++;
		gp.obj[i] = null;
		gp.ui.showMessage("you found a Bitcoin in the woods!");
		break;
		
		case "Portal":
		if(hasCoin > 0) {
			gp.playSE(3);
			gp.obj[i] = null;
			hasCoin--;
			gp.ui.showMessage("You bribed the portal");
		}
		else {
			gp.ui.showMessage("You are broke, find some Bitcoin");
		}

		break;
		case "Energy":
		gp.playSE(2);
		speed += 2;
		gp.obj[i] = null;
		gp.ui.showMessage("Energy Drink!");
		break;
		case "LockBox":
		gp.ui.gameFinished = true;
		gp.stopMusic();
		gp.playSE(4);
		break;
	}
}
}



public void draw(Graphics2D g2) {
	
	BufferedImage image = null;
	
	if (direction == "up") {
	    if (spriteNum == 1) {
	        image = up1;
	    }
	    if (spriteNum == 2) {
	        image = up2;
	    }
	} else if (direction == "down") {
	    if (spriteNum == 1) {
	        image = down1;
	    }
	    if (spriteNum == 2) {
	        image = down2;
	    }
	} else if (direction == "left") {
	    if (spriteNum == 1) {
	        image = left1;
	    }
	    if (spriteNum == 2) {
	        image = left2;
	    }
	} else if (direction == "right") {
	    if (spriteNum == 1) {
	        image = right1;
	    }
	    if (spriteNum == 2) {
	        image = right2;
	    }
	}

	
	g2.drawImage(image, screenX, screenY, gp.tileSize,gp.tileSize, null);
	
	
	
}

}
