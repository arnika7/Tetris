package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

public class Start {
	static Block block;

	public static void main(String[] args) {
		View view = new View();
		Move move = new Move();

		view.setVisible(true);

		while (true) {
			Boolean game = true;
			block = new Block();

			class Key extends KeyAdapter {
				public void keyPressed(KeyEvent e) {
					int key = e.getKeyCode();
					switch (key) {
					case (KeyEvent.VK_RIGHT):
						move.right(block, view);
						break;
					case (KeyEvent.VK_LEFT):
						move.left(block, view);
						break;
					case (KeyEvent.VK_DOWN):
						move.down(block, view);
						break;
					case (KeyEvent.VK_UP):
						move.rotate(block, view);
						break;
					case (KeyEvent.VK_SPACE):
						while (true) {
							if (move.down(block, view)==false)
								break;
						}
						break;
					}
				}
			}
			Key k = new Key();

			while (game) {
				view.contentPane.requestFocus();
				view.contentPane.addKeyListener(k);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				view.contentPane.removeKeyListener(k);
				game = move.down(block, view);
			}
			move.fullLine(block, view);
			move.fullLine(block, view);
			move.fullLine(block, view);
			move.fullLine(block, view);

			if (move.gameOver(view) == false) {
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "            GAME OVER");
	}
}
