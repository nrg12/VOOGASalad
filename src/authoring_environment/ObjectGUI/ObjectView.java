package authoring_environment.ObjectGUI;

import java.util.Map;
import java.util.ResourceBundle;

import authoring_environment.ObjectGUI.bottomPane.ObjectBottomPane;
import authoring_environment.ObjectGUI.centerPane.ObjectCenterPane;
import authoring_environment.ObjectGUI.leftPane.ObjectLeftPane;
import authoring_environment.ObjectGUI.rightPane.ObjectRightPane;
import authoring_environment.ObjectGUI.topPane.ObjectTopPane;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import structures.data.DataObject;

public class ObjectView {
	private Scene myScene;
	private Stage myStage;
	private Group myRoot;
	private String objectName;
	private ObjectController myController;
	//private DataObject myObject;
	private ResourceBundle r = ResourceBundle.getBundle("authoring_environment/ObjectGUI/ObjectGUIResources");

	public ObjectView(ObjectController controller) {
		myRoot = new Group();
		try {
		objectName = myController.getName();
		}
		catch (NullPointerException e){
			objectName = "";
		}

	}

	public void init() {
		myStage = new Stage();
		myStage.setTitle(r.getString("title") + objectName);
		BorderPane myPane = new BorderPane();
		ObjectBottomPane bottom = new ObjectBottomPane(myController);
		ObjectTopPane top = new ObjectTopPane(myController);
		ObjectRightPane right = new ObjectRightPane(myController);
		ObjectLeftPane left = new ObjectLeftPane(myController);
		ObjectCenterPane center = new ObjectCenterPane();
		myPane.setRight(right.init());
		myPane.setBottom(bottom.init());
		myPane.setTop(top.init());
		myPane.setLeft(left.init());
		myPane.setCenter(center.init());
		myScene = new Scene(myPane, Integer.parseInt(r.getString("screenWidth")), Integer.parseInt(r.getString("screenHeight")));
		myRoot.getChildren().add(myPane);
		myStage.setScene(new Scene(myRoot));
		myStage.show();
	}

}
