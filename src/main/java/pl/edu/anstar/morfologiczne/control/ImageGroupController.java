package pl.edu.anstar.morfologiczne.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ImageGroupController extends ChildController implements Initializable {
	
	@FXML
	Pane imagePane;
	@FXML
	ImageView imageView;
	@FXML
	Button internalButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void buttonOnClick() {
		internalButton.setVisible(false);
	}
	
}
