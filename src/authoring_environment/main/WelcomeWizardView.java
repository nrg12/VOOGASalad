/**
 * 
 */
package authoring_environment.main;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;

import Player.Launcher;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import structures.data.DataGame;
import utils.GameSelector;

/**
 * @author loganrooper
 *
 */
public class WelcomeWizardView {
	private ResourceBundle r = ResourceBundle.getBundle("resources/EnvironmentGUIResources");
	DataGame dataGame;
	Stage myStage;

	
	public WelcomeWizardView(Stage myStage) {
		this.myStage = myStage;
	}
	
	/**
	 * Welcomes the user to authoring- gets the datagame rolling
	 * @return the new datagame
	 */
	public DataGame showAndWait() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Authoring Environment");
		alert.setHeaderText("Welcome to the Authoring Environment");
		alert.setContentText("What would you like to do?");

		ButtonType openGameBtn = new ButtonType("Open Game");
		ButtonType newGameBtn = new ButtonType("New Game");
		ButtonType buttonTypeCancel = new ButtonType("Close");

		alert.getButtonTypes().setAll(openGameBtn, newGameBtn, buttonTypeCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == openGameBtn){
			dataGame = GameSelector.getGameChoice();
		} else if (result.get() == newGameBtn) {
			try{
			String name = new TextInputDialog("GameName").showAndWait().get();
			File images = new File(name + r.getString("imagesFolder"));
			File backgrounds = new File(name + r.getString("backgroundFolder"));
			File sounds = new File(name + r.getString("soundFolder"));
			File XML = new File(name + r.getString("XMLFolder"));
			images.mkdirs();
			sounds.mkdirs();
			XML.mkdirs();
			dataGame = new DataGame(name, name+"/");
			} catch(Exception e){
				showAndWait();
			}
			
		} else {
			myStage.close();
			Launcher main = new Launcher();
			main.start(new Stage());
		}
		
		return dataGame;
	}
}
