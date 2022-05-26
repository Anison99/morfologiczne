package pl.edu.anstar.morfologiczne.control;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
		this.bundle = resources;
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
	
	// public boolean isEnglishSet() {
	// return (languageENGRadio.isSelected() && !languagePLRadio.isSelected()) ?
	// true : false;
	// }
	//
	// public boolean isPolishSet() {
	// return (languagePLRadio.isSelected() && !languageENGRadio.isSelected()) ?
	// true : false;
	// }
	
	private ResourceBundle bundle;
	
	public ResourceBundle getBundle() {
		return this.bundle;
	}
	
	private void setLanguage(String langCode, String countryCode) {
		Locale locale = new Locale(langCode, countryCode);
		bundle = ResourceBundle.getBundle("pl.edu.anstar.morfologiczne.internationalization.lang",
				locale);
		final String selectImage = bundle.getString("key.selectImage");
		final String reset = bundle.getString("key.reset");
		final String skel = bundle.getString("key.skel");
		final String centroid = bundle.getString("key.centroid");
		final String branch = bundle.getString("key.branch");
		parentController.selectImageButton.setText(selectImage);
		parentController.resetButton.setText(reset);
		
		ObservableList<String> choices = FXCollections.observableArrayList(skel, centroid, branch);
		parentController.algorithmChoiceBox.setItems(choices);
		parentController.algorithmChoiceBox.setValue(skel);
		MorfologiczneApplication.updateStageTitle(bundle);
	}
}
