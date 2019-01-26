package application;

import java.io.IOException;

import dialogs.ErrDialog;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Master extends Application {
	private static Stage masterStage;
	private static Stage subStage;
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
			ErrDialog.fxmlfileErr();
			masterStage.close();
		}
	}
	/**
	 * サブステージを作成
	 * @param width 幅
	 * @param height 高さ
	 * @param title サブステージのタイトル
	 * @param fxmlPath 読み込むfxmlファイル
	 */
	public static void newStage(int width,int height,String title,String fxmlPath) {
		subStage = new Stage();
		AnchorPane root;
		try {
			root = (AnchorPane)FXMLLoader.load(instanse.getClass().getResource(fxmlPath));
			Scene scene = new Scene(root,width,height);
			scene.getStylesheets().add(instanse.getClass().getResource("application.css").toExternalForm());
			subStage.setScene(scene);
			subStage.initModality(Modality.APPLICATION_MODAL);
			subStage.setTitle(title);
			subStage.resizableProperty().setValue(false);
			subStage.showAndWait();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
	/**
	 * サブステージを閉じる
	 */
	public static void closeSubStage() {
		subStage.close();
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
			ErrDialog.fxmlfileErr();
			masterStage.close();

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
