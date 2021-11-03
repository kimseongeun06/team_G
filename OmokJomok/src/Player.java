public abstract class Player {
	protected int id;
	protected String name;
	protected double winningRate;
	protected int order;
	protected int playerType;

	abstract public Position play(OmokBoard board);

	public Player() {
		id = -10000;
		name = "";
		winningRate = 0;
		order = 0;
		playerType = 0;
	}

	public Player(int id, String name, int order, int playerType) {
		this.id = id;
		this.name = name;
		this.order = order;
		this.playerType = playerType;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getWinningRate() {
		return winningRate;
	}

	public int getOrder() {
		return order;
	}

	public int getPlayerType() {
		return playerType;
	}
}
