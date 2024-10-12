package com.zachary.platformer;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class App extends JFrame implements Runnable {
	private boolean isRunning = true;

	public App() {
		setTitle("Simple Java Platformer");
		setSize(800, 600); // Set the window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void run() {
		while (isRunning) {
			updateGame();
			repaint(); // Re-draw the window
			try {
				Thread.sleep(16); // Roughly 60 frames per second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateGame() {
		// Update game logic here
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		// Draw game elements here (e.g., player, platforms)

		// Get the size of the window and assign it to windowHeight and windowWidth
		int windowHeight = getHeight();
		int windowWidth = getWidth();
		System.out.println("Window width: " + windowWidth + " Window height: " + windowHeight);
		// g.setColor(Color.GREEN);
		// g.fillRect(0, 0, 90, 90);

		int penPosition = 0;

		for (int i = 0; i < windowWidth; i++) {
			penPosition = penPosition + 5;
			if (i % 5 == 0) {
				g.setColor(Color.GREEN);
				g.fillRect(penPosition, 10, 2, 2);
			}
		}
	}

	public static void main(String[] args) {
		App game = new App();
		Thread gameThread = new Thread(game);
		gameThread.start();
	}
}
