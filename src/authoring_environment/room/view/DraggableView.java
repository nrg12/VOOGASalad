package authoring_environment.room.view;


import authoring_environment.room.preview.DraggableNode;
import javafx.beans.property.DoubleProperty;

public class DraggableView extends DraggableNode {
	private DoubleProperty myWidth;
	private DoubleProperty myHeight;
	private DoubleProperty myX;
	private DoubleProperty myY;
	private boolean isVisible;
	
	public DraggableView(DoubleProperty x, DoubleProperty y, double angle, boolean visibility, double scaleX, double scaleY, double alpha) {
		super(x, y, angle, visibility, scaleX, scaleY, alpha);
		isVisible = false;
	}

	@Override
	public Object getImage() {
		return this;
	}
	
	public void setVisible(boolean visible) {
		isVisible = visible;
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	public DoubleProperty getWidthProperty() {
		return myWidth;
	}
	
	public DoubleProperty getHeightProperty() {
		return myHeight;
	}
	
	public DoubleProperty getXProperty() {
		return myX;
	}
	
	public DoubleProperty getYProperty() {
		return myY;
	}

	@Override
	public double getWidth() {
		return myWidth.get();
	}

	@Override
	public double getHeight() {
		return myHeight.get();
	}

	public void setWidthProperty(DoubleProperty myWidth) {
		this.myWidth = myWidth;
	}

	public void setHeightProperty(DoubleProperty myHeight) {
		this.myHeight = myHeight;
	}

	public void setXProperty(DoubleProperty myX) {
		this.myX = myX;
	}

	public void setYProperty(DoubleProperty myY) {
		this.myY = myY;
	}

	@Override
	public boolean contains(double x, double y) {
		return (x > this.getX() && x <= this.getX() + this.getWidth() * this.getScaleX() && y > this.getY()
		&& y <= this.getY() + this.getHeight() * this.getScaleY());
	}

	@Override
	public boolean inRoomWidthBounds(double x, double roomWidth) {
		return x >= 0 && x <= roomWidth - this.getWidth();
	}

	@Override
	public boolean inRoomHeightBounds(double y, double roomHeight) {
		return y >= 0 && y <= roomHeight - this.getHeight();
	}

}
