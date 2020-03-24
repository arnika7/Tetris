package game;

import java.awt.Color;

public  class  Move {
	static final int X = 0;
	static final int Y = 1;

	public Boolean gameOver(View view) {
		for (int i = 3; i < 8; i++) {
			if (view.getC(i, 20) != Color.white)
				return false;
		}
		return true;
	}

	public synchronized Boolean down(Block block, View view) {
		for (int i = 0; i < 4; i++) {
			view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], Color.white);
		}

		for (int i = 0; i < 4; i++) {
			if (block.blockPoint[i][Y] == 1
					|| view.getC(block.blockPoint[i][X], block.blockPoint[i][Y] - 1) != Color.white) {
				for (int j = 0; j < 4; j++) {
					view.setColor(block.blockPoint[j][X], block.blockPoint[j][Y], block.bc);
				}
				return false;
			}
		}

		for (int i = 0; i < 4; i++) {
			block.blockPoint[i][Y] -= 1;
			view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
		}
		return true;
	}

	public void left(Block block, View view) {
		for (int i = 0; i < 4; i++) {
			view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], Color.white);
		}

		for (int i = 0; i < 4; i++) {
			if (block.blockPoint[i][X] == 1
					|| view.getC(block.blockPoint[i][X] - 1, block.blockPoint[i][Y]) != Color.white) {
				for (int j = 0; j < 4; j++) {
					view.setColor(block.blockPoint[j][X], block.blockPoint[j][Y], block.bc);
				}
				return;
			}
		}

		for (int i = 0; i < 4; i++) {
			block.blockPoint[i][X] -= 1;
			view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
		}
	}

	public void right(Block block, View view) {
		for (int i = 0; i < 4; i++) {
			view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], Color.white);
		}

		for (int i = 0; i < 4; i++) {
			if (block.blockPoint[i][X] == 10
					|| view.getC(block.blockPoint[i][X] + 1, block.blockPoint[i][Y]) != Color.white) {
				for (int j = 0; j < 4; j++) {
					view.setColor(block.blockPoint[j][X], block.blockPoint[j][Y], block.bc);
				}
				return;
			}
		}

		for (int i = 0; i < 4; i++) {
			block.blockPoint[i][X] += 1;
			view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
		}
	}

	public int fullLine(Block block, View view, int line) {
		int num = 0;
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 11; j++) {
				if (view.getC(j, i) != Color.white) {
					num++;
				}
			}
			if (num == 10) {
				line += 1;
				view.lineDown(i);
			}
			num = 0;
		}
		return line;
	}

	public void rotate(Block block, View view) {
		switch (block.s) {
		case 0: // 작대기
			for (int i = 0; i < 4; i++) {
				view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], Color.white);
			}
			switch (block.angle) {
			case 0:
				if (block.blockPoint[1][Y] < 3
						|| view.getC(block.blockPoint[2][X], block.blockPoint[0][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[2][X], block.blockPoint[1][Y] - 2) != Color.white
						|| view.getC(block.blockPoint[2][X], block.blockPoint[3][Y] + 1) != Color.white) {

				} else {
					block.blockPoint[0][X] = block.blockPoint[2][X];
					block.blockPoint[1][X] = block.blockPoint[2][X];
					block.blockPoint[3][X] = block.blockPoint[2][X];
					block.blockPoint[0][Y] -= 1;
					block.blockPoint[1][Y] -= 2;
					block.blockPoint[3][Y] += 1;
					block.angle = 90;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			case 90:
				if (block.blockPoint[1][X] < 3 || block.blockPoint[1][X] == 10
						|| view.getC(block.blockPoint[0][X] - 1, block.blockPoint[2][Y]) != Color.white
						|| view.getC(block.blockPoint[1][X] - 2, block.blockPoint[2][Y]) != Color.white
						|| view.getC(block.blockPoint[3][X] + 1, block.blockPoint[2][Y]) != Color.white) {

				} else {
					block.blockPoint[0][Y] = block.blockPoint[2][Y];
					block.blockPoint[1][Y] = block.blockPoint[2][Y];
					block.blockPoint[3][Y] = block.blockPoint[2][Y];
					block.blockPoint[0][X] -= 1;
					block.blockPoint[1][X] -= 2;
					block.blockPoint[3][X] += 1;
					block.angle = 0;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			}
			break;
		case 1: // ㅗ
			for (int i = 0; i < 4; i++) {
				view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], Color.white);
			}

			switch (block.angle) {
			case 0:
				if (block.blockPoint[1][Y] == 1
						|| view.getC(block.blockPoint[1][X], block.blockPoint[1][Y] - 1) != Color.white) {
				} else {
					block.blockPoint[2][X] -= 1;
					block.blockPoint[2][Y] -= 1;
					block.angle = 90;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			case 90:
				if (block.blockPoint[1][X] == 10
						|| view.getC(block.blockPoint[1][X] + 1, block.blockPoint[1][Y]) != Color.white) {
				} else {
					block.blockPoint[3][Y] -= 1;
					block.blockPoint[3][X] += 1;
					block.angle = 180;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			case 180:
				if (block.blockPoint[1][Y] == 20) {
				} else {
					block.blockPoint[0][Y] += 1;
					block.blockPoint[0][X] += 1;
					block.angle = 270;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			case 270:
				if (block.blockPoint[1][X] == 1) {
				} else {
					block.blockPoint[3][X] -= 1;
					block.blockPoint[3][Y] += 1;

					block.blockPoint[2][X] += 1;
					block.blockPoint[2][Y] += 1;

					block.blockPoint[0][X] -= 1;
					block.blockPoint[0][Y] -= 1;
					block.angle = 0;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			}
			break;
		case 2: // ㄱ
			for (int i = 0; i < 4; i++) {
				view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], Color.white);
			}

			switch (block.angle) {
			case 0:
				if (block.blockPoint[1][Y] > 19
						|| view.getC(block.blockPoint[0][X] + 1, block.blockPoint[0][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[2][X] - 1, block.blockPoint[2][Y] + 1) != Color.white
						|| view.getC(block.blockPoint[3][X], block.blockPoint[3][Y] + 2) != Color.white) {
				} else {
					block.blockPoint[0][X] += 1;
					block.blockPoint[0][Y] -= 1;
					block.blockPoint[2][X] -= 1;
					block.blockPoint[2][Y] += 1;
					block.blockPoint[3][Y] += 2;
					block.angle = 90;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			case 90:
				if (block.blockPoint[1][X] == 1
						|| view.getC(block.blockPoint[0][X] + 1, block.blockPoint[0][Y] + 1) != Color.white
						|| view.getC(block.blockPoint[2][X] - 1, block.blockPoint[2][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[3][X] - 2, block.blockPoint[3][Y]) != Color.white) {
				} else {
					block.blockPoint[0][X] += 1;
					block.blockPoint[0][Y] += 1;
					block.blockPoint[2][X] -= 1;
					block.blockPoint[2][Y] -= 1;
					block.blockPoint[3][X] -= 2;
					block.angle = 180;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			case 180:
				if (block.blockPoint[1][Y] == 1
						|| view.getC(block.blockPoint[0][X] - 1, block.blockPoint[0][Y] + 1) != Color.white
						|| view.getC(block.blockPoint[2][X] + 1, block.blockPoint[2][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[3][X], block.blockPoint[3][Y] - 2) != Color.white) {
				} else {
					block.blockPoint[0][X] -= 1;
					block.blockPoint[0][Y] += 1;
					block.blockPoint[2][X] += 1;
					block.blockPoint[2][Y] -= 1;
					block.blockPoint[3][Y] -= 2;
					block.angle = 270;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			case 270:
				if (block.blockPoint[1][X] == 10
						|| view.getC(block.blockPoint[0][X] - 1, block.blockPoint[0][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[2][X] + 1, block.blockPoint[2][Y] + 1) != Color.white
						|| view.getC(block.blockPoint[3][X] + 2, block.blockPoint[3][Y]) != Color.white) {
				} else {
					block.blockPoint[0][X] -= 1;
					block.blockPoint[0][Y] -= 1;
					block.blockPoint[2][X] += 1;
					block.blockPoint[2][Y] += 1;
					block.blockPoint[3][X] += 2;
					block.angle = 0;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			}
			break;
		case 3: // ㄴ
			for (int i = 0; i < 4; i++) {
				view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], Color.white);
			}

			switch (block.angle) {
			case 0:
				if (block.blockPoint[1][Y] > 20
						|| view.getC(block.blockPoint[0][X] - 1, block.blockPoint[0][Y] + 1) != Color.white
						|| view.getC(block.blockPoint[2][X] + 1, block.blockPoint[2][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[3][X] + 2, block.blockPoint[3][Y]) != Color.white) {
				} else {
					block.blockPoint[0][X] -= 1;
					block.blockPoint[0][Y] += 1;
					block.blockPoint[2][X] += 1;
					block.blockPoint[2][Y] -= 1;
					block.blockPoint[3][X] += 2;
					block.angle = 90;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			case 90:
				if (block.blockPoint[1][X] == 1
						|| view.getC(block.blockPoint[0][X] - 1, block.blockPoint[0][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[2][X] + 1, block.blockPoint[2][Y] + 1) != Color.white
						|| view.getC(block.blockPoint[3][X], block.blockPoint[3][Y] + 2) != Color.white) {
				} else {
					block.blockPoint[0][X] -= 1;
					block.blockPoint[0][Y] -= 1;
					block.blockPoint[2][X] += 1;
					block.blockPoint[2][Y] += 1;
					block.blockPoint[3][Y] += 2;
					block.angle = 180;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			case 180:
				if (block.blockPoint[1][Y] == 1
						|| view.getC(block.blockPoint[0][X] + 1, block.blockPoint[0][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[2][X] - 1, block.blockPoint[2][Y] + 1) != Color.white
						|| view.getC(block.blockPoint[3][X] - 2, block.blockPoint[3][Y]) != Color.white) {
				} else {
					block.blockPoint[0][X] += 1;
					block.blockPoint[0][Y] -= 1;
					block.blockPoint[2][X] -= 1;
					block.blockPoint[2][Y] += 1;
					block.blockPoint[3][X] -= 2;
					block.angle = 270;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			case 270:
				if (block.blockPoint[1][X] == 10
						|| view.getC(block.blockPoint[0][X] + 1, block.blockPoint[0][Y] + 1) != Color.white
						|| view.getC(block.blockPoint[2][X] - 1, block.blockPoint[2][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[3][X], block.blockPoint[3][Y] - 2) != Color.white) {
				} else {
					block.blockPoint[0][X] += 1;
					block.blockPoint[0][Y] += 1;
					block.blockPoint[2][X] -= 1;
					block.blockPoint[2][Y] -= 1;
					block.blockPoint[3][Y] -= 2;
					block.angle = 0;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			}
			break;
		case 4: // ㅁ
			break;
		case 5: // _┌
			for (int i = 0; i < 4; i++) {
				view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], Color.white);
			}

			switch (block.angle) {
			case 0:
				if (block.blockPoint[1][Y] == 21
						|| view.getC(block.blockPoint[0][X] + 1, block.blockPoint[0][Y] + 1) != Color.white
						|| view.getC(block.blockPoint[2][X] - 1, block.blockPoint[2][Y] + 1) != Color.white
						|| view.getC(block.blockPoint[3][X] - 2, block.blockPoint[3][Y]) != Color.white) {
				} else {
					block.blockPoint[0][X] += 1;
					block.blockPoint[0][Y] += 1;
					block.blockPoint[2][X] -= 1;
					block.blockPoint[2][Y] += 1;
					block.blockPoint[3][X] -= 2;
					block.angle = 90;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			case 90:
				if (block.blockPoint[1][X] == 10
						|| view.getC(block.blockPoint[0][X] - 1, block.blockPoint[0][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[2][X] + 1, block.blockPoint[2][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[3][X] + 2, block.blockPoint[3][Y]) != Color.white) {
				} else {
					block.blockPoint[0][X] -= 1;
					block.blockPoint[0][Y] -= 1;
					block.blockPoint[2][X] += 1;
					block.blockPoint[2][Y] -= 1;
					block.blockPoint[3][X] += 2;
					block.angle = 0;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			}
			break;
		case 6: // ㄱ_
			for (int i = 0; i < 4; i++) {
				view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], Color.white);
			}

			switch (block.angle) {
			case 0:
				if (block.blockPoint[1][Y] == 21
						|| view.getC(block.blockPoint[0][X] - 1, block.blockPoint[0][Y] + 1) != Color.white
						|| view.getC(block.blockPoint[2][X] + 1, block.blockPoint[2][Y] + 1) != Color.white
						|| view.getC(block.blockPoint[3][X] + 2, block.blockPoint[3][Y]) != Color.white) {
				} else {
					block.blockPoint[0][X] -= 1;
					block.blockPoint[0][Y] += 1;
					block.blockPoint[2][X] += 1;
					block.blockPoint[2][Y] += 1;
					block.blockPoint[3][X] += 2;
					block.angle = 90;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			case 90:
				if (block.blockPoint[1][X] == 1
						|| view.getC(block.blockPoint[0][X] + 1, block.blockPoint[0][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[2][X] - 1, block.blockPoint[2][Y] - 1) != Color.white
						|| view.getC(block.blockPoint[3][X] - 2, block.blockPoint[3][Y]) != Color.white) {
				} else {
					block.blockPoint[0][X] += 1;
					block.blockPoint[0][Y] -= 1;
					block.blockPoint[2][X] -= 1;
					block.blockPoint[2][Y] -= 1;
					block.blockPoint[3][X] -= 2;
					block.angle = 0;
				}
				for (int i = 0; i < 4; i++) {
					view.setColor(block.blockPoint[i][X], block.blockPoint[i][Y], block.bc);
				}
				break;
			}
			break;
		}
	}

}
