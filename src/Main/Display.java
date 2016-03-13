package Main;

import java.util.Vector;
import javax.swing.JFrame;

public class Display {
	static Vector<Display> allDisplays=new Vector<Display>();
	static Vector<JFrame> allTests=new Vector<JFrame>();
	public static void removeAll(){
		allDisplays.removeAllElements();	
	}
	public static void addDisplay(Display display){
		allDisplays.addElement(display);
	}
	public static void removeDisplay(Display display){
		allDisplays.remove(display);
	}
	
	
	
	public static void drawAll(){
		
	}
	public void drawElement(){} // override this
}
