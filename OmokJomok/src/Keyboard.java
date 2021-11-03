import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Keyboard extends JFrame implements KeyListener{
	Map map;
	int x=11,y=11;
	MapSize ms;
	DrawBoard d;
	GUI main;
	
	public Keyboard(Map m,MapSize ms,DrawBoard d,GUI main) {
		// TODO Auto-generated constructor stub
		this.map=m;
		this.ms=ms;
		this.d=d;
		this.main=main;
	}
	JLabel k = new JLabel();

	   public void keyPressed(KeyEvent e){
	    switch(e.getKeyCode()){
	     //À§
	     case 38:
	    	 if(y==1) {
	    		 return;
	    	 }
	    	 if(map.getXY(y-1, x) != 0) {
	        	   return;
	           }

	    	 y--;
	    	 map.setTest(y, x);
	   	    	d.repaint();

	      break;
	      
	     //¾Æ·¡
	     case 40:
	    	 if(y==20) {
	    		 return;
	    	 }
	    	 if(map.getXY(y+1, x) != 0) {
	        	   return;
	           }

	    	 y++;
	    	 map.setTest(y, x);
	   	    	d.repaint();

	      break;
	      
	     //¿Þ¦U
	     case 37:
	    	 if(x==1) {
	    		 return;
	    	 }
	    	 if(map.getXY(y, x-1) != 0) {
	        	   return;
	           }

	    	 x--;
	    	 map.setTest(y, x);
	   	    	d.repaint();

	      break;
	      
	     //¿À¸¥¦U
	     case 39:
	    	 if(x==20) {
	    		 return;
	    	 }
	    	 if(map.getXY(y, x+1) != 0) {
	        	   return;
	           }

	    	 x++;
	    	 map.setTest(y, x);
	   	    	d.repaint();

	      break;
	      
	     case 32:
	    	map.setMap(y, x);
	 	    map.changeCheck();
	 	    d.repaint();
	 	    if(map.winCheck(x, y))
	 	    	if(map.getCheck()==true)
	 	    		main.showPopUp("¹éµ¹ ½Â¸®!");
	 	    	else
	 	    		main.showPopUp("Èæµ¹ ½Â¸®!");

	   
	   }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}


