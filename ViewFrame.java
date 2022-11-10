package View;

import javax.swing.JFrame;

import View.ViewPanel;

public class ViewFrame {
	
	public void main() {
			JFrame win = new JFrame();
			win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			win.setTitle("BOULDER_DASH");
			win.setResizable(true);
			
			ViewPanel panel = new ViewPanel();
			win.add(panel);
			
			win.pack();
			
			win.setLocationRelativeTo(null);
			win.setVisible(true);
			panel.setupGame();
			panel.startGameThread();

}
}
