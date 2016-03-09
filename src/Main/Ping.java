package Main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JMenuBar;


public class Ping {
	static Timer timer = new Timer();
	static boolean isFirst=true;
	JLabel lblConnectionStatus;
	
	public static void run(JLabel lblConnectionStatus){
		if (!isFirst)return;
		isFirst=false;
		timer.schedule(new TimerTask(){
			public void run(){
				try{
					lblConnectionStatus.setText(Main.CONECTION_STATUS_VERIFYING_CONNECTION);
					URL u = new URL("http://"+Main.prefTable.get(Main.CURRENT_URL_NODE, Main.DEFAULT_URL)+"/"); 
				    HttpURLConnection huc =  (HttpURLConnection)  u.openConnection(); 
				    huc.setRequestMethod("GET"); 
				    huc.connect(); 
				    huc.getResponseCode();
				    u.getHost(); 
					lblConnectionStatus.setText(Main.CONECTION_STATUS_CONNECTED);
					}
					catch (MalformedURLException e) { 
						System.out.println("Malformed URL string");
					} 
					catch (IOException e) {  
						lblConnectionStatus.setText(Main.CONECTION_STATUS_DISCONNECTED);
					}

			
		}},1, 1000);
	}
}
