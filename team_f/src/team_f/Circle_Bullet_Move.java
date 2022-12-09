package team_f;

public class Circle_Bullet_Move {
	int StartX;
	int StartY;
	int EndX;
	int EndY;
	int Point[]=new int[2];
	public void StartSetting(int Sx, int Sy) {//타워 서클의 xx와 yy 받아올것 총알의 시작 포인트 설정
		this.StartX = Sx+30; 
		this.StartY= Sy+30;
	}
	public void lunch(int[] point) { //마우스 위치 포인트
		this.EndX = point[0];
		this.EndY = point[1];
	}
	public void movepoint() { // 좌표 계산할부분
		
	}
}
