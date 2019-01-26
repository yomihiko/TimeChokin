package dialogs;

public class ErrDialog {
	/**
	 * FXML読み込み失敗エラー
	 */
	public static void fxmlfileErr() {
		Dialog.errDialog("ファイル読み込みエラー", "FXMLファイルの読み込みに失敗しました。");
	}
	/**
	 * データベース接続エラー
	 */
	public static void databaseErr() {
		Dialog.errDialog("データベース接続エラー", "データベースの接続に失敗しました。");
	}
	/**
	 * 文字数オーバーエラー
	 * @param name 項目名
	 * @param length 長さの上限
	 */
	public static void lengthOverErr(String name,int minlength,int maxlength) {
		Dialog.errDialog("エラー", name + "は" + minlength + "～"+maxlength + "文字以内です。");
	}
}
