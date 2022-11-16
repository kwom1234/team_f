package team_f;

public class Monster_State {
	public int width = 0;
	public int height = 0;
	public int index_x = 0;
	public int index_y = 0;
	public int start_x = 0;
	public int start_y = 0;
	public int frame_size = 0;
	public int HP=0;
	public int Power=0;
	public int Speed= 0;
	public int Drop =10;
	public boolean stop = false;
	public boolean fristCheck = false;
	
	public void clear() {
		this.fristCheck = false;
	}
}
