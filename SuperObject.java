package Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Controller.TileManager;
import View.ViewPanel;

public class SuperObject {
	
	
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int mapx,mapy;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	public void draw(Graphics g2, ViewPanel gp) {
		int screenX = mapx - gp.player.x + gp.player.screenx;
		int screenY = mapy - gp.player.y + gp.player.screeny;
		
		if (mapx + gp.Tilesize > gp.player.x - gp.player.screenx &&
			mapx - gp.Tilesize < gp.player.x + gp.player.screenx &&
			mapy + gp.Tilesize > gp.player.y - gp.player.screeny &&
			mapy - gp.Tilesize < gp.player.y + gp.player.screeny) 
		{
			g2.drawImage(image, screenX, screenY, gp.Tilesize, gp.Tilesize, null);
		}

   }
}
