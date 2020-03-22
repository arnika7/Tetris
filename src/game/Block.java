package game;

import java.awt.Color;

public class Block {
	int[][] blockPoint = new int[4][2];
	Color bc;
	int s;
	int angle = 0;
	static final int X = 0;
	static final int Y = 1;
	
	Block() {
		int rd = (int) (Math.random() * 11);
		switch (rd) {
		case 0:
			bc = Color.blue;
			break;
		case 1:
			bc = Color.orange;
			break;
		case 2:
			bc = Color.GRAY;
			break;
		case 3:
			bc = Color.green;
			break;
		case 4:
			bc = Color.BLACK;
			break;
		case 5:
			bc = Color.PINK;
			break;
		case 6:
			bc = Color.RED;
			break;
		case 7:
			bc = Color.cyan;
			break;
		case 8:
			bc = Color.MAGENTA;
			break;
		case 9:
			bc = Color.YELLOW;
			break;
		case 10:
			bc = Color.LIGHT_GRAY;
			break;
		}
		rd = (int) (Math.random() * 7);
//		rd = 5;
		switch (rd) {
		case 0: //작대기
			blockPoint[0][X] = 4;
			blockPoint[0][Y] = 21;
			blockPoint[1][X] = 5;
			blockPoint[1][Y] = 21;
			blockPoint[2][X] = 6;
			blockPoint[2][Y] = 21;
			blockPoint[3][X] = 7;
			blockPoint[3][Y] = 21;
			s = 0;
			break;
		case 1: // ㅗ
			blockPoint[0][X] = 4;
			blockPoint[0][Y] = 20;
			blockPoint[1][X] = 5;
			blockPoint[1][Y] = 20;
			blockPoint[2][X] = 6;
			blockPoint[2][Y] = 20;
			blockPoint[3][X] = 5;
			blockPoint[3][Y] = 21;
			s = 1;
			break;
		case 2: // ㄱ
			blockPoint[0][X] = 4;
			blockPoint[0][Y] = 21;
			blockPoint[1][X] = 5;
			blockPoint[1][Y] = 21;
			blockPoint[2][X] = 6;
			blockPoint[2][Y] = 21;
			blockPoint[3][X] = 6;
			blockPoint[3][Y] = 20;
			s = 2;
			break;
		case 3: // ㄴ
			blockPoint[0][X] = 6;
			blockPoint[0][Y] = 21;
			blockPoint[1][X] = 5;
			blockPoint[1][Y] = 21;
			blockPoint[2][X] = 4;
			blockPoint[2][Y] = 21;
			blockPoint[3][X] = 4;
			blockPoint[3][Y] = 20;
			s = 3;
			break;
		case 4: //ㅁ
			blockPoint[0][X] = 5;
			blockPoint[0][Y] = 21;
			blockPoint[1][X] = 6;
			blockPoint[1][Y] = 21;
			blockPoint[2][X] = 5;
			blockPoint[2][Y] = 20;
			blockPoint[3][X] = 6;
			blockPoint[3][Y] = 20;
			s = 4;
			break;
		case 5: // 
			blockPoint[0][X] = 4;
			blockPoint[0][Y] = 21;
			blockPoint[1][X] = 5;
			blockPoint[1][Y] = 21;
			blockPoint[2][X] = 5;
			blockPoint[2][Y] = 20;
			blockPoint[3][X] = 6;
			blockPoint[3][Y] = 20;
			s = 5;
			break;
		case 6:
			blockPoint[0][X] = 6;
			blockPoint[0][Y] = 21;
			blockPoint[1][X] = 5;
			blockPoint[1][Y] = 21;
			blockPoint[2][X] = 5;
			blockPoint[2][Y] = 20;
			blockPoint[3][X] = 4;
			blockPoint[3][Y] = 20;
			s = 6;
			break;
		}
	}

	
}
