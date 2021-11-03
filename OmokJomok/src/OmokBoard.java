public abstract class OmokBoard {
	protected int ROWS;
	protected int COLS;
	protected StoneType[][] matrix;

	abstract public void setBoardSize(int BoardSize);

	abstract public void display();

	abstract public void initBoard();

	public OmokBoard() {
		ROWS = 19;
		COLS = 19;
		matrix = new StoneType[ROWS][COLS];
	}

	public OmokBoard(int rows, int cols) {
		ROWS = rows;
		COLS = cols;
		matrix = new StoneType[ROWS][COLS];
	}

	public void putStone(int x, int y, StoneType stone) {
		matrix[x][y] = stone;
	}

	public void removeStone(int x, int y) {
		matrix[x][y] = StoneType.None;
	}

	public StoneType getStone(int x, int y) {
		return matrix[x][y];
	}

	public void clear() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				matrix[i][j] = StoneType.None;
			}
		}
	}

	public int getRowCount() {
		return ROWS;
	}

	public int getColCount() {
		return COLS;
	}

	public void countSameColorStones(Position m, StoneType color, int[] stoneNum) {
		for (int i = 0; i < 8; i++) {
			stoneNum[i] = 0;
		}

		for (int i = 1; i < 5; i++) // 대각선 왼쪽 위
		{
			if ((m.getRow() - i < 0) || (m.getColumn() - i < 0) || (m.getRow() - i < 0 && m.getColumn() - i < 0))
				break;

			if (matrix[m.getRow() - i][m.getColumn() - i] == color)
				stoneNum[0] = i;
			else if (matrix[m.getRow() - i][m.getColumn() - i] != color)
				break;
		}

		for (int i = 1; i < 5; i++) // 위로
		{
			if ((m.getRow() - i) < 0)
				break;

			if (matrix[m.getRow() - i][m.getColumn()] == color)
				stoneNum[1] = i;
			else if (matrix[m.getRow() - i][m.getColumn()] != color)
				break;
		}

		for (int i = 1; i < 5; i++) // 대각선 오른쪽위
		{
			if ((m.getRow() - i < 0) || (m.getColumn() + i >= COLS)
					|| ((m.getRow() - i) < 0 && (m.getColumn() + i) >= COLS))
				break;

			if (matrix[m.getRow() - i][m.getColumn() + i] == color)
				stoneNum[2] = i;
			else if (matrix[m.getRow() - i][m.getColumn() + i] != color)
				break;
		}

		for (int i = 1; i < 5; i++) // 오른쪽
		{
			if (m.getColumn() + i >= COLS)
				break;

			if (matrix[m.getRow()][m.getColumn() + i] == color)
				stoneNum[3] = i;
			else if (matrix[m.getRow()][m.getColumn() + i] != color)
				break;
		}

		for (int i = 1; i < 5; i++) // 대각선 오른쪽 아래
		{
			if ((m.getRow() + i >= ROWS) || (m.getColumn() + i >= COLS)
					|| (m.getRow() + i >= ROWS && m.getColumn() + i >= COLS))
				break;

			if (matrix[m.getRow() + i][m.getColumn() + i] == color)
				stoneNum[4] = i;
			else if (matrix[m.getRow() + i][m.getColumn() + i] != color)
				break;
		}

		for (int i = 1; i < 5; i++) // 아래
		{
			if (m.getRow() + i >= ROWS)
				break;

			if (matrix[m.getRow() + i][m.getColumn()] == color)
				stoneNum[5] = i;
			else if (matrix[m.getRow() + i][m.getColumn()] != color)
				break;
		}

		for (int i = 1; i < 5; i++) // 대각선 왼쪽 아래
		{
			if ((m.getRow() + i >= ROWS) || (m.getColumn() - i < 0)
					|| ((m.getRow() + i) >= ROWS && (m.getColumn() - i) < 0))
				break;

			if (matrix[m.getRow() + i][m.getColumn() - i] == color)
				stoneNum[6] = i;
			else if (matrix[m.getRow() + i][m.getColumn() - i] != color)
				break;
		}

		for (int i = 1; i < 5; i++) // 왼쪽
		{
			if (m.getColumn() - i < 0)
				break;

			if (matrix[m.getRow()][m.getColumn() - i] == color)
				stoneNum[7] = i;
			else if (matrix[m.getRow()][m.getColumn() - i] != color)
				break;
		}
	}
}
