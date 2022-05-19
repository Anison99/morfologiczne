package pl.edu.anstar.morfologiczne.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class RadioGroupController implements Initializable {
	
	protected MorfEditController parentController;
	
	protected ImageGroupController imageGroupController;
	
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
	
	@FXML
	private void setLanguageRadio(ActionEvent event) {
		if (isPolishSet()) {
			this.setLanguageToPolish();
			System.out.println("PL");
		} else if (isEnglishSet()) {
			this.setLanguageToEnglish();
			System.out.println("ENG");
		}
	}
	
	public boolean isEnglishSet() {
		return (languageENGRadio.isSelected() && !languagePLRadio.isSelected()) ? true : false;
	}
	
	public boolean isPolishSet() {
		return (languagePLRadio.isSelected() && !languageENGRadio.isSelected()) ? true : false;
	}
	
	private void setLanguageToPolish() {
		parentController.selectImageButton.setText("WYBIERZ OBRAZ");
		parentController.resetButton.setText("WYCZYŚĆ");
		parentController.iterLabel.setText("Liczba iteracji:");
		imageGroupController.algorithmStepSliderLabel.setText("Krok Algorytmu");
	}
	
	private void setLanguageToEnglish() {
		parentController.selectImageButton.setText("SELECT IMAGE");
		parentController.resetButton.setText("CLEAR IMAGE");
		parentController.iterLabel.setText("Number of iterations:");
		imageGroupController.algorithmStepSliderLabel.setText("Algorithm step");
	}
	
}
