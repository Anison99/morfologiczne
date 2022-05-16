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
	
	@FXML
	ChoiceBox<?> choiceFcnList;
	@FXML
	ChoiceBox<String> operationList;
	@FXML
	Label iterLabel;
	
	final String[] types = { "Szkieletyzacja", "Obcinanie gałęzi", "Centroidy" };
	
	// Image handling
	@FXML
	Button selectImageButton;
	@FXML
	ImageView sourceImage;
	@FXML
	ImageView resultImage;
	
	private void imageSelect() {
		
	}
	
	@FXML
	private RadioGroupController radioGroupController;
	// ----- METHODS
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		radioGroupController.setParentController(this);
		
//		ToggleGroup languageRadioToggleGroup = new ToggleGroup();
//		this.languagePLRadio.setSelected(true);
//		this.languagePLRadio.setToggleGroup(languageRadioToggleGroup);
//		this.languageENGRadio.setToggleGroup(languageRadioToggleGroup);
	}
	
	public void buttonOption() {
		String typeChoose = operationList.getValue();
		typOption(typeChoose);
	}
	
	private void typOption(String typeChoose) {
		String chooseLabel = "Obecny Format: " + typeChoose;
		int op1 = updateOp(typeChoose);
		switch (typeChoose) {
		case "Rzymski":
			/*
			 * date.setOperator(op1); dateLabel1.setText(chooseLabel); update();
			 */
			
		case "Krótki":
			/*
			 * date.setOperator(op1); dateLabel1.setText(chooseLabel); update();
			 * 
			 */
		case "Długi":
			/*
			 * date.setOperator(op1); dateLabel1.setText(chooseLabel); update();
			 * 
			 */
		case "Alternatywny":
			/*
			 * date.setOperator(op1); dateLabel1.setText(chooseLabel); update();
			 * 
			 */
		case "Domyślny":
			/*
			 * date.setOperator(op1); dateLabel1.setText(chooseLabel); update();
			 * 
			 */
		}
	}
	
	private int updateOp(String string) {
		switch (string) {
		case "Szkieletyzacja":
			return 3;
		case "Obcinanie gałęzi":
			return 2;
		case "Centroidy":
			return 1;
		}
		return 4;
	}
}
