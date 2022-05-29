package pl.edu.anstar.morfologiczne.control;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.edu.anstar.morfologiczne.algorithm.MorphologicalOperation.MorphologicalAlgorithmChoice;;

public class ImageGroupController implements Initializable {
	
	protected MorfEditController parentController;
	
	@FXML
	Label algorithmStepSliderLabel;
	@FXML
	Slider algorithmStepSlider;
	
	@FXML
	Button replaceButton;
	
	@FXML
	private ImageView sourceImageView;
	private Mat sourceMat;
	@FXML
	private ImageView targetImageView;
	private Mat targetMat;
	
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
	
	@FXML
	private void fireReplaceButton(ActionEvent event) {
		this.sourceImageView.setImage(targetImageView.getImage());
	}
	
	public void setUpSlider() {
		this.algorithmStepSliderLabel.setVisible(true);
		this.algorithmStepSlider.setValue(1);
	}
	
	public void calculateTarget(MorphologicalAlgorithmChoice selectedAlgorithm) {
		targetMat = switch (selectedAlgorithm) {
		case BRANCH -> cutBranches(sourceMat);
		case CENTROID -> centroids(sourceMat);
		case SKEL -> skeletonization(sourceMat);
		};
		targetImageView.setImage(mat2Img(targetMat));
	}
	
	public void setUpImages(Mat uploadedImage) {
		this.sourceMat = uploadedImage;
		this.sourceImageView.setImage(mat2Img(uploadedImage));
		calculateTarget(parentController.getSelectedAlgorithm());
		setUpSlider();
		calculateTarget(parentController.getSelectedAlgorithm());
		
	}
	
	public static Mat loadImage(String imagePath) {
		return Imgcodecs.imread(imagePath);
	}
	
	public static Image mat2Img(Mat mat) {
		MatOfByte bytes = new MatOfByte();
		Imgcodecs.imencode("img.bmp", mat, bytes);
		InputStream inputStream = new ByteArrayInputStream(bytes.toArray());
		return new Image(inputStream);
	}
	
	public static Mat skeletonization(Mat sourceImg) {
		// TODO
		return null;
	}
	
	public static Mat centroids(Mat sourceImg) {
		// TODO
		return null;
	}
	
	public static Mat cutBranches(Mat sourceImg) {
		// TODO
		return null;
	}
	
}
