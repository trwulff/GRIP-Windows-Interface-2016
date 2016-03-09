package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.util.prefs.Preferences;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.IRemoteConnectionListener;
import edu.wpi.first.wpilibj.tables.IRemote;
import javax.swing.JMenu;



public class Main extends JFrame {
	static final String BASE_NODE_NAME="GRIP Windows Intrface";
	static final String DEFAULT_URL="Roorio-1405-FRC.local";
	static final String CURRENT_URL_NODE="Current URL";
	static final String TOWER_TABLE="GRIP/Tower";
	static final String BALL_TABLE="GRIP/Ball";
	static final String BLUE_ROBOT_TABLE="GRIP/Blue Robot";
	static final String RED_ROBOT_TABLE="GRIP/Red Robot";
	static final String CONECTION_STATUS_VERIFYING_CONNECTION="Getting Connection Status";
	static final String CONECTION_STATUS_CONNECTED="Connected";
	static final String CONECTION_STATUS_DISCONNECTED="Disconnected";
	public static  Canvas contentPane;
	

	JMenuItem mntmUrl;
	JMenuBar menuBar;
	JLabel lblConnectionStatus;
	private Component horizontalStrut;
	static Preferences prefTable;
	NetworkTable table;
	private Component horizontalStrut_1;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmSaveAs;
	private JMenuItem mntmExit;
	private JMenu mnProperties;
	private JMenuItem mntmTower;
	private JMenuItem mntmBall;
	private JMenuItem mntmRobots;
	private JMenu mnTest;
	private JMenuItem mntmTower_1;
	private JMenuItem mntmBall_1;
	private JMenuItem mntmRedRobot;
	private JMenuItem mntmBlueRobot;


	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("GRIP Windows Interface 2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 517);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		lblConnectionStatus = new JLabel("Disconnected");
		menuBar.add(lblConnectionStatus);
		
		mntmUrl = new JMenuItem(DEFAULT_URL);
		mntmUrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmUrl.setText( SetURL.URL(mntmUrl.getText()));
				prefTable.put(CURRENT_URL_NODE, mntmUrl.getText());
				NetworkTable.globalDeleteAll();
				NetworkTable.shutdown();
				NetworkTable.setIPAddress(mntmUrl.getText());
			}
		});
		
		horizontalStrut = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		mntmSaveAs = new JMenuItem("Save As");
		mnFile.add(mntmSaveAs);
		
		mnProperties = new JMenu("Properties  ");
		mnFile.add(mnProperties);
		
		mntmTower = new JMenuItem("Tower");
		mntmTower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettingsTower setTower=new SettingsTower();
				setTower.setVisible(true);
			}
		});
		mnProperties.add(mntmTower);
		
		mntmBall = new JMenuItem("Ball");
		mntmBall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettingsBall setBall=new SettingsBall();
				setBall.setVisible(true);
				
			}
		});
		mnProperties.add(mntmBall);
		
		mntmRobots = new JMenuItem("Robots");
		mntmRobots.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettingsRobots setRobots=new SettingsRobots();
				setRobots.setVisible(true);
			}
		});
		mnProperties.add(mntmRobots);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mnTest = new JMenu("Test");
		mnFile.add(mnTest);
		
		mntmTower_1 = new JMenuItem("Tower");
		mnTest.add(mntmTower_1);
		
		mntmBall_1 = new JMenuItem("Ball");
		mntmBall_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestBall obj =new TestBall();
				obj.setVisible(true);
			}
		});
		mnTest.add(mntmBall_1);
		
		mntmRedRobot = new JMenuItem("Red Robot");
		mnTest.add(mntmRedRobot);
		
		mntmBlueRobot = new JMenuItem("Blue Robot");
		mnTest.add(mntmBlueRobot);
		mnFile.add(mntmExit);
		
		horizontalStrut_1 = Box.createHorizontalStrut(17);
		menuBar.add(horizontalStrut_1);
		menuBar.add(mntmUrl);
		
		contentPane = new Canvas();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		prefTable = Preferences.userRoot().node(BASE_NODE_NAME);
		mntmUrl.setText( prefTable.get(CURRENT_URL_NODE, DEFAULT_URL));
		prefTable.put(CURRENT_URL_NODE, mntmUrl.getText());
		NetworkTable.setClientMode();
		NetworkTable.setIPAddress(mntmUrl.getText());
		table=NetworkTable.getTable(TOWER_TABLE);
		table.addConnectionListener(new IRemoteConnectionListener(){
			public void connected(IRemote remote){
				lblConnectionStatus.setText(CONECTION_STATUS_CONNECTED);
			}
			public void disconnected(IRemote remote){
				lblConnectionStatus.setText(CONECTION_STATUS_DISCONNECTED);
			}
		}, true);
		//contentPane.add( new Canvas());
		//contentPane.repaint();
		Ping.run(lblConnectionStatus);
	}
}
