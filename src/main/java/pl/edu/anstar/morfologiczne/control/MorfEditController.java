package pl.edu.anstar.morfologiczne.control;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import pl.edu.anstar.morfologiczne.Algorithm;

public class MorfEditController implements Initializable {
	// Children
	@FXML
	private ImageGroupController imageGroupController;
	
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
	
	// ----- METHODS
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageGroupController.parentController = this;
		radioGroupController.parentController = this;
	}
	
	private final String SELECT_IMAGE_PL = "Wybierz obraz";
	private final String SELECT_IMAGE_EN = "Select Image";
	
	@FXML
	private void imageSelect() {
		FileChooser fc = new FileChooser();
		if (radioGroupController.isEnglishSet()) {
			fc.setTitle(SELECT_IMAGE_EN);
		} else {
			fc.setTitle(SELECT_IMAGE_PL);
		}
		List<String> list = Arrays.asList(new String[] { "*.bmp", "*.png", "*.jpg" });
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.bmp *.png *.jpg", list));
		File selectedFile = fc.showOpenDialog(null);
		
		Mat src = Imgcodecs.imread(selectedFile.getAbsolutePath());
		imageGroupController.getSourceImageView().setImage(Algorithm.mat2Img(src));
		Mat tgt = Algorithm.skeletonization(src);
		imageGroupController.getTargetImageView().setImage(Algorithm.mat2Img(tgt));
		
		imageGroupController.algorithmStepSliderLabel.setVisible(true);
	}
	
	@FXML
	private void reset() {
		imageGroupController.getSourceImageView().setImage(null);
		imageGroupController.getTargetImageView().setImage(null);
		imageGroupController.algorithmStepSliderLabel.setVisible(false);
	}
	
}
