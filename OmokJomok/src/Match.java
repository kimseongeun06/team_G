
public abstract class Match {
	protected Player[] players = new Player[2]; // setPlayer 메소드를 통해 저장
	protected int turn;
	protected int playType;
	protected OmokBoard playerBoard = new MyBoard();
	protected int boardSize; // 0이면 10x10, 1이면 15x15, 2이면 19x19

	abstract public boolean getCheckWinningCondition(Position m);

	abstract public boolean getCheckValidity(Position m);

	protected boolean checkWinningCondition(Position m) {
		int[] stoneNum = new int[8];
		for (int i = 0; i < 8; i++) {
			stoneNum[i] = 0;
		}

		StoneType color = getCurrentColor();
		System.out.println(color+" 색상 체크");
		playerBoard.countSameColorStones(m, color, stoneNum);

		if (stoneNum[0] == 4)
			return true;
		else if (stoneNum[1] == 4)
			return true;
		else if (stoneNum[2] == 4)
			return true;
		else if (stoneNum[3] == 4)
			return true;
		else if (stoneNum[4] == 4)
			return true;
		else if (stoneNum[5] == 4)
			return true;
		else if (stoneNum[6] == 4)
			return true;
		else if (stoneNum[7] == 4)
			return true;
		else if (stoneNum[0] + stoneNum[4] == 4)
			return true;
		else if (stoneNum[1] + stoneNum[5] == 4)
			return true;
		else if (stoneNum[2] + stoneNum[6] == 4)
			return true;
		else if (stoneNum[3] + stoneNum[7] == 4)
			return true;
		else
			return false;
	}

	protected boolean checkValidity(Position m) {
		if (playerBoard.getStone(m.getRow(), m.getColumn()) == StoneType.Black)
			return false;
		else if (playerBoard.getStone(m.getRow(), m.getColumn()) == StoneType.White)
			return false;
		else
			return true;
	}

	public Match() {
		turn = 1;
		boardSize = 2;
		playerBoard.setBoardSize(boardSize);

		for (int i = 0; i < 2; i++) {
			players[i] = null;
		}
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int n) {
		turn = n;
	}

	public Player getPlayer(int n) {
		return players[n];
	}

	public Player getCurrentPlayer() {
		return players[turn];
	}

	public StoneType getCurrentColor() {
		if (turn == 1)
			return StoneType.Black;
		else if (turn == 2)
			return StoneType.White;
		else
			return StoneType.None;
	}

	public OmokBoard getBoard() {
		return playerBoard;
	}

	public void setBoard(OmokBoard board) {
		playerBoard = board;
	}

	public void setPlayer(int n, Player player) {
		players[n] = player;
	}

	public int getPlayerType() {
		return playType;
	}

	public void setPlayerType(int n) {
		playType = n;
	}
}
