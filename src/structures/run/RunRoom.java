package structures.run;

import java.util.List;

import exceptions.CompileTimeException;
import exceptions.GameRuntimeException;
import javafx.scene.image.Image;
import structures.data.DataRoom;
import utils.Utils;

public class RunRoom {
	
	private String myName;
	private RunView myView;
	private String background;
	private Image myBackgroundImage;
	private List<RunObject> myObjects;
	private RunObjectConverter myConverter;
	private DataRoom myDataRoom;
	private double myWidth, myHeight;
	
	public RunRoom(String gameName, DataRoom dataRoom, RunObjectConverter converter) throws CompileTimeException {
		myName = dataRoom.getName();
		background = dataRoom.getBackgroundColor();
		if(background != null){
			try {
				myBackgroundImage = new Image("/" + gameName + "/backgrounds/" + background);
			}
			catch(IllegalArgumentException e){
				myBackgroundImage = null;
			}
		}
		double[] mySize = dataRoom.getSize();
		myWidth = mySize[0];
		myHeight = mySize[1];
		myDataRoom = dataRoom;
		myConverter = converter;
		myView = new RunView(dataRoom.getView());
		
		try {
			myObjects = Utils.transform(dataRoom.getObjectInstances(), e -> converter.instantiate(e));
		} catch (GameRuntimeException e) {
			throw new CompileTimeException(e.getMessage());
		}
	}
	
	public RunObject instantiate(String name, double x, double y) throws GameRuntimeException {
		RunObject obj = myConverter.instantiate(name, x, y);
		myObjects.add(obj);
		return obj;
	}
	
	public String getName() {
		return myName;
	}
	
	public String toString() {
	    return myName;
	}
	
	public Image getBackgroundImage(){
		return myBackgroundImage;
	}
	
	public String getBackground(){
		return background;
	}
	
	public List<RunObject> getObjects() {
		return myObjects;
	}
	
	public RunView getView() {
		return myView;
	}
	
	public double getWidth(){
		return myWidth;
	}
	
	public double getHeight(){
		return myHeight;
	}
	
	public DataRoom toData() throws CompileTimeException {
	    try {
                myDataRoom.setRoomObjects(Utils.transform(myObjects, e -> myConverter.toData(e)));
        } catch (GameRuntimeException e) {
                throw new CompileTimeException(e.getMessage());
        }
	    return myDataRoom;
	}

}
