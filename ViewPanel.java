package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Controller.TileManager;
import Entity.Player;
import Model.AssetSetter;
import Model.SuperObject;
import Controller.CollisionChecker;
import Controller.Keyhandler;

@SuppressWarnings("serial")
public class ViewPanel  extends JPanel implements Runnable{
	final int tilesize = 16;
	final int scale = 3;
	public final int Tilesize = tilesize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = Tilesize * maxScreenCol;
	public final int screenHeight = Tilesize * maxScreenRow;
	
	//MAP SETTING
	public final int maxMapCol = 16;
	public final int maxMapRow = 12;
	public final int mapwidth = Tilesize * maxMapCol;
	public final int mapheight = Tilesize * maxMapRow;
	
	//FPS
	int FPS = 60;
	
	public TileManager tileM = new TileManager(this);
	Keyhandler key = new Keyhandler();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this,key);
	public SuperObject obj[] = new SuperObject[200];
	
	
	int playerx = 100;
	int playery = 100;
	int playerspeed = 4;
	
	public ViewPanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.addKeyListener(key);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		double drawinterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime ;
		long timer = 0;
		int drawCount = 0;
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawinterval;
			lastTime = currentTime;
			timer += (currentTime - lastTime);
			
			//System.out.println("Game running");
			if (delta >1) {
				update();
				
				repaint();
				delta--;
				drawCount++;
			}
			if (timer >= 1000000000) {
				System.out.println("FPS:" +drawCount);
				drawCount = 0;
				timer = 0;
			}
			
			}
		
	}
	public void update() {
		 player.update();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2 = (Graphics)g;
		tileM.draw(g2);
		
		for (int i =0; i < obj.length; i++)
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		
		player.draw(g2);
		g2.dispose();
	}

}
