package control;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MorfEdit extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(MorfEdit.class.getResource("MorfEdit.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 600, 400);
		stage.setResizable(false);
		stage.setTitle("Iteracyjne Operacje Morfologiczne");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
