package Main;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.AlphaComposite;
import javax.swing.JPanel;

public class DisplayBall {

	NetworkTable table;
     int x = 0;
     int y = 0;
    static int alpha=200;
    static int r,gr,b;
    static int size=30;

    public void drawBall(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(new Color(r,gr,b,alpha));
        g2d.fillOval(x, y, size, size);
    }
    public void setX(int xValue){
    	x=xValue;
    	Main.canvas.repaint();
    }
    public void setY(int yValue){
    	y=yValue;
    	Main.canvas.repaint();
    }
    public void setAlpha(int alphaValue){
    	alpha=alphaValue;
    	Main.canvas.repaint();
    }
    
    public static void setColor(int red, int green,int blue){
    	r=red;
    	gr=green;
    	b=blue;
    	Main.canvas.repaint();
    }
    
    public static void setSize(int sizeValue){
    	size=sizeValue;
    	Main.canvas.repaint();
    }
}
