package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class NextPlayer {
	static Block block;
	static Block nextBlock;
	final static int PORT = 9191;

	public static void main(String[] args) {
		PrintWriter pw = null;
		String[] data = new String[200];
		String dataP;
		View view = new View();
		Move move = new Move();
		int line = 0;
		int score = 0;
		int time = 400;
		block = new Block();
		int start = 0;
		view.setVisible(true);
		
		ServerSocket server;
		try {
			Socket sock = new Socket("192.168.0.106", 9191);
			pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			DataComing dl = new DataComing(sock,view);
			dl.start();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		

		while (true) {
			Boolean game = true;
			view.score.setText("SCORE : " + score);
			if (start == 0) {
				block = new Block();
				start++;
			} else {
				block = nextBlock;
			}
			nextBlock = new Block();
			view.nextView(nextBlock.s);

			class Key extends KeyAdapter {
				public synchronized void keyPressed(KeyEvent e) {
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
							if (move.down(block, view) == false)
								break;
						}
						break;
					case (KeyEvent.VK_SHIFT):

						break;
					}
				}
			}
			Key k = new Key();

			while (game) {
				view.contentPane.requestFocus();
				view.contentPane.addKeyListener(k);
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				view.contentPane.removeKeyListener(k);
				game = move.down(block, view);
			}
			line = move.fullLine(block, view, line);
			line = move.fullLine(block, view, line);
			line = move.fullLine(block, view, line);
			line = move.fullLine(block, view, line);
			data = view.dataIn();
			dataP = Arrays.toString(data);
			pw.println(dataP); // 각 값에 메세지를 입력
			pw.flush();
			switch (line) {
			case 1:
				score += 100;
				break;
			case 2:
				score += 250;
				break;
			case 3:
				score += 500;
				break;
			case 4:
				score += 800;
				break;
			default:
				score += 10;
				break;
			}
			time -= 2;
			if (time < 130)
				time = 130;
			line = 0;
			if (move.gameOver(view) == false) {
				pw.println("YOUWIN"); // 각 값에 메세지를 입력
				pw.flush();
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "            GAME OVER");
	}
}

class DataComing extends Thread {
	Socket sock;
	View view;
	DataComing(Socket sock,View view){
		this.sock = sock;
		this.view = view;
	}

	public void run() {
		try {
			

			InputStream in = sock.getInputStream();
			InputStreamReader inR = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inR);

			String line;
			while (true) {
				line = br.readLine();
				if(line.equals("YOUWIN")) {
					JOptionPane.showMessageDialog(null, "           승리하였습니다!");
					break;
				}
				view.inputData(line.substring(1, line.length()-1).split(", "));
			}

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
