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
	/**
	 * 範囲エラー
	 * @param name 項目名
	 * @param min 最小値
	 * @param max 最大値
	 */
	public static void internalErr(String name,int min,int max) {
		Dialog.errDialog("エラー", name + "は" + min + "～" + max + "分以内です。");
	}
	public static void noSelectedErr() {
		Dialog.errDialog("エラー","項目を選択してください。");
	}
	public static void noCoinSelectedErr() {
		Dialog.errDialog("エラー","コインを選択してください。");
	}
	public static void noNumberErr() {
		Dialog.errDialog("エラー","数値を入力してください。");
	}
}
