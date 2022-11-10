package Controller;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Entity.Player;
import View.ViewPanel;

public class TileManager {
	ViewPanel vp;
	int a,b,c,d;
	Player pl ;
	 public Tile[] tile;
	public int mapTileNum[][];
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	
	public TileManager(ViewPanel vp) {
		this.vp = vp;
		tile = new Tile[10];
		mapTileNum = new int[vp.maxMapCol][vp.maxMapRow];
		getTileImage();
		loadmap("/player/map.txt");
		
		
		
		
		
		
	}
	public void loadmap(String filePath) {
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));		
			
			
			
			int col = 0;
			int row = 0;
			
			
			while (col < vp.maxMapCol && row < vp.maxMapRow) {
				String line = br.readLine();
				
				while(col < vp.maxMapCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if (col == vp.maxMapCol) {
					col = 0;
					row++;
				}
			}
			
			br.close();
		}catch(Exception e) {
					
				}
	}
	
	public void loadmap2(String filePath) {

		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;
			while (col < vp.maxMapCol && row < vp.maxMapRow) {
				String line = br.readLine();

				while(col < vp.maxMapCol) {

					String numbers[] = line.split(" ");

					int num = Integer.parseInt(numbers[col]);

					mapTileNum[col][row] = num;
					col++;
				}
				if (col == vp.maxMapCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		}catch(Exception e) {

		}

	}
		

	private void getTileImage() {
		
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/player/DE.png"));
			//tile[0].collision = true;
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/player/wall.png"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/player/D2.png"));
			tile[2].collision = true;
			
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/player/ball1.png"));
			
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics g2) {
		
		int mapCol = 0;
		int mapRow = 0;
		
		
		while (mapCol < vp.maxMapCol && mapRow < vp.maxMapRow) {
			
			int tileNum = mapTileNum[mapCol][mapRow];
			
			int mapx = mapCol * vp.Tilesize;
			int mapy = mapRow * vp.Tilesize;
			int screenX = mapx - vp.player.x + vp.player.screenx;
			int screenY = mapy - vp.player.y + vp.player.screeny;
			
			if (mapx + vp.Tilesize > vp.player.x - vp.player.screenx &&
				mapx - vp.Tilesize < vp.player.x + vp.player.screenx &&
				mapy + vp.Tilesize > vp.player.y - vp.player.screeny &&
				mapy - vp.Tilesize < vp.player.y + vp.player.screeny) 
			{
				g2.drawImage(tile[tileNum].image, screenX, screenY, vp.Tilesize, vp.Tilesize, null);
			}
			
			
		    mapCol ++;
		   
		    if (mapCol == vp.maxMapCol) {
		    	mapCol = 0;
		    	mapRow++;
		    	
		    }
		}
	}

}
