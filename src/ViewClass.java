import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.View;

import jaco.mp3.player.MP3Player;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.awt.event.ActionEvent;

public class ViewClass {
	MP3Player mp3Player = new MP3Player();

	private JFrame frame;
	private File file;
	private int result = 0;

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
		frame.setBounds(100, 100, 520, 98);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		// play button
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mp3Player.play();
			}
		});
		btnPlay.setBackground(Color.GRAY);
		btnPlay.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/play.jpg")));
		btnPlay.setBounds(6, 16, 117, 41);
		frame.getContentPane().add(btnPlay);
		
		// pause button
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mp3Player.pause();
			}
		});
		btnPause.setBackground(Color.GRAY);
		btnPause.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/pause.jpg")));
		btnPause.setBounds(135, 16, 117, 41);
		frame.getContentPane().add(btnPause);
		
		// browse button
		JButton btnBrowse = new JButton("Browse");
		
		String userDir = System.getProperty("user.home");
		JFileChooser fc = new JFileChooser(userDir);
		
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
					mp3Player.stop();
					mp3Player = new MP3Player(file);
					mp3Player.addToPlayList(file);
					System.out.println(file.getName());
					}
				}
		});
		btnBrowse.setBackground(Color.GRAY);
		btnBrowse.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/browse.jpg")));
		btnBrowse.setBounds(393, 16, 117, 41);
		frame.getContentPane().add(btnBrowse);
		
		// stop button
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mp3Player.stop();
			}
		});
		btnStop.setBounds(264, 16, 117, 41);
		btnStop.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/stop.jpg")));
		frame.getContentPane().add(btnStop);
	}
}
