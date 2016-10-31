package com.classes;
import java.io.File;
import javax.swing.JFileChooser;

import com.interfaces.PlayerInterface;

import jaco.mp3.player.MP3Player;

public class PlayerMethods implements PlayerInterface {
	private File file;
	MP3Player mp3Player = new MP3Player();

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public MP3Player getMp3Player() {
		return mp3Player;
	}

	public void setMp3Player(MP3Player mp3Player) {
		this.mp3Player = mp3Player;
	}

	@Override
	public void pause() {
		mp3Player.pause();
	}

	@Override
	public void stop() {
		mp3Player.stop();
	}

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
	
	@Override
	public void play() {
		mp3Player.play();
	}
}
