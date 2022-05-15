package control;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

@SuppressWarnings("unused")
public class ControlPanel {
	// ----- OBJECTS
	// ----- JAVA
	// ----- FXML
	@FXML
	private ChoiceBox<String> operationList = new ChoiceBox<>();
	private final String[] types = { "Szkieletyzacja", "Obcinanie gałęzi", "Centroidy" };




	// ----- METHODS
	public ControlPanel() throws IOException {

	}

	public void buttonOption(){
		String typeChoose = operationList.getValue();
		typOption(typeChoose);
	}
	private void typOption(String typeChoose) {
		String chooseLabel = "Obecny Format: " + typeChoose;
		int op1 = updateOp(typeChoose);
		switch(typeChoose){
			case "Rzymski":
				/*date.setOperator(op1);
				dateLabel1.setText(chooseLabel);
				update();
				 */
			case "Krótki":
			/*	date.setOperator(op1);
				dateLabel1.setText(chooseLabel);
				update();

			 */
			case "Długi":
				/*date.setOperator(op1);
				dateLabel1.setText(chooseLabel);
				update();

				 */
			case "Alternatywny":
				/*date.setOperator(op1);
				dateLabel1.setText(chooseLabel);
				update();

				 */
			case "Domyślny":
				/*date.setOperator(op1);
				dateLabel1.setText(chooseLabel);
				update();

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
