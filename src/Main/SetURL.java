package Main;

import javax.swing.JOptionPane;

public class SetURL {
	public  static String URL(String url){
		String tmpUrl=JOptionPane.showInputDialog("Enter URL",url);
		if(tmpUrl!=null)url=tmpUrl;
		return url;
	}

}
