package pl.edu.anstar.morfologiczne.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class RadioGroupController extends ChildController implements Initializable {
	
	@FXML
	RadioButton languagePLRadio;
	@FXML
	RadioButton languageENGRadio;
	@FXML
	private Label languageLabel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ToggleGroup languageRadioToggleGroup = new ToggleGroup();
		this.languagePLRadio.setToggleGroup(languageRadioToggleGroup);
		this.languageENGRadio.setToggleGroup(languageRadioToggleGroup);
		this.languagePLRadio.setSelected(true);
	}
	
	public boolean isEnglishSet() {
		return (languageENGRadio.isSelected() && !languagePLRadio.isSelected()) ? true : false;
	}
	
	public boolean isPolishSet() {
		return (languagePLRadio.isSelected() && !languageENGRadio.isSelected()) ? true : false;
	}
	
	@FXML
	private void setLanguageRadio(ActionEvent event) {
		if (languagePLRadio.isSelected()) {
			this.setLanguageToPolish();
			System.out.println("PL");
		}
		this.setLanguageToEnglish();
		System.out.println("ENG");
	}
	
	private void setLanguageToPolish() {
		// TODO translate all fields back to Polish
	}
	
	private void setLanguageToEnglish() {
		// TODO translate all fields to English
	}
	
}
