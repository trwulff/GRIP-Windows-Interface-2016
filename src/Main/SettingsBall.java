package Main;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;

public class SettingsBall extends JFrame {

	static final String LOCAL_CHILD_NODE="/Ball Settings";
	static final String MIN_AREA="MinArea";
	static final String MAX_AREA="MaxArea";
	static final String MIN_XY_RATIO="MinXYRatio";
	static final String MAX_XY_RATIO="MaxXYRatio";
	static final String TARGET_OFFSET="TargetOffset";
	static final String TARGET_OPACITY="TargetOpacity";
	
	private final JTextField textField = new JTextField();
	private JTextField txtMinArea;
	private JTextField txtMaxArea;
	private JTextField txtMinRatio;
	private JTextField txtMaxRatio;
	private JTextField txtTargetOffset;
	private JTextField txtTargetOpacity;
	private JTextField txtRed;
	private JTextField txtGreen;
	private JTextField txtBlue;
	public SettingsBall() {
		getContentPane().setForeground(Color.WHITE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Preferences prefTable = Preferences.userRoot().node(Main.BASE_NODE_NAME+LOCAL_CHILD_NODE);
				txtMinArea.setText(prefTable.get(MIN_AREA, "0.0"));
				txtMaxArea.setText(prefTable.get(MAX_AREA, "100.0"));
				txtMinRatio.setText(prefTable.get(MIN_XY_RATIO, "0.0"));
				txtMaxRatio.setText(prefTable.get(MAX_XY_RATIO, "100.0"));
				txtTargetOffset.setText(prefTable.get(TARGET_OFFSET, "0.0"));
				txtTargetOpacity.setText(prefTable.get(TARGET_OPACITY, "1.0"));
			}
		});
		setTitle("Ball Settings");
		setAlwaysOnTop(true);
		getContentPane().setBackground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 446, 386);
		getContentPane().setLayout(null);
		
		txtMinArea = new JTextField();
		txtMinArea.setHorizontalAlignment(SwingConstants.CENTER);
		txtMinArea.setBackground(Color.WHITE);
		txtMinArea.setBounds(110, 52, 60, 22);
		txtMinArea.setText("0.0");
		getContentPane().add(txtMinArea);
		txtMinArea.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
			
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		btnCancel.setBounds(333, 290, 83, 25);
		getContentPane().add(btnCancel);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setActionCommand("Save");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accept();
			}
		});
		btnAccept.setBounds(249, 290, 78, 25);
		getContentPane().add(btnAccept);
		
		JLabel lblMinArea = new JLabel("Min. Area");
		lblMinArea.setForeground(Color.WHITE);
		lblMinArea.setBounds(40, 55, 56, 16);
		getContentPane().add(lblMinArea);
		
		txtMaxArea = new JTextField();
		txtMaxArea.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaxArea.setText("100.0");
		txtMaxArea.setColumns(10);
		txtMaxArea.setBackground(Color.WHITE);
		txtMaxArea.setBounds(301, 52, 60, 22);
		getContentPane().add(txtMaxArea);
		
		JLabel lblMaxArea = new JLabel("Max.. Area");
		lblMaxArea.setForeground(Color.WHITE);
		lblMaxArea.setBounds(217, 55, 78, 16);
		getContentPane().add(lblMaxArea);
		
		JLabel lblMinXyRatio = new JLabel("Min. X/Y ratio");
		lblMinXyRatio.setForeground(Color.WHITE);
		lblMinXyRatio.setBounds(23, 74, 83, 16);
		getContentPane().add(lblMinXyRatio);
		
		txtMinRatio = new JTextField();
		txtMinRatio.setHorizontalAlignment(SwingConstants.CENTER);
		txtMinRatio.setText("0.0");
		txtMinRatio.setColumns(10);
		txtMinRatio.setBackground(Color.WHITE);
		txtMinRatio.setBounds(110, 71, 60, 22);
		getContentPane().add(txtMinRatio);
		
		JLabel lblMaxXyRatio = new JLabel("Max.. X/Y Ratio");
		lblMaxXyRatio.setForeground(Color.WHITE);
		lblMaxXyRatio.setBounds(206, 74, 89, 16);
		getContentPane().add(lblMaxXyRatio);
		
		txtMaxRatio = new JTextField();
		txtMaxRatio.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaxRatio.setText("100.0");
		txtMaxRatio.setColumns(10);
		txtMaxRatio.setBackground(Color.WHITE);
		txtMaxRatio.setBounds(301, 71, 60, 22);
		getContentPane().add(txtMaxRatio);
		
		JLabel lblTargetOffset = new JLabel("Target Offset");
		lblTargetOffset.setForeground(Color.WHITE);
		lblTargetOffset.setBounds(23, 103, 83, 16);
		getContentPane().add(lblTargetOffset);
		
		txtTargetOffset = new JTextField();
		txtTargetOffset.setHorizontalAlignment(SwingConstants.CENTER);
		txtTargetOffset.setText("0.0");
		txtTargetOffset.setBounds(110, 100, 60, 22);
		getContentPane().add(txtTargetOffset);
		txtTargetOffset.setColumns(10);
		
		JLabel lblTargetOpacity = new JLabel("Opacity");
		lblTargetOpacity.setForeground(Color.WHITE);
		lblTargetOpacity.setBounds(326, 141, 56, 16);
		getContentPane().add(lblTargetOpacity);
		
		txtTargetOpacity = new JTextField();
		txtTargetOpacity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	DisplayBall.setAlpha(Integer.parseInt(txtTargetOpacity.getText()));
			}
		});
		txtTargetOpacity.setHorizontalAlignment(SwingConstants.CENTER);
		txtTargetOpacity.setText("200");
		txtTargetOpacity.setBounds(326, 170, 60, 22);
		getContentPane().add(txtTargetOpacity);
		txtTargetOpacity.setColumns(10);
		
		JLabel lblColor = new JLabel("Ball Color");
		lblColor.setForeground(Color.WHITE);
		lblColor.setBounds(51, 173, 54, 16);
		getContentPane().add(lblColor);
		
		txtRed = new JTextField();
		txtRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayBall.setColor(Integer.parseInt(txtRed.getText()), Integer.parseInt(txtGreen.getText()), Integer.parseInt(txtBlue.getText()));
			}
		});
		txtRed.setText("0");
		txtRed.setHorizontalAlignment(SwingConstants.CENTER);
		txtRed.setColumns(10);
		txtRed.setBounds(110, 170, 60, 22);
		getContentPane().add(txtRed);
		
		txtGreen = new JTextField();
		txtGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayBall.setColor(Integer.parseInt(txtRed.getText()), Integer.parseInt(txtGreen.getText()), Integer.parseInt(txtBlue.getText()));
			}
		});
		txtGreen.setText("0");
		txtGreen.setHorizontalAlignment(SwingConstants.CENTER);
		txtGreen.setColumns(10);
		txtGreen.setBounds(182, 170, 60, 22);
		getContentPane().add(txtGreen);
		
		txtBlue = new JTextField();
		txtBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayBall.setColor(Integer.parseInt(txtRed.getText()), Integer.parseInt(txtGreen.getText()), Integer.parseInt(txtBlue.getText()));
			}
		});
		txtBlue.setText("0");
		txtBlue.setHorizontalAlignment(SwingConstants.CENTER);
		txtBlue.setColumns(10);
		txtBlue.setBounds(254, 170, 60, 22);
		getContentPane().add(txtBlue);
		
		JLabel lblRed = new JLabel("Red         Green          Blue");
		lblRed.setForeground(Color.WHITE);
		lblRed.setBounds(131, 141, 196, 16);
		getContentPane().add(lblRed);
	}
	public void cancel(){
		dispose();
	}
	public void accept(){
		Preferences prefTable = Preferences.userRoot().node(Main.BASE_NODE_NAME+LOCAL_CHILD_NODE);
		prefTable.put(MIN_AREA, txtMinArea.getText());
		prefTable.put(MAX_AREA, txtMaxArea.getText());
		prefTable.put(MIN_XY_RATIO, txtMinRatio.getText());
		prefTable.put(MAX_XY_RATIO, txtMaxRatio.getText());
		prefTable.put(TARGET_OFFSET, txtTargetOffset.getText());
		prefTable.put(TARGET_OPACITY, txtTargetOpacity.getText());
		Main.canvas.repaint();
		dispose();
	}
}
