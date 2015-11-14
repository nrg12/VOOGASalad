package authoring_environment.Action.GUI;

import java.util.ResourceBundle;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import structures.data.events.IDataEvent;

public class ActionGUI {
	private Scene myScene;
	private Stage myStage;
	private Group myRoot;
	private ResourceBundle r = ResourceBundle.getBundle("authoring_environment/Action/GUI/ActionGUIResources");
	public ActionGUI(Stage stage){
		try{
			myRoot = new Group();
			myStage = stage;
			init();
		}
		catch (NullPointerException e){
		}

	}
	public void init() {
		myStage.setTitle(r.getString("title"));
		TextField text = new TextField(r.getString("textfield"));
		text.setAlignment(Pos.TOP_LEFT);
		text.setMinWidth(Integer.parseInt(r.getString("screenWidth")));
		text.setMinHeight(Integer.parseInt(r.getString("screenHeight")));
		myRoot.getChildren().add(text);
		myStage.setScene(new Scene(myRoot ));
		myStage.show();

	}
}
