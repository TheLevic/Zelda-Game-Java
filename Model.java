/*
 * Levi Crider
 * 2/9/22
 * Legend of Zelda
 *
 * 
 * 
 */
import java.util.ArrayList;


public class Model {
	//Member variables
	Link link;

	//Constructor
	Model(){
		link = new Link();
	}

	public void update(){
		Link.update();

		// for (int i = 0; i < Brick.bricks.size(); i++){
		// 	boolean collision = isThereACollision(link, Brick.bricks.get(i));
		// 	if (collision){
		// 		System.out.println("Colliding");
		// 	}
		// }
	}
	

	//Marshalling methods
	Json Marshal(){
		Json ob = Json.newObject();
		Json tmpList = Json.newList();
        ob.add("brick", tmpList);
        for(int i = 0; i < Brick.bricks.size(); i++)
            tmpList.add(Brick.bricks.get(i).Marshal());
        return ob;
	}

	void Unmarshal(Json ob){
		Brick.bricks = new ArrayList<Brick>(); //Making a new list for our bricks
		Json tmplist = ob.get("brick"); //Getting bricks from our file
		for(int i = 0; i < tmplist.size(); i++){
            Brick.bricks.add(new Brick(tmplist.get(i)));
    
		}
	}
	//Loading the map
	public void loadFile(){
		Json loadObject = Json.load("brickLocation.json");
		Unmarshal(loadObject);
	}

	//Checking collisions between bricks and Link
	public boolean isThereACollision(Link l, Brick b){
		if (l.x + l.w < b.x){
			return false;
		}
		if (l.x > b.x + b.w){
			return false;
		}
		if(l.y + l.h < b.y){
			return false;
		}
		if (l.y > b.y + b.h){
			return false;
		}
		return true;
	}
	
	
}
