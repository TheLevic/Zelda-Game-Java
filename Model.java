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
		bricks.add(n);
		
		
	}
	
	
	//Makes sure we can place a brick (There isn't one there already)
	public boolean detectBrick(Brick y) {
		return false;
	}
	
	
	
}
