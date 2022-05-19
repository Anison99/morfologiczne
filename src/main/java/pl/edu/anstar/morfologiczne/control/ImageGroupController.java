package pl.edu.anstar.morfologiczne.control;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class ImageGroupController implements Initializable {
	
	protected MorfEditController parentController;
	
	@FXML
	private RadioGroupController radioGroupController;
	
	@FXML
	private ImageView sourceImageView;
	@FXML
	private ImageView targetImageView;
	
	@FXML
	Label algorithmStepSliderLabel;
	@FXML
	Slider algorithmStepSlider;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.algorithmStepSliderLabel.setVisible(false);
	}
	
	private final String SELECT_IMAGE_PL = "Wybierz obraz";
	private final String SELECT_IMAGE_EN = "Select Image";
	
	public void uploadImage() {
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
		this.sourceImageView.setImage(image);
		
		this.algorithmStepSliderLabel.setVisible(true);
		
	}
	
	public void reset() {
		this.sourceImageView.setImage(null);
		this.targetImageView.setImage(null);
		this.algorithmStepSliderLabel.setVisible(false);
	}
	
	public ImageView getSourceImageView() {
		return sourceImageView;
	}
	
	public ImageView getTargetImageView() {
		return targetImageView;
	}
	
}
