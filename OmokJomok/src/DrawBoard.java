import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawBoard extends JPanel {
	private Graphics gboard, gbuff;
	private Image buff;
	MapSize size;
	Map map;
	final int STONE_SIZE = 28;

	public DrawBoard(MapSize m, Map map) {
		// TODO Auto-generated constructor stub
		setBackground(new Color(206, 167, 61));
		size = m;
		setLayout(null);
		this.map = map;
	}

	public void paint(Graphics g) {
		if (gbuff == null) {
			buff = createImage(getWidth(), getHeight());
			gbuff = buff.getGraphics();
		}
		drawBoard(g);
	}

	private void drawLine() {
		gbuff.setColor(Color.black);
		for (int i = 1; i <= size.getSize(); i++) {
			gbuff.drawLine(size.getCell(), i * size.getCell(), size.getCell() * size.SIZE, i * size.getCell());
			gbuff.drawLine(i * size.getCell(), size.getCell(), i * size.getCell(), size.getCell() * size.SIZE);
		}
	}

	public void drawBlack(int x, int y) {
		Graphics2D gbuff = (Graphics2D) this.gbuff;
		gbuff.setColor(Color.black);
		gbuff.fillOval(x * size.getCell() - size.getCell() / 2, y * size.getCell() - size.getCell() / 2, size.getCell(),
				size.getCell());
	}

	public void drawWhite(int x, int y) {
		gbuff.setColor(Color.white);
		gbuff.fillOval(x * size.getCell() - size.getCell() / 2, y * size.getCell() - size.getCell() / 2, size.getCell(),
				size.getCell());
	}

	public void drawobstacle(int x, int y) {
		gbuff.setColor(Color.red);
		gbuff.fillOval(x * size.getCell() - size.getCell() / 2, y * size.getCell() - size.getCell() / 2, size.getCell(),
				size.getCell());
	}

	private void drawStones() {
		for (int x = 1; x <= size.SIZE; x++)
			for (int y = 1; y <= size.SIZE; y++) {
				if (map.getXY(y, x) == map.getBlack())
					drawBlack(x, y);
				else if (map.getXY(y, x) == map.getWhite())
					drawWhite(x, y);
				else if (map.getXY(y, x) == map.get_Black()) {
					drawBlack(x, y);
					map.setXY(y, x);
				} else if (map.getXY(y, x) == map.get_White()) {
					drawWhite(x, y);
					map.setXY(y, x);
				} else if (map.getXY(y, x) == map.getobstacle()) {
					drawobstacle(x, y);
				}
			}
	}

	private void drawBoard(Graphics g) {
		gbuff.clearRect(0, 0, getWidth(), getHeight());
		drawLine();
		drawStones();
		gbuff.setColor(Color.red);
		g.drawImage(buff, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

}
