package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyhandler implements KeyListener{

	public boolean UP,DOWN,LEFT,RIGHT;
		
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			UP = true;
		}
	
		if (code == KeyEvent.VK_DOWN) {
			DOWN = true;
		}
		if (code == KeyEvent.VK_LEFT) {
			LEFT = true;
		}
		if (code == KeyEvent.VK_RIGHT) {
			RIGHT = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			UP = false;
		}
	
		if (code == KeyEvent.VK_DOWN) {
			DOWN = false;
		}
		if (code == KeyEvent.VK_LEFT) {
			LEFT = false;
		}
		if (code == KeyEvent.VK_RIGHT) {
			RIGHT = false;
		}
	}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	


