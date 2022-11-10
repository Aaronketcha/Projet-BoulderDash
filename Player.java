package Entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Controller.Keyhandler;
import Controller.TileManager;
import View.ViewPanel;

public class Player extends Entity{
	
	ViewPanel vp;
	Keyhandler key;
	TileManager t;

	public final int screenx;
	public final int screeny;
	int haskey = 0;
	int hasterre = 0;
	
	public Player(ViewPanel vp,Keyhandler key) {
		this.vp = vp;
		this.key =key;
		
		screenx = vp.screenWidth/2 - (vp.Tilesize/2);
		screeny = vp.screenHeight/2 - (vp.Tilesize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 2;
		solidArea.y = 1;
		solidAreaDefaultx = solidArea.x;
		solidAreaDefaulty = solidArea.y;
		solidArea.width = 40;
		solidArea.height = 42;
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		x = vp.Tilesize * 1;
		y = vp.Tilesize * 2;
		speed = 3;
		direction = "down";
	}
	public void getPlayerImage() {
		try {
			droit = ImageIO.read(getClass().getResourceAsStream("/player/droit.png"));
			up = ImageIO.read(getClass().getResourceAsStream("/player/up.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
			
			
		}
		catch(IOException e) {
			e.printStackTrace();		}
	}
	public void update() {
		if (key.UP == true || key.DOWN == true ||key.LEFT == true ||key.RIGHT == true ) {
			if (key.UP ==true) {
				direction ="up";
				
				
			}
			else if (key.DOWN == true) {
				direction ="down";
				
			}
			else if (key.LEFT ==true) {
				direction ="left";
				
			}
			else if (key.RIGHT ==true) {
				direction ="right";
				
			}
			//COLLISION CHECK
			collisionOn = false;
			vp.cChecker.checkTile(this);
			
			//
			
			int objIndex = vp.cChecker.checkobject(this, true);
			pickUpObject(objIndex);
			
			
			//IF COLLISION IS FALSE, PLAYER CAN MOVE
			if (collisionOn == false) {
				switch(direction) {
				case "up":
					y -= speed;
					break;
				case "down":
					y += speed;
					break;
				case "left":
					x -= speed;
					break;
				case "right":
					x += speed;
					break;
				
				}
				
			}
			spriteCounter++;
			if (spriteCounter > 10) {
				if (spriteNum ==1) {
					spriteNum = 2;
				}
				else if (spriteNum ==2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
		
	}
	public void pickUpObject(int i) {
		
		if (i != 999) {
			String objectName = vp.obj[i].name;
			switch(objectName) {
			case "key":
				haskey++;
				vp.obj[i] = null;
				break;
				
			case "terre":
				hasterre++;
				vp.obj[i] = null;
				break;
			case "Door":
				if(haskey > 0) {
					vp.obj[i] = null;
					
				} 
				else 
					vp.obj[151].collision = true;
			}
		}
	}
	
	public void draw(Graphics g2) {
		
	//	g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.Tilesize, gp.Tilesize);
		
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if (spriteNum == 1) {
				image =  up;}
			if (spriteNum == 2) {
				image =  up;}
			
			break;
		case "down":
			if (spriteNum == 1) {
				image =  down1;}
			if (spriteNum == 2) {
				image =  down2;}
			
			break;
		case "left":
			if (spriteNum == 1) {
				image =  right1;}
			if (spriteNum == 2) {
				image =  right2;}
			
			break;
		case "right":
			if (spriteNum == 1) {
				image =  left1;}
			if (spriteNum == 2) {
				image =  left2;}
			
			break;
		}
	g2.drawImage(image, screenx, screeny, vp.Tilesize, vp.Tilesize, null);
	}
	

}
