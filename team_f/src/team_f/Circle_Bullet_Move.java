package team_f;
import static team_f.Screen.mousePoint;
public class Circle_Bullet_Move {
	int StartX;
	int StartY;
	int EndX;
	int EndY;
	double x=720;
	double y=480;
	double vx , vy;
	public Circle_Bullet_Move() {
		this.EndX = mousePoint[0];
		this.EndY = mousePoint[1];
	}
	public void StartSetting(int Sx, int Sy) {//타워 서클의 xx와 yy 받아올것 총알의 시작 포인트 설정
		this.StartX = Sx;
		this.StartY= Sy;
		
		y = StartY;
		x = StartX;


	}
	public void lunch() { //마우스 위치 포인트
		this.EndX = mousePoint[0];
		this.EndY = mousePoint[1];
		double d = Math.sqrt(Math.pow((EndX - StartX), 2) + Math.pow((EndY - StartY), 2));
		vx = ((EndX - StartX) / d * 1);
		 vy =((EndY - StartY) / d * 1); 
	}
	public void movepoint() { // 좌표 계산할부분
	/*if((StartX - EndX)> 0) {
	x= x-1;
	 y = ((EndY - StartY) / (EndX - StartX))*(x - StartX) +StartY;
	}else if((StartX- EndX) ==0) {
		y = y-1;
	}else if((StartX- EndX)<0) {
		x= x+1;
		 y = ((EndY - StartY) / (EndX - StartX))*(x - StartX) +StartY;
			
	}*/
		x += vx;
		y += vy;  
	
	
	
	}
}
