package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_LOCKBOX extends SuperObject{
	
	public OBJ_LOCKBOX() {
		
	name = "LockBox";
	try {
		
		image = ImageIO.read(getClass().getResourceAsStream("/objects/lockbox.png"));
			
	
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
}
