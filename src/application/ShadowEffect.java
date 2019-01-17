package application;

import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class ShadowEffect{
	/**
	 * マウスを離しているときの影の色
	 */
	private static  Color releaseMouseEffectColor = Color.web("903700");
	/**
	 * マウスを押しているときの影の色
	 */
	private static  Color pushMouseEffectColor = Color.web("5b2100");
	/**
	 * 影の色
	 */
	private static Color shadowColor = Color.web("000000");
	/**
	 * 影エフェクトの色を設定する
	 * @param colorCode 色のカラーコード
	 */
	public static void setColor(String colorCode) {
		shadowColor = Color.web(colorCode);
	}
	/**
	 * 対象にDropShadowを適用 ボタン用
	 * @param target 対象のfxid
	 */
	public static void setDropShadow(Button target) {
		target.setEffect(newDropShadow());
	}
	/**
	 * 対象にDropShadowを適用 AnchorPane用
	 * @param target 対象のfxid
	 */
	public static void setDropShadow(AnchorPane target) {
		target.setEffect(newDropShadow());
	}
	/**
	 * 対象にInnerShadowを適用 ボタン用
	 * @param target 対象のfxid
	 */
	public static void setInnerShadow(Button target) {
		target.setEffect(newInnerShadow());
	}
	/**
	 * 対象にInnerShadowを適用 AnchorPane用
	 * @param target 対象のfxid
	 */
	public static void setInnerShadow(AnchorPane target) {
		target.setEffect(newInnerShadow());
	}

	/**
	 * DropShadowインスタンス生成
	 * @return インスタンス
	 */
	private static DropShadow newDropShadow() {
		DropShadow ds = new DropShadow();
		ds.setColor(shadowColor);
		ds.setBlurType(BlurType.THREE_PASS_BOX);
		return ds;
	}
	/**
	 * InnerShadowインスタンス生成
	 * @return インスタンス
	 */
	private static InnerShadow newInnerShadow() {
		InnerShadow is = new InnerShadow();
		is.setColor(shadowColor);
		is.setBlurType(BlurType.THREE_PASS_BOX);
		return is;
	}
}
