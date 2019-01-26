package dialogs;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Dialog {
	public static void errDialog(String title,String messeage) {
		Alert alt = new Alert(AlertType.ERROR);
		alt.setTitle(title);
		alt.setContentText(messeage);
		alt.showAndWait();
	}
	public static void infoDialog(String title,String messeage) {
		Alert alt = new Alert(AlertType.INFORMATION);
		alt.setTitle(title);
		alt.setContentText(messeage);
		alt.showAndWait();
	}
	public static Optional<ButtonType> warningDialog(String title,String messeage) {
		Alert alt = new Alert(AlertType.WARNING,"",ButtonType.YES,ButtonType.CANCEL);
		alt.setTitle(title);
		alt.setContentText(messeage);
		return alt.showAndWait();
	}
}
