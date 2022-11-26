package team_f;

import static team_f.Stage.mapdata;

import java.util.Timer;
import java.util.TimerTask;

public class MoveMonster {
	int StartX = 23;
	int StartY = 7;
	int NextX;
	int NextY;
	int[][] MoveData = new int[16][24];
	public static int Point[] = new int[2];

	public void Copydata() {
		for(int i=0;i<16;i++) {
			for(int j=0;j<24;j++) {
				MoveData[i][j]=mapdata[i][j];
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
		Point[1] = StartY * 30-30;
	}

	public void MovePoint() {
		System.out.println(1);
		++MoveData[NextY][NextX];
		for(int i=0;i<16;i++) {
			for(int j=0;j<24;j++) {
				System.out.print(MoveData[i][j]);
			}System.out.println();
		}
		if (NextY >= 0 && NextX >= 0) {
			if (MoveData[NextY][NextX - 1] == 1) {
				NextX = NextX - 1;
				Point[0] = NextX * 30;
			} else if (MoveData[NextY - 1][NextX] == 1) {
				NextY = NextY - 1;
				Point[1] = NextY * 30-20;
			} else if (MoveData[NextY + 1][NextX] == 1) {
				NextY = NextY + 1;
				Point[1] = NextY * 30-20;
			}

		}

	}

}
