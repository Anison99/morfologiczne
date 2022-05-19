package pl.edu.anstar.morfologiczne.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

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
	
	public ImageView getSourceImageView() {
		return sourceImageView;
	}
	
	public ImageView getTargetImageView() {
		return targetImageView;
	}
	
}
