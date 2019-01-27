package dialogs;

import java.util.Optional;

import javafx.scene.control.ButtonType;

public class InfoDialog {
	/**
	 * 更新完了ダイアログ
	 * @param name 何を
	 */
	public static void changeDoneDialog(String name) {
		Dialog.infoDialog("更新完了", name + "を更新しました。");
	}
	public static Optional<ButtonType> deleteCheckDialog(String name) {
		return Dialog.warningDialog("確認", name + " を削除しますか？");
	}
	public static void coinAddDoneDialog(String name) {
		Dialog.infoDialog("追加完了", name + "を追加しました。");
	}
	public static void goalAddDoneDialog() {
		Dialog.infoDialog("追加完了","目標を追加しました。");
	}

}
