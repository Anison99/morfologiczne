package pl.edu.anstar.morfologiczne.control;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import pl.edu.anstar.morfologiczne.MorfologiczneApplication;

public class RadioGroupController implements Initializable {
	
	protected MorfEditController parentController;
	
	protected ImageGroupController imageGroupController;
	
	@FXML
	private RadioButton languagePLRadio;
	@FXML
	private RadioButton languageENGRadio;
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
		RadioButton source = (RadioButton) event.getSource();
		if (source.equals(languagePLRadio)) {
			this.setLanguage("pl", "PL");
		} else if (source.equals(languageENGRadio)) {
			this.setLanguage("en", "UK");
		}
	}
	
	public void setLanguage(String langCode, String countryCode) {
		Locale locale = new Locale(langCode, countryCode);
		ResourceBundle bundle = MorfologiczneApplication.setBundle(locale);
		final String selectImage = bundle.getString("key.selectImage");
		final String reset = bundle.getString("key.reset");
		parentController.selectImageButton.setText(selectImage);
		parentController.resetButton.setText(reset);
		parentController.setUpChoiceBox();
		MorfologiczneApplication.updateStageTitle(bundle);
	}
	
}