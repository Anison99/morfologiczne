package pl.edu.anstar.morfologiczne.control;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class ImageGroupController extends ChildController implements Initializable {
	
	private final String SELECT_IMAGE_PL = "Wybierz obraz";
	private final String SELECT_IMAGE_EN = "Select Image";
	
	@FXML
	Button selectButton;
	
	@FXML
	private ImageView sourceImageView;
	@FXML
	private ImageView targetImageView;
	
	@FXML
	Label algorithmStepSliderLabel;
	@FXML
	Slider algorithmStepSlider;
	
	RadioGroupController radioGroup;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.radioGroup.setParentController(parentController);
		this.algorithmStepSliderLabel.setVisible(false);
	}
	
	public void uploadImage() {
		FileChooser fc = new FileChooser();
		
		if (radioGroup.isEnglishSet()) {
			fc.setTitle(SELECT_IMAGE_EN);
		} else {
			fc.setTitle(SELECT_IMAGE_PL);
		}
		
		List<String> list = Arrays.asList(new String[] { "*.bmp", "*.png", "*.jpg" });
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", list));
		File selectedFile = fc.showOpenDialog(null);
		Image image = new Image(selectedFile.getAbsolutePath());
		this.sourceImageView.setImage(image);
		
		this.algorithmStepSliderLabel.setVisible(true);
		
		this.selectButton.setText("Reset");
	}
	
	public void reset() {
		this.sourceImageView.setImage(null);
		this.targetImageView.setImage(null);
		this.algorithmStepSliderLabel.setVisible(false);
		
		this.selectButton.setText((this.radioGroup.isPolishSet()) ? SELECT_IMAGE_PL : SELECT_IMAGE_EN);
	}
	
	public ImageView getSourceImageView() {
		return sourceImageView;
	}
	
	public ImageView getTargetImageView() {
		return targetImageView;
	}
	
}
