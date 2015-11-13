package structures.run;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import structures.IObject;
import structures.IRoom;
import structures.data.DataGame;

public class RunGame implements Cloneable {

	private final String myName;
	private List<RunRoom> myRooms;
	private double myWidth, myHeight;

	private int myCurrentRoomNumber;

	public RunGame(DataGame dataGame) {
		myName = dataGame.getName();
		myWidth = dataGame.getWidth();
		myHeight = dataGame.getHeight();
	}

	public String getName() {
		return myName;
	}

	public RunRoom getCurrentRoom() {
		return myRooms.get(myCurrentRoomNumber);
	}

	public DataGame toData() {
		Map<String, IRoom> rooms = new HashMap<>();
		Map<String, IObject> objects = new HashMap<>();
		for (RunRoom runRoom : myRooms) {
			rooms.put(runRoom.myName, runRoom.toData());
			for (RunObject runObject : runRoom.myObjects) {
				objects.put(runObject.name, runObject.toData());
			}
		}
		String currentRoom = myRooms.get(myCurrentRoomNumber).myName;
		String startRoom = myRooms.get(0).myName;
		return new DataGame(myName);
	}
	
	@Override
	public RunGame clone()
	{
	    RunGame rg;
	    try
	    {
	        rg = (RunGame) super.clone();
	    }
	    catch (CloneNotSupportedException e)
	    {
	        throw new Error();
	    }
	    return rg;
	}
}
