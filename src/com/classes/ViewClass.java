package com.classes;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ViewClass {
	private JFrame frame;
	public JTextField txtPlaying;
	PlayerMethods playerMethods = new PlayerMethods();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewClass window = new ViewClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 516, 130);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		// play button
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerMethods.play();
				txtPlaying.setText("Playing: " + playerMethods.getFile().getName());
			}
		});
		btnPlay.setBackground(Color.GRAY);
		btnPlay.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/play.jpg")));
		btnPlay.setBounds(6, 48, 117, 41);
		frame.getContentPane().add(btnPlay);
		
		// pause button
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerMethods.pause();
				txtPlaying.setText("Paused: " + playerMethods.getFile().getName());
			}
		});
		btnPause.setBackground(Color.GRAY);
		btnPause.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/pause.jpg")));
		btnPause.setBounds(135, 48, 117, 41);
		frame.getContentPane().add(btnPause);
		
		// browse button
		JButton btnBrowse = new JButton("Browse");
		
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerMethods.browse();
				txtPlaying.setText("Playing: " + playerMethods.getFile().getName());
			}
		});
		btnBrowse.setBackground(Color.GRAY);
		btnBrowse.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/browse.jpg")));
		btnBrowse.setBounds(393, 48, 117, 41);
		frame.getContentPane().add(btnBrowse);
		
		// stop button
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerMethods.stop();
				txtPlaying.setText("Stopped: " + playerMethods.getFile().getName());
			}
		});
		btnStop.setBounds(264, 48, 117, 41);
		btnStop.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/stop.jpg")));
		frame.getContentPane().add(btnStop);
		
		txtPlaying = new JTextField();
		txtPlaying.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaying.setEditable(false);
		txtPlaying.setBounds(115, 14, 281, 26);
		txtPlaying.setText("Welcome to MusicPlayer!");
		frame.getContentPane().add(txtPlaying);
		txtPlaying.setColumns(10);
	}
}
