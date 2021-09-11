import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Screen extends Canvas implements KeyListener {

	public Car car[] = new Car[2];
	private static final long serialVersionUID = 1L;

	public Screen() {
		car[0] = new Car("src/car.png", 0, 0);
		car[1] = new Car("src/car1.png", 0, 50);
		addKeyListener(this);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(car[0].image, car[0].x, car[0].y, this);
		g.drawImage(car[1].image, car[1].x, car[1].y, this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int gap = 10;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			car[0].y -= gap;
			car[1].y -= gap;
			break;
		case KeyEvent.VK_DOWN:
			car[0].y += gap;
			car[1].y += gap;
			break;
		case KeyEvent.VK_LEFT:
			car[0].x -= gap;
			car[1].x -= gap;
			break;
		case KeyEvent.VK_RIGHT:
			car[0].x += gap;
			car[1].x += gap;
			break;
		}
		System.out.println("1번차 x: " + car[0].x + ", " + "1번차 y: " + car[0].y);
		System.out.println("2번차 x: " + car[1].x + ", " + "2번차 y: " + car[1].y);
		repaint();
	}

}
