package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Master extends Application {
	private static Stage masterStage;
	private static Master instanse;
	@Override
	public void start(Stage primaryStage) {
		try {
			masterStage = primaryStage;
			instanse = this;
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("FXML/Home.fxml"));
			Scene scene = new Scene(root,410,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			masterStage.setScene(scene);
			masterStage.setTitle("時間貯金箱(仮)");
			masterStage.show();
		} catch(Exception e) {
			ErrDialog("ファイル読み込みエラー", "FXMLファイルの読み込みに失敗しました。");
		}
	}
	/**
	 * 画面遷移
	 * @param fxmlFilePath 読み込むFXMLファイルのパス
	 * @param width 画面の横サイズ
	 * @param height 画面の縦サイズ
	 */
	public static void switching(String fxmlFilePath,double width,double height) {
		AnchorPane root;
		try {
			root = (AnchorPane)FXMLLoader.load(instanse.getClass().getResource(fxmlFilePath));
			Scene scene = new Scene(root,width,height);
			scene.getStylesheets().add(instanse.getClass().getResource("application.css").toExternalForm());

			masterStage.setScene(scene);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			ErrDialog("ファイル読み込みエラー", "FXMLファイルの読み込みに失敗しました。");

		}
	}
	private static void ErrDialog(String title,String messeage) {
		Alert alt = new Alert(AlertType.ERROR);
		alt.setTitle(title);
		alt.setContentText(messeage);
		alt.showAndWait();
		masterStage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
