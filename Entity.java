package Entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

	public int x,y;
	public int speed;
	public BufferedImage up,down1,down2,left1,left2,right1,right2,droit;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle solidArea;
	public int solidAreaDefaultx, solidAreaDefaulty;
	public boolean collisionOn = false;
	

}
