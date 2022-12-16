package team_f;

import static team_f.Stage.mapdata;

import java.util.Timer;
import java.util.TimerTask;

public class MoveMonster {
	public static int StartX;// 시작포인트 받아와야함
	public static int StartY;// 시작포인트 받아와야함
	public static int EndX,EndY;//끝 포인트 받아와야함
	int NextX;
	int NextY;
	int[][] MoveData = new int[16][24];
	int count = 0;
	int Move = 0;// 0일때 X방향 1일때 -Y방향 2일때 +Y방향
	int Point[] = new int[2]; //현제좌표 
	int X,Y;
	public void Copydata() {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 24; j++) {
				MoveData[i][j] = mapdata[i][j];
			}
		}
	}

	public MoveMonster() {
		// TODO Auto-generated constructor stub
		/*
		 * for(int i=0;i<16;i++) { if(mapdata[i][23]==1) { StartY=i; } }
		 */
		NextX = StartX;
		NextY = StartY;
		Point[0] = StartX * 30;
		Point[1] = StartY * 30 - 20;
	}

	public void MovePoint() {
		if (count == 0) { // 카운터가 0이면 다음 줄 탐색
			MoveData[NextY][NextX]=2;
		/*	for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 24; j++) {
					System.out.print(MoveData[i][j]);
				}
				System.out.println();
			}*/
			if (NextY >= 0 && NextX >= 0) {
				if (MoveData[NextY][NextX + 1] == 1) {
					Move = 0;
					X=NextX;
					Y=NextY;
					NextX = NextX + 1;
					Point[0] = X * 30;
					Point[1] = Y * 30 - 20;
				}else if(MoveData[NextY][NextX - 1] == 1) {
					Move = 3;
					X=NextX;
					Y=NextY;
					NextX = NextX - 1;
					Point[0] = X * 30;
					Point[1] = Y * 30 - 20;
				} else if (MoveData[NextY - 1][NextX] == 1) {
					Move = 1;
					X=NextX;
					Y=NextY;
					NextY = NextY - 1;
					Point[0] = X * 30;
					Point[1] = Y * 30 - 20;
				} else if (MoveData[NextY + 1][NextX] == 1) {
					Move = 2;
					X=NextX;
					Y=NextY;
					NextY = NextY + 1;
					Point[0] = X * 30;
					Point[1] = Y * 30 - 20;
				}

			}
			count++;
		}else {
			if(Move==0) {
				Point[0]=Point[0]+1;
				count++;
			}else if(Move==1) {
				Point[1]=Point[1]-1;
				count++;
			}else if(Move==2) {
				Point[1]=Point[1]+1;
				count++;
			}else if(Move==3) {
				Point[0]=Point[0]-1;
				count++;
			}
			if(count==31) {
				count=0;
			}
		}

	
	}

}
