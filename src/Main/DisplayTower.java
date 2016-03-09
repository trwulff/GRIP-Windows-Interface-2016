package Main;


import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import edu.wpi.first.wpilibj.tables.ITable;;
public class DisplayTower {
	static  NetworkTable table=NetworkTable.getTable(Main.TOWER_TABLE);
	static boolean isFirst=true;
	
	public static void run(){
		if(!isFirst)return;
		table.addTableListener(new ITableListener(){
			public void valueChanged(ITable table, String string, Object obj, boolean b){
				
			}
		});
	}
}
