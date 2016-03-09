package Main;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestBall extends JFrame  {
	private JTextField txtXyratio;
	private JTextField txtX;
	private JTextField txtXPosition;
	private JTextField txtYposition;
	public TestBall() {
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		JLabel lblXyRatio = new JLabel("X/Y ratio");
		lblXyRatio.setForeground(Color.WHITE);
		lblXyRatio.setBounds(63, 40, 60, 16);
		getContentPane().add(lblXyRatio);
		
		txtXyratio = new JTextField();
		txtXyratio.setText("0.0");
		txtXyratio.setHorizontalAlignment(SwingConstants.CENTER);
		txtXyratio.setColumns(10);
		txtXyratio.setBackground(Color.WHITE);
		txtXyratio.setBounds(122, 37, 60, 22);
		getContentPane().add(txtXyratio);
		
		txtX = new JTextField();
		txtX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayBall.setSize(Integer.parseInt(txtX.getText()));
			}
		});
		txtX.setText("0.0");
		txtX.setHorizontalAlignment(SwingConstants.CENTER);
		txtX.setColumns(10);
		txtX.setBackground(Color.WHITE);
		txtX.setBounds(122, 56, 60, 22);
		getContentPane().add(txtX);
		
		JLabel lblX = new JLabel("XSize");
		lblX.setForeground(Color.WHITE);
		lblX.setBounds(73, 59, 32, 16);
		getContentPane().add(lblX);
		
		JLabel lblXPosition = new JLabel("X Position");
		lblXPosition.setForeground(Color.WHITE);
		lblXPosition.setBounds(63, 100, 60, 16);
		getContentPane().add(lblXPosition);
		
		txtXPosition = new JTextField();
		txtXPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayBall.setX(Integer.parseInt(txtXPosition.getText()));
			}
		});
		txtXPosition.setText("0");
		txtXPosition.setHorizontalAlignment(SwingConstants.CENTER);
		txtXPosition.setColumns(10);
		txtXPosition.setBounds(122, 97, 60, 22);
		getContentPane().add(txtXPosition);
		
		JLabel lblYPosition = new JLabel("Y Position");
		lblYPosition.setForeground(Color.WHITE);
		lblYPosition.setBounds(63, 132, 60, 16);
		getContentPane().add(lblYPosition);
		
		txtYposition = new JTextField();
		txtYposition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayBall.setY(Integer.parseInt(txtXPosition.getText()));
			}
		});
		txtYposition.setText("0");
		txtYposition.setHorizontalAlignment(SwingConstants.CENTER);
		txtYposition.setColumns(10);
		txtYposition.setBounds(122, 129, 60, 22);
		getContentPane().add(txtYposition);
		setTitle("Ball Test");
		setBounds(110, 110, 446, 240);
	}
}
