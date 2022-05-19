package pl.edu.anstar.morfologiczne;

import java.io.IOException;

import org.opencv.core.Core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MorfologiczneApplication extends Application {
	
	private static Scene currentScene;
	
	@Override
	public void start(Stage stage) throws IOException {
		currentScene = FXMLLoader.load(getClass().getResource("control/MorfEdit.fxml"));
//		stage.setWidth(1920);
//		stage.setHeight(1080);
//		stage.setMaximized(true);
		stage.setScene(currentScene);
		stage.setTitle("Iteracyjne Operacje Morfologiczne");
		stage.show();
		letterbox(currentScene, (Pane) currentScene.getRoot());
		
	}
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		launch();
	}
	
	private void letterbox(final Scene scene, final Pane contentPane) {
		final double initWidth = scene.getWidth();
		final double initHeight = scene.getHeight();
		final double ratio = initWidth / initHeight;
		SceneSizeChangeListener sizeListener = new SceneSizeChangeListener(scene, ratio, initHeight, initWidth,
				contentPane);
		scene.widthProperty().addListener(sizeListener);
		scene.heightProperty().addListener(sizeListener);
	}
	
}
