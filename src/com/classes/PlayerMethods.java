package com.classes;
import java.io.File;
import javax.swing.JFileChooser;

import com.interfaces.PlayerInterface;

import jaco.mp3.player.MP3Player;

/**
 * PlayerMethods implements methods from the interface PlayerInterface
 * A external library is imported for playing mp3 files
 * @author celepm
 *
 */
public class PlayerMethods implements PlayerInterface {
	private File file;
	MP3Player mp3Player = new MP3Player();

	/**
	 * getter for file
	 * @return file - get file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * setter for file
	 * @param file - set file
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * getter for mp3Player
	 * @return mp3Player - get mp3Player
	 */
	public MP3Player getMp3Player() {
		return mp3Player;
	}

	/**
	 * setter for mp3Player
	 * @param mp3Player - set mp3Player
	 */
	public void setMp3Player(MP3Player mp3Player) {
		this.mp3Player = mp3Player;
	}

	/**
	 * pauses the mp3Player
	 */
	@Override
	public void pause() {
		mp3Player.pause();
	}

	/**
	 * stops the mp3Player
	 */
	@Override
	public void stop() {
		mp3Player.stop();
	}

	/**
	 * a method for browsing files
	 */
	@Override
	public void browse() {
		String userDir = System.getProperty("user.home");
		JFileChooser fc = new JFileChooser(userDir);
		int status = fc.showOpenDialog(null);
		
		if (status == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			mp3Player.stop();
			mp3Player = new MP3Player(file);
			mp3Player.addToPlayList(file);
			file = fc.getSelectedFile();				
			System.out.println(file.getName());
			play();
			} else if (status == JFileChooser.CANCEL_OPTION) {
				System.out.println("Canceled");	
			}
	}
	
	/**
	 * play mp3Player
	 */
	@Override
	public void play() {
		mp3Player.play();
	}
}
