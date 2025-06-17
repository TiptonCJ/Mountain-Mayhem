package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_BITCOIN extends SuperObject{
	
	public OBJ_BITCOIN() {
		
	name = "BitCoin";
	try {
		
		image = ImageIO.read(getClass().getResourceAsStream("/objects/bitcoin.png"));
		if (image == null) {
			System.out.println("OBJ_BITCOIN: bitcoin.png image not found or failed to load!");
		}
			
	
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
}
