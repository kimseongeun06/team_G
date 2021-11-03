import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Map{
	public static int[][] map;
   static final int BLACK=1;
   static final int WHITE=-1;
   static final int _BLACK = 2;
   static final int _WHITE = -2;
   ArrayList<Integer> x = new ArrayList<Integer>();
   ArrayList<Integer> y = new ArrayList<Integer>();
   boolean isB = true,isW =true;
   GUI main;
   public static boolean obstacle = false;
   static final int OBSTACLE = 3;
   public static int Ran_x=0, Ran_y=0;
   
   boolean checkBNW=true;
   DrawBoard d=new DrawBoard(null, null);
   MapSize ms;
   
   public Map(MapSize ms, boolean obstacle){
      // TODO Auto-generated constructor stub
      this.ms=ms;
      this.obstacle=obstacle;
      map=new int[ms.getSize()+2][];            
       for(int i=0;i<map.length;i++)
         map[i]=new int[ms.getSize()+2];
       d.setSize(ms.getSize()*(ms.getCell()+1)+ms.getSize(), 
             ms.getSize()*(ms.getCell()+1)+ms.getSize());
   }    
     
     
   public static void checkobstacle() {
	   
	    if(obstacle) {
    	  Random random = new Random();
          random.setSeed(System.currentTimeMillis());           
          for(int i=0; i<5; i++) {
        	  Ran_x = random.nextInt(20)+1;
     		  Ran_y = random.nextInt(20)+1;
        	  while(map[Ran_x][Ran_y]!=0){
        		 Ran_x = random.nextInt(20)+1;
        		 Ran_y = random.nextInt(20)+1; 
        	  }
        	  map[Ran_x][Ran_y] = OBSTACLE;
          }
          
      }
   }
   
   public int getobstacle() {
	   return OBSTACLE;
   }
   public int getBlack() {
      return BLACK;
   }
   public int getWhite() {
      return WHITE;
   }
   public int get_Black() {
		return _BLACK;
	}
   public int get_White() {
		return _WHITE;
   }
   public void setXY(int y, int x) {
		map[y][x]=0;
	}
   public int getXY(int y,int x) {
      return map[y][x];
   }
   public boolean getCheck() {
      return checkBNW;
   }
   public void changeCheck() {
      if(checkBNW)
         checkBNW=false;
      else
         checkBNW=true;
   }
   public boolean checkTurn() {
		return checkBNW;
	}
   public void setMap(int y,int x) {
      if(checkBNW)
         map[y][x]=BLACK;
      else
         map[y][x]=WHITE;
      this.x.add(x);
      this.y.add(y); 
   }
   public void OneReturn() {
	   if(checkBNW){
		   if(!isB) {
			   JOptionPane.showMessageDialog(null, "이미 사용했습니다");
			   return;
		   }
	   }	   
	   else {
		   if(!isW) {
			   JOptionPane.showMessageDialog(null, "이미 사용했습니다");
			   return;
		   }
	   }
	   map[y.get(y.size()-1)][x.get(x.size()-1)]=0;
	   y.remove(y.size()-1);
	   x.remove(x.size()-1);
	   checkcolor();
	   changeCheck();
}
   public void checkcolor() {
	   if(checkBNW){
		   isB=false;
	   }
	   else{
		   isW=false;
	   }
   }
   public boolean isUse(){ 
	   if(checkBNW){
		   return isB;
	   } else{
		   return isW;
	   }
   }
   public void setTest(int y,int x) {
		if(checkBNW)
			map[y][x]=_BLACK;
		else
			map[y][x]=_WHITE;
	}
   public boolean winCheck(int x,int y){
      if(winCheckL(x, y)||winCheckLD(x, y)||winCheckLU(x, y)||winCheckR(x, y)
      ||winCheckRD(x, y)||winCheckRU(x, y)||winCheckUp(x, y)||winCheckDown(x, y)
      ||winCheckOneDown(x, y)||winCheckOneL(x, y)||winCheckOneLD(x, y)||winCheckOneLU(x, y)
      ||winCheckOneR(x, y)||winCheckOneRD(x, y)||winCheckOneUp(x, y)||winCheckOneRU(x, y)
      ||winCheckCenterLU(x, y)||winCheckCenterRL(x, y)||winCheckCenterRU(x, y)||winCheckCenterUD(x, y))
         return true;
      else
         return false;
   }
   
   //위쪽
   public boolean winCheckUp(int x,int y) {
      try{
         for(int i=y;i<y+5;i++){
            if(map[y][x]!=map[i][x])
               return false;
         }   
      }catch(ArrayIndexOutOfBoundsException e){
         return false;
      }
      
      return true;
   }
   //아래쪽
   public boolean winCheckDown(int x,int y) {
      try {
         for(int i=y;i>y-5;i--){
            if(map[y][x]!=map[i][x])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   //오른쪽 위 대각선
   public boolean winCheckRU(int x,int y) {
      try {
         for(int i=y, z=x;i>y-5;i--,z++){
            if(map[y][x]!=map[i][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   
   //왼쪽 위 대각선
   public boolean winCheckLU(int x,int y) {
      try {
         for(int i=y, z=x;i>y-5;i--,z--){
            if(map[y][x]!=map[i][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   
   //오른쪽
   public boolean winCheckR(int x,int y) {
      try {
         for(int z=x;z<x+5;z++){
            if(map[y][x]!=map[y][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   
   //왼쪽
   public boolean winCheckL(int x,int y) {
      try {
         for(int z=x;z>x-5;z--){
            if(map[y][x]!=map[y][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   
   //오른쪽 아래 대각선
   public boolean winCheckRD(int x,int y) {
      try {
         for(int i=y, z=x;i<y+5;i++,z++){
            if(map[y][x]!=map[i][z]||i>19||z>19||i<0||z<0)
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   
   //왼쪽 아래 대각선
   public boolean winCheckLD(int x,int y) {
      try {
         for(int i=y, z=x;i<y+5;i++,z--){
            if(map[y][x]!=map[i][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   //한칸 위쪽
   public boolean winCheckOneUp(int x,int y) {
      try{
         for(int i=y-1;i<y+4;i++){
            if(map[y][x]!=map[i][x])
               return false;
         }   
      }catch(ArrayIndexOutOfBoundsException e){
         return false;
      }
      
      return true;
   }
   //한칸 아래쪽
   public boolean winCheckOneDown(int x,int y) {
      try {
         for(int i=y+1;i>y-4;i--){
            if(map[y][x]!=map[i][x])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   //한칸 오른쪽 위 대각선
   public boolean winCheckOneRU(int x,int y) {
      try {
         for(int i=y+1, z=x-1;i>y-4;i--,z++){
            if(map[y][x]!=map[i][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   
   //한칸 왼쪽 위 대각선
   public boolean winCheckOneLU(int x,int y) {
      try {
         for(int i=y+1, z=x+1;i>y-4;i--,z--){
            if(map[y][x]!=map[i][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   
   //한칸 오른쪽
   public boolean winCheckOneR(int x,int y) {
      try {
         for(int z=x-1;z<x+4;z++){
            if(map[y][x]!=map[y][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   
   //한칸 왼쪽
   public boolean winCheckOneL(int x,int y) {
      try {
         for(int z=x+1;z>x-4;z--){
            if(map[y][x]!=map[y][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   
   //한칸 오른쪽 아래 대각선
   public boolean winCheckOneRD(int x,int y) {
      try {
         for(int i=y-1, z=x-1;i<y+4;i++,z++){
            if(map[y][x]!=map[i][z]||i>19||z>19||i<0||z<0)
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   
   //한칸 왼쪽 아래 대각선
   public boolean winCheckOneLD(int x,int y) {
      try {
         for(int i=y-1, z=x+1;i<y+4;i++,z--){
            if(map[y][x]!=map[i][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   //센터 업다운
   public boolean winCheckCenterUD(int x,int y) {
      try{
         for(int i=y-2;i<y+3;i++){
            if(map[y][x]!=map[i][x])
               return false;
         }   
      }catch(ArrayIndexOutOfBoundsException e){
         return false;
      }
      
      return true;
   }
   //센터 라이트 레프트
   public boolean winCheckCenterRL(int x,int y) {
      try {
         for(int z=x-2;z<x+3;z++){
            if(map[y][x]!=map[y][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   //센터 라이트 대각선
   public boolean winCheckCenterRU(int x,int y) {
      try {
         for(int i=y+2, z=x-2;i>y-3;i--,z++){
            if(map[y][x]!=map[i][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
   //센터 레프트 대각선
   public boolean winCheckCenterLU(int x,int y) {
      try {
         for(int i=y+2, z=x+2;i>y-4;i--,z--){
            if(map[y][x]!=map[i][z])
               return false;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         // TODO: handle exception
         return false;
      }
      
      return true;
   }
}