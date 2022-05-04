package control;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

public class ControlPanel {
    // ----- OBJECTS
    // ----- JAVA
    // ----- FXML
    @FXML
    private ChoiceBox<String> operationList = new ChoiceBox<>();
    private final String[] types = {"Szkieletyzacja", "Obcinanie gałęzi", "Centroidy"};

    // ----- METHODS
    public ControlPanel() throws IOException{

    }

    public void buttonOption(){
        String typeChoose = operationList.getValue();
        typOption(typeChoose);
    }

    private void typOption(String typeChoose) {
        String chooseLabel = "Obecny Format: " + typeChoose;
        int op1 = updateOp(typeChoose);
        switch(typeChoose){
            case "Szkieletyzacja":
               /* date.setOperator(op1);
                dateLabel1.setText(chooseLabel);
                update();
                */
            case "Obcinanie gałęzi":
               /* date.setOperator(op1);
                dateLabel1.setText(chooseLabel);
                update();
                */
            case "Centroidy":
                /*
                date.setOperator(op1);
                dateLabel1.setText(chooseLabel);
                update();
                 */
        }
    }

    private int updateOp(String string) {
        switch (string){
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
