package pl.edu.anstar.morfologiczne.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;

@SuppressWarnings("unused")
public class MorfEditController implements Initializable {
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		languagePLRadio.setSelected(true);
	}
	
	@FXML
	private ChoiceBox<?> choiceFcnList;
	@FXML
	private ChoiceBox<String> operationList;
	
	// Image handling
	@FXML
	private Button imageChoiceButton;
	@FXML
	private ImageView loadedImage;
	@FXML
	private ImageView editImage;
	
	private void imageSelect() {
		
	}
	
	@FXML
	private RadioButton languagePLRadio;
	@FXML
	private RadioButton languageENGRadio;
	
	private void setLanguageRadio(ActionEvent event) {
		if (languagePLRadio.isSelected()) {
			System.out.println("PL");
			// TODO set all buttons text
		} else if (languageENGRadio.isSelected()) {
			System.out.println("ENG");
			// TODO translate and set all buttons text
		}
	}
	
	@FXML
	private Label iterLabel;
	
	private final String[] types = { "Szkieletyzacja", "Obcinanie gałęzi", "Centroidy" };
	
	// ----- METHODS
	public MorfEditController() throws IOException {
		
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
