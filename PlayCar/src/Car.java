import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Car {
	private String x;
	private String y;
	
	public Car(String x, String y) {
		this.x = x;
		this.y = y;
	}
	
	
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(image, x, y, this);
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int gap = 10;
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			y -= gap;
			break;
		case KeyEvent.VK_DOWN:
			y += gap;
			break;
		case KeyEvent.VK_LEFT:
			x -= gap;
			break;
		case KeyEvent.VK_RIGHT:
			x += gap;
			break;
		}
		System.out.println(x+", "+y);
		repaint();
	}


	
}
