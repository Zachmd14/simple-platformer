package com.zachary.platformer;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class App extends JFrame implements Runnable {
	private boolean isRunning = true;

	public App() {
		setTitle("Simple Java Platformer");
		setSize(1000, 1000); // Set the window size
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

		// g.setColor(Color.GREEN);
		// g.fillRect(0, 0, 90, 90);

		int squareSize = 50;

		int penPosX;
		int penPosY;

		for (penPosX = 0; penPosX < getWidth(); penPosX += squareSize) {
			for (penPosY = 0; penPosY < getHeight(); penPosY += squareSize) {
				if ((penPosX / squareSize + penPosY / squareSize) % 2 == 0) {
					g.setColor(Color.GREEN); // Set color for the square
				} else {
					g.setColor(Color.RED); // Alternate color
				}
				g.fillRect(penPosX, penPosY, squareSize, squareSize);
			}

		}

	}

	public static void main(String[] args) {
		App game = new App();
		Thread gameThread = new Thread(game);
		gameThread.start();
	}
}
