package authoring_environment.Event;

import java.util.ResourceBundle;


import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EventView {
	EventBottomPane bottom;
	EventTopPane top;
	EventRightPane right;
	EventLeftPane left;
	private Stage myStage;
	private Group myRoot;
	private ResourceBundle r = ResourceBundle.getBundle("authoring_environment/Event/EventGUIResources");
	public EventView(){
		init();
	}

	private void init() {
		myStage = new Stage();
		myRoot = new Group();
		myStage.setTitle(r.getString("title"));
		BorderPane myPane = new BorderPane();
		 bottom = new EventBottomPane();
		 right = new EventRightPane();
		 top = new EventTopPane();
		 left = new EventLeftPane();
		myPane.setRight(right.init());
		myPane.setBottom(bottom.init());
		myPane.setTop(top.init());
		myPane.setLeft(left.init());
		myRoot.getChildren().add(myPane);
		myStage.setScene(new Scene(myRoot));
		myStage.show();
	}

	public EventBottomPane getBottomPane() {
		// TODO Auto-generated method stub
		return bottom;
	}
	public EventTopPane getTopPane() {
		// TODO Auto-generated method stub
		return top;
	}
	public EventLeftPane getLeftPane() {
		// TODO Auto-generated method stub
		return left;
	}
	public EventRightPane getRightPane() {
		// TODO Auto-generated method stub
		return right;
	}



}

