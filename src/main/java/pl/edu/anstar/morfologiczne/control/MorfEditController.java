package pl.edu.anstar.morfologiczne.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

@SuppressWarnings("unused")
public class MorfEditController implements Initializable {
	
	// Children
	@FXML
	private RadioGroupController radioGroupController;
	
	@FXML
	ChoiceBox<?> choiceFcnList;
	@FXML
	ChoiceBox<String> operationList;
	@FXML
	Label iterLabel;
	
	// Image handling
	@FXML
	Button selectImageButton;
	@FXML
	ImageView sourceImage;
	@FXML
	ImageView resultImage;
	
	private void imageSelect() {
		
	}
	
	// ----- METHODS
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		radioGroupController.setParentController(this);
		
	}
	
}
