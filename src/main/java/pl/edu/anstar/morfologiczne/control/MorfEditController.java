package pl.edu.anstar.morfologiczne.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

@SuppressWarnings("unused")
public class MorfEditController implements Initializable {
	
	@FXML
	private ChoiceBox<?> choiceFcnList;
	@FXML
	private ChoiceBox<String> operationList;
	@FXML
	private Label iterLabel;
	
	private final String[] types = { "Szkieletyzacja", "Obcinanie gałęzi", "Centroidy" };
	
	// Image handling
	@FXML
	private Button selectImageButton;
	@FXML
	private ImageView sourceImage;
	@FXML
	private ImageView resultImage;
	
	private void imageSelect() {
		
	}
	
	// Radio buttons handling
	@FXML
	private RadioButton languagePLRadio;
	@FXML
	private RadioButton languageENGRadio;
	
	@FXML
	private void setLanguageRadio(ActionEvent event) {
		if (languagePLRadio.isSelected()) {
			languageENGRadio.setSelected(false);
			this.setLanguageToPolish();
			System.out.println("PL");
		} else if (languageENGRadio.isSelected()) {
			languagePLRadio.setSelected(false);
			this.setLanguageToEnglish();
			System.out.println("ENG");
		}
	}
	
	private void setLanguageToEnglish() {
		// TODO translate and set all buttons text
	}
	
	private void setLanguageToPolish() {
		// TODO set all buttons text back to Polish
	}
	
	// ----- METHODS
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ToggleGroup languageRadioToggleGroup = new ToggleGroup();
		this.languagePLRadio.setSelected(true);
		this.languagePLRadio.setToggleGroup(languageRadioToggleGroup);
		this.languageENGRadio.setToggleGroup(languageRadioToggleGroup);
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
