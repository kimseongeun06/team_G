
public class ComputerPlayer extends Player {
	public ComputerPlayer(int id, String name, int order, int playerType) {
		super(id, name, order, playerType);
	}

	private int evaluatePosition(OmokBoard board, int x, int y) {
		Position p = new Position(x, y);
		// stoneNum 배열
		int[] comStoneNum = new int[8];
		int[] userStoneNum = new int[8];
		for (int i = 0; i < 8; i++) {
			comStoneNum[i] = 0;
			userStoneNum[i] = 0;
		}
		// 리턴 값
		int returnScore = 0;

		board.countSameColorStones(p, StoneType.White, comStoneNum);
		board.countSameColorStones(p, StoneType.Black, userStoneNum);

		/////////////////// (x,y)의 위치 평가 방법 ///////////////////
		// 내가 돌을 놓았을 경우 5개 완성 (100)
		if (comStoneNum[0] == 4 || comStoneNum[1] == 4 || comStoneNum[2] == 4 || comStoneNum[3] == 4
				|| comStoneNum[4] == 4 || comStoneNum[5] == 4 || comStoneNum[6] == 4 || comStoneNum[7] == 4
				|| comStoneNum[0] + comStoneNum[4] == 4 || comStoneNum[1] + comStoneNum[5] == 4
				|| comStoneNum[2] + comStoneNum[6] == 4 || comStoneNum[3] + comStoneNum[7] == 4) {
			returnScore = 100;
		}
		// 상대방이 돌을 놓았을 경우에 5개 완성 & 방어 (90)
		else if (userStoneNum[0] == 4 || userStoneNum[1] == 4 || userStoneNum[2] == 4 || userStoneNum[3] == 4
				|| userStoneNum[4] == 4 || userStoneNum[5] == 4 || userStoneNum[6] == 4 || userStoneNum[7] == 4
				|| userStoneNum[0] + userStoneNum[4] == 4 || userStoneNum[1] + userStoneNum[5] == 4
				|| userStoneNum[2] + userStoneNum[6] == 4 || userStoneNum[3] + userStoneNum[7] == 4) {
			returnScore = 90;
		}
		// 내가 돌을 놓았을 경우에 4개, 열린 공간(80)
		else if ((x != 0 && y != 0) && (comStoneNum[0] == 3 || comStoneNum[1] == 3 || comStoneNum[2] == 3
				|| comStoneNum[3] == 3 || comStoneNum[4] == 3 || comStoneNum[5] == 3 || comStoneNum[6] == 3
				|| comStoneNum[7] == 3 || comStoneNum[0] + comStoneNum[4] == 3 || comStoneNum[1] + comStoneNum[5] == 3
				|| comStoneNum[2] + comStoneNum[6] == 3 || comStoneNum[3] + comStoneNum[7] == 3)) {
			returnScore = 80;
		}
		// 상대방이 돌을 놓았을 경우에 4개 & 방어, 열린 공간(75)
		else if ((x != 0 && y != 0)
				&& (userStoneNum[0] == 3 || userStoneNum[1] == 3 || userStoneNum[2] == 3 || userStoneNum[3] == 3
						|| userStoneNum[4] == 3 || userStoneNum[5] == 3 || userStoneNum[6] == 3 || userStoneNum[7] == 3
						|| userStoneNum[0] + userStoneNum[4] == 3 || userStoneNum[1] + userStoneNum[5] == 3
						|| userStoneNum[2] + userStoneNum[6] == 3 || userStoneNum[3] + userStoneNum[7] == 3)) {
			returnScore = 75;
		}
		// 내가 돌을 놓았을 경우에 4개, 모서리(70)
		else if ((x == 0 || y == 0) && (comStoneNum[0] == 3 || comStoneNum[1] == 3 || comStoneNum[2] == 3
				|| comStoneNum[3] == 3 || comStoneNum[4] == 3 || comStoneNum[5] == 3 || comStoneNum[6] == 3
				|| comStoneNum[7] == 3 || comStoneNum[0] + comStoneNum[4] == 3 || comStoneNum[1] + comStoneNum[5] == 3
				|| comStoneNum[2] + comStoneNum[6] == 3 || comStoneNum[3] + comStoneNum[7] == 3)) {
			returnScore = 70;
		}
		// 상대방이 돌을 놓았을 경우에 4개 & 방어, 모서리(65)
		else if ((x == 0 || y == 0)
				&& (userStoneNum[0] == 3 || userStoneNum[1] == 3 || userStoneNum[2] == 3 || userStoneNum[3] == 3
						|| userStoneNum[4] == 3 || userStoneNum[5] == 3 || userStoneNum[6] == 3 || userStoneNum[7] == 3
						|| userStoneNum[0] + userStoneNum[4] == 3 || userStoneNum[1] + userStoneNum[5] == 3
						|| userStoneNum[2] + userStoneNum[6] == 3 || userStoneNum[3] + userStoneNum[7] == 3)) {
			returnScore = 65;
		}
		// 내가 돌을 놓았을 경우에 3개, 열린 공간(60)
		else if ((x != 0 && y != 0) && (comStoneNum[0] == 2 || comStoneNum[1] == 2 || comStoneNum[2] == 2
				|| comStoneNum[3] == 2 || comStoneNum[4] == 2 || comStoneNum[5] == 2 || comStoneNum[6] == 2
				|| comStoneNum[7] == 2 || comStoneNum[0] + comStoneNum[4] == 2 || comStoneNum[1] + comStoneNum[5] == 2
				|| comStoneNum[2] + comStoneNum[6] == 2 || comStoneNum[3] + comStoneNum[7] == 2)) {
			returnScore = 60;
		}
		// 상대방이 돌을 놓았을 경우에 3개 & 방어, 열린 공간(55)
		else if ((x != 0 && y != 0)
				&& (userStoneNum[0] == 2 || userStoneNum[1] == 2 || userStoneNum[2] == 2 || userStoneNum[3] == 2
						|| userStoneNum[4] == 2 || userStoneNum[5] == 2 || userStoneNum[6] == 2 || userStoneNum[7] == 2
						|| userStoneNum[0] + userStoneNum[4] == 2 || userStoneNum[1] + userStoneNum[5] == 2
						|| userStoneNum[2] + userStoneNum[6] == 2 || userStoneNum[3] + userStoneNum[7] == 2)) {
			returnScore = 55;
		}
		// 내가 돌을 놓았을 경우에 3개, 모서리(50)
		else if ((x == 0 || y == 0) && (comStoneNum[0] == 2 || comStoneNum[1] == 2 || comStoneNum[2] == 2
				|| comStoneNum[3] == 2 || comStoneNum[4] == 2 || comStoneNum[5] == 2 || comStoneNum[6] == 2
				|| comStoneNum[7] == 2 || comStoneNum[0] + comStoneNum[4] == 2 || comStoneNum[1] + comStoneNum[5] == 2
				|| comStoneNum[2] + comStoneNum[6] == 2 || comStoneNum[3] + comStoneNum[7] == 2)) {
			returnScore = 50;
		}
		// 상대방이 돌을 놓았을 경우에 3개 & 방어, 모서리(45)
		else if ((x == 0 || y == 0)
				&& (userStoneNum[0] == 2 || userStoneNum[1] == 2 || userStoneNum[2] == 2 || userStoneNum[3] == 2
						|| userStoneNum[4] == 2 || userStoneNum[5] == 2 || userStoneNum[6] == 2 || userStoneNum[7] == 2
						|| userStoneNum[0] + userStoneNum[4] == 2 || userStoneNum[1] + userStoneNum[5] == 2
						|| userStoneNum[2] + userStoneNum[6] == 2 || userStoneNum[3] + userStoneNum[7] == 2)) {
			returnScore = 45;
		}
		// 내가 돌을 놓았을 경우에 2개, 열린 공간(40)
		else if ((x != 0 && y != 0) && (comStoneNum[0] == 1 || comStoneNum[1] == 1 || comStoneNum[2] == 1
				|| comStoneNum[3] == 1 || comStoneNum[4] == 1 || comStoneNum[5] == 1 || comStoneNum[6] == 1
				|| comStoneNum[7] == 1 || comStoneNum[0] + comStoneNum[4] == 1 || comStoneNum[1] + comStoneNum[5] == 1
				|| comStoneNum[2] + comStoneNum[6] == 1 || comStoneNum[3] + comStoneNum[7] == 1)) {
			returnScore = 40;
		}
		// 상대방이 돌을 놓았을 경우에 3개 & 방어, 열린 공간(35)
		else if ((x != 0 && y != 0)
				&& (userStoneNum[0] == 1 || userStoneNum[1] == 1 || userStoneNum[2] == 1 || userStoneNum[3] == 1
						|| userStoneNum[4] == 1 || userStoneNum[5] == 1 || userStoneNum[6] == 1 || userStoneNum[7] == 1
						|| userStoneNum[0] + userStoneNum[4] == 1 || userStoneNum[1] + userStoneNum[5] == 1
						|| userStoneNum[2] + userStoneNum[6] == 1 || userStoneNum[3] + userStoneNum[7] == 1)) {
			returnScore = 35;
		}
		// 내가 돌을 놓았을 경우에 2개, 모서리(30)
		else if ((x == 0 || y == 0) && (comStoneNum[0] == 1 || comStoneNum[1] == 1 || comStoneNum[2] == 1
				|| comStoneNum[3] == 1 || comStoneNum[4] == 1 || comStoneNum[5] == 1 || comStoneNum[6] == 1
				|| comStoneNum[7] == 1 || comStoneNum[0] + comStoneNum[4] == 1 || comStoneNum[1] + comStoneNum[5] == 1
				|| comStoneNum[2] + comStoneNum[6] == 1 || comStoneNum[3] + comStoneNum[7] == 1)) {
			returnScore = 30;
		}
		// 상대방이 돌을 놓았을 경우에 3개 & 방어, 모서리(25)
		else if ((x == 0 || y == 0)
				&& (userStoneNum[0] == 1 || userStoneNum[1] == 1 || userStoneNum[2] == 1 || userStoneNum[3] == 1
						|| userStoneNum[4] == 1 || userStoneNum[5] == 1 || userStoneNum[6] == 1 || userStoneNum[7] == 1
						|| userStoneNum[0] + userStoneNum[4] == 1 || userStoneNum[1] + userStoneNum[5] == 1
						|| userStoneNum[2] + userStoneNum[6] == 1 || userStoneNum[3] + userStoneNum[7] == 1)) {
			returnScore = 25;
		}
		// 내가 돌을 놓았을 경우에 1개, 열린 공간(20)
		else if ((x != 0 && y != 0) && (comStoneNum[0] == 0 || comStoneNum[1] == 0 || comStoneNum[2] == 0
				|| comStoneNum[3] == 0 || comStoneNum[4] == 0 || comStoneNum[5] == 0 || comStoneNum[6] == 0
				|| comStoneNum[7] == 0 || comStoneNum[0] + comStoneNum[4] == 0 || comStoneNum[1] + comStoneNum[5] == 0
				|| comStoneNum[2] + comStoneNum[6] == 0 || comStoneNum[3] + comStoneNum[7] == 0)) {
			returnScore = 20;
		}
		// 상대방이 돌을 놓았을 경우에 1개 & 방어, 열린 공간(15)
		else if ((x != 0 && y != 0)
				&& (userStoneNum[0] == 0 || userStoneNum[1] == 0 || userStoneNum[2] == 0 || userStoneNum[3] == 0
						|| userStoneNum[4] == 0 || userStoneNum[5] == 0 || userStoneNum[6] == 0 || userStoneNum[7] == 0
						|| userStoneNum[0] + userStoneNum[4] == 0 || userStoneNum[1] + userStoneNum[5] == 0
						|| userStoneNum[2] + userStoneNum[6] == 0 || userStoneNum[3] + userStoneNum[7] == 0)) {
			returnScore = 15;
		}
		// 내가 돌을 놓았을 경우에 1개, 모서리(10)
		else if ((x == 0 || y == 0) && (comStoneNum[0] == 0 || comStoneNum[1] == 0 || comStoneNum[2] == 0
				|| comStoneNum[3] == 0 || comStoneNum[4] == 0 || comStoneNum[5] == 0 || comStoneNum[6] == 0
				|| comStoneNum[7] == 0 || comStoneNum[0] + comStoneNum[4] == 0 || comStoneNum[1] + comStoneNum[5] == 0
				|| comStoneNum[2] + comStoneNum[6] == 0 || comStoneNum[3] + comStoneNum[7] == 0)) {
			returnScore = 10;
		}
		// 상대방이 돌을 놓았을 경우에 1개 & 방어, 모서리(5)
		else if ((x == 0 || y == 0)
				&& (userStoneNum[0] == 0 || userStoneNum[1] == 0 || userStoneNum[2] == 0 || userStoneNum[3] == 0
						|| userStoneNum[4] == 0 || userStoneNum[5] == 0 || userStoneNum[6] == 0 || userStoneNum[7] == 0
						|| userStoneNum[0] + userStoneNum[4] == 0 || userStoneNum[1] + userStoneNum[5] == 0
						|| userStoneNum[2] + userStoneNum[6] == 0 || userStoneNum[3] + userStoneNum[7] == 0)) {
			returnScore = 5;
		}

		/////////////////// 보너스 점수 부여하기 ///////////////////
		int centerX = 0, centerY = 0;
		int d = 0;
		int MAXd = 0;

		if (board.getRowCount() == 11) {
			centerX = 5;
			centerY = 5;
			MAXd = 10;
		} else if (board.getRowCount() == 15) {
			centerX = 7;
			centerY = 7;
			MAXd = 14;
		} else if (board.getRowCount() == 19) {
			centerX = 9;
			centerY = 9;
			MAXd = 18;
		}
		double L = MAXd / 5;

		// d 구하기
		if (x >= centerX && y >= centerY)
			d = (x - centerX) + (y - centerY);
		else if (x < centerX && y >= centerY)
			d = (centerX - x) + (y - centerY);
		else if (x >= centerX && y < centerY)
			d = (x - centerX) + (centerY - y);
		else if (x < centerX && y < centerY)
			d = (centerX - x) + (centerY - y);

		// 구간 판단
		if (d < L) // 1 구간
			returnScore = returnScore + 5;
		else if (d < 2 * L)
			returnScore = returnScore + 4;
		else if (d < 3 * L)
			returnScore = returnScore + 3;
		else if (d < 4 * L)
			returnScore = returnScore + 2;
		else if (d < 5 * L)
			returnScore = returnScore + 1;

		return returnScore;
	}

	public Position play(OmokBoard board) {
		int[][] tempMatrix = new int[board.ROWS][board.COLS];
		Position selectPosition = new Position(0, 0);

		for (int i = 0; i < board.ROWS; i++) {
			for (int j = 0; j < board.COLS; j++) {
				if (board.getStone(i, j) == StoneType.None) {
					tempMatrix[i][j] = evaluatePosition(board, i, j);
				} else {
					tempMatrix[i][j] = -1;
				}
			}
		}

		/////////////////// 가장 좋은 위치 찾기 ///////////////////
		int maxScore = tempMatrix[0][0];
		int maxX = 0, maxY = 0;

		for (int i = 0; i < board.ROWS; i++) {
			for (int j = 0; j < board.COLS; j++) {
				if (maxScore <= tempMatrix[i][j]) {
					maxScore = tempMatrix[i][j];
					maxX = i;
					maxY = j;
				}
			}
		}
		selectPosition = new Position(maxX, maxY);

		return selectPosition;
	}
}
