package Model;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Door_Object extends SuperObject{
	
	public Door_Object() {
		
		name = "Door";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/player/tile054.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
