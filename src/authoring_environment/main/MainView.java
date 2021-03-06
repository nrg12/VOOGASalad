/**
 * 
 */
package authoring_environment.main;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author loganrooper
 *
 */
public class MainView {
    
    public static final String DEFAULT_RESOURCE_PACKAGE = "css/";
    public static final String STYLESHEET = "authoring.css";
    
	BorderPane bp;
	Stage myStage;

	public MainView(Stage myStage) {
		ResourceBundle r = ResourceBundle.getBundle("resources/EnvironmentGUIResources");
		this.myStage = myStage;
		bp = new BorderPane();
		int width = Integer.parseInt(r.getString("ViewWidth"));
		int height = Integer.parseInt(r.getString("ViewHeight"));
		Scene s = new Scene(bp, width, height, Color.WHITE);
		s.getStylesheets().add(DEFAULT_RESOURCE_PACKAGE + STYLESHEET);
		myStage.setScene(s);
		myStage.show();
	}

	public void init() {
		
	}

	/**
	 * @param leftBP the left borderpane
	 */
	public void setPanes(Pane leftBP, ScrollPane middlePane, Pane rightPane) {
		bp.setLeft(leftBP);
		bp.setCenter(middlePane);
		bp.setRight(rightPane);
	}

	/**
	 * @param toolbar
	 */
	public void setMenuBar(MenuBar menuBar) {
		bp.setTop(menuBar);
	}
}