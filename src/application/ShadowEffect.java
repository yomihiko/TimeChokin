package application;

import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
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
	 * ボタンでマウスを離しているときのエフェクトを返す
	 * @return DropShadow
	 */
	public static DropShadow releaseBtnMouseEffect() {
		DropShadow ds = new DropShadow();
		ds.setColor(releaseMouseEffectColor);
		ds.setBlurType(BlurType.THREE_PASS_BOX);
		return ds;
	}
	/**
	 * ボタンでマウスを押しているときのエフェクトを返す
	 * @return InnerEffect
	 */
	public static InnerShadow pushBtnMouseEffect() {
		InnerShadow is = new InnerShadow();
		is.setColor(pushMouseEffectColor);
		is.setBlurType(BlurType.THREE_PASS_BOX);
		return is;
	}
}
