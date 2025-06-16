package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_ENERGY extends SuperObject{

    	public OBJ_ENERGY() {
		
	name = "Energy";
	try {
		
		image = ImageIO.read(getClass().getResourceAsStream("/objects/energy.png"));
			
	
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
