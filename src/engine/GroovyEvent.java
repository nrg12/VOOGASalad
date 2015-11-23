package engine;

import structures.data.events.IDataEvent;
import utils.Point;

public class GroovyEvent {
	
	private boolean hasCoordinates;
	private boolean checkCoordinates;
	private Point coordinates;
	
	public GroovyEvent(IDataEvent event){
		hasCoordinates = event.hasXY();
		checkCoordinates = event.getLocalCheck();
	}
	
	public void setCoordinates(Point location){
		coordinates = location;
	}
	
	public Point getCoordinates(){
		return coordinates;
	}
	
	public double get_x(){
		return coordinates.x;
	}
	
	public double get_y(){
		return coordinates.y;
	}
	
	public boolean hasXY(){
		return hasCoordinates;
	}
	
	public boolean getLocalCheck(){
		return checkCoordinates;
	}

}