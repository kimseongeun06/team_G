import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventHandler extends MouseAdapter {
	Map map;
	int x,y;
	MapSize ms;
	DrawBoard d;
	GUI main;
	public MouseEventHandler(Map m,MapSize ms,DrawBoard d,GUI main) {
		// TODO Auto-generated constructor stub
		map=m;
		this.ms=ms;
		this.d=d;
		this.main=main;
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		super.mousePressed(arg0);
		int x=(int)Math.round(arg0.getX()/(double)ms.getCell());
        int y=(int)Math.round(arg0.getY()/(double)ms.getCell())-2;
        if(x==0 || y==0 || x==ms.getSize()+1 || y==ms.getSize()+1)return;
        if(map.getXY(y, x)==map.getBlack()||map.getXY(y, x)==map.getWhite()||(map.getXY(y, x)==map.getobstacle()))return;
	    
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
