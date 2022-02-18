/*
 * Levi Crider
 * 2/9/22
 * Turtle Game!
 * Create a game that allows the turtle to move across the screen with arrow keys or mouse clicks
 * 
 * 
 */
import java.util.ArrayList;


public class Model {
	//Member variables
	ArrayList<Brick> bricks = new ArrayList<Brick>();

	//Constructor
	Model()
	{
		
	}

	public void update()
	{
		
	}

	
	
	//Adds brick to the screen on mouseclick
	public void addBrickToScreen(int X, int Y) {
		int x = X - X % 50;
		int y = Y - Y % 50;
		Brick n = new Brick(x,y);
//		bricks.add(n);
		if (!detectBrick(x,y)) {
			bricks.add(n);
		}
		else {
			n = null;
			System.out.println("There is already a brick there!");
		}
		
		
	}
	
	//Makes sure we aren't placing two bricks in the same location
		public boolean detectBrick(int locationx, int locationy) {
			if(bricks.size() == 0) {
				return false;
			}
			for (int i = 0; i < bricks.size(); i++) {
				Brick testing = bricks.get(i);
				if ((locationx >= testing.x && locationx <= testing.x + testing.w) && (locationy >= testing.y && locationy <= testing.y + testing.h)) {
					return true;
				}
			}
			return false;
		}
	
	
	
}
