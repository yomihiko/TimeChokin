package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Master.fxml"));
			Scene scene = new Scene(root,410,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("時間貯金箱(仮)");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void switching() {
		AnchorPane root;
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("Master.fxml"));
			Scene scene = new Scene(root,410,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
