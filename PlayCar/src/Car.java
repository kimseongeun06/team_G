import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Car {
	public int x = 0;
	public int y = 0;
	public BufferedImage image;

	public Car(String imagePath, int x, int y ) {
		try {
			this.image = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TEST File..
		}
		this.x = x;
		this.y = y;
	}
}