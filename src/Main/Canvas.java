package Main;

import java.awt.Graphics;

import javax.swing.JPanel;


public class Canvas extends JPanel{
	
	public Canvas(){
		
	}
    public  void paintComponent(Graphics g) {
        super.paintComponent(g);
        TestBall.drawDisplays(g);
    }
public static void addElement(){
	
}
}
