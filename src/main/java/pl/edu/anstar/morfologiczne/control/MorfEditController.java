package pl.edu.anstar.morfologiczne.control;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.FileChooser;
import pl.edu.anstar.morfologiczne.Algorithm;
import pl.edu.anstar.morfologiczne.MorfologiczneApplication;

public class MorfEditController implements Initializable {
	@FXML
	private ImageGroupController imageGroupController;
	
	@FXML
	private RadioGroupController radioGroupController;
	
	@FXML
	ChoiceBox<String> algorithmChoiceBox;
	
	@FXML
	Button selectImageButton;
	@FXML
	Button resetButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageGroupController.parentController = this;
		radioGroupController.imageGroupController = imageGroupController;
		radioGroupController.parentController = this;
		setUpChoiceBox();
		algorithmChoiceBox.setOnAction(action -> {
			reset();
		});
		
	}
	
	@FXML
	private void imageSelect() {
		FileChooser fc = new FileChooser();
		fc.setTitle(MorfologiczneApplication.getBundle().getString("key.selectImage"));
		List<String> list = Arrays.asList("*.bmp", "*.png", "*.jpg");
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.bmp *.png *.jpg", list));
		File selectedFile = fc.showOpenDialog(null);
		try {
			Mat src = Imgcodecs.imread(selectedFile.getAbsolutePath());
			imageGroupController.getSourceImageView().setImage(Algorithm.mat2Img(src));
			Mat tgt = Algorithm.skeletonization(src);
			imageGroupController.getTargetImageView().setImage(Algorithm.mat2Img(tgt));
			imageGroupController.algorithmStepSliderLabel.setVisible(true);
		} catch (NullPointerException e) {
			System.out.println("No file selected. Absolute path is null.");
		}
	}
	
	@FXML
	private void reset() {
		imageGroupController.getSourceImageView().setImage(null);
		imageGroupController.getTargetImageView().setImage(null);
		imageGroupController.algorithmStepSliderLabel.setVisible(false);
	}
	
	void setUpChoiceBox() {
		ResourceBundle bundle = MorfologiczneApplication.getBundle();
		final String skel = bundle.getString("key.skel");
		final String centroid = bundle.getString("key.centroid");
		final String branch = bundle.getString("key.branch");
		String[] tab = { skel, centroid, branch };
		ObservableList<String> choices = FXCollections.observableArrayList(tab);
		algorithmChoiceBox.setItems(choices);
		algorithmChoiceBox.setValue(choices.get(0));
	}
	
}
