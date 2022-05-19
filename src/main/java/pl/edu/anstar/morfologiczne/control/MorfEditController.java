package pl.edu.anstar.morfologiczne.control;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class MorfEditController implements Initializable {
	
	private final String SELECT_IMAGE_PL = "Wybierz obraz";
	private final String SELECT_IMAGE_EN = "Select Image";
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		radioGroupController.setParentController(this);
	}
	
	@FXML
	private void imageSelect() {
		FileChooser fc = new FileChooser();
		
		if (radioGroupController.isEnglishSet()) {
			fc.setTitle(SELECT_IMAGE_EN);
		} else {
			fc.setTitle(SELECT_IMAGE_PL);
		}
		
		List<String> list = Arrays.asList(new String[] { "*.bmp", "*.png", "*.jpg" });
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", list));
		File selectedFile = fc.showOpenDialog(null);
		Image image = new Image(selectedFile.getAbsolutePath());
		
		this.sourceImage.setImage(image);
	}
	
}
