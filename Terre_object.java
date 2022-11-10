package Model;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Terre_object extends SuperObject{
	
	public Terre_object() {
		
		name = "terre";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/player/ground.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
