package application;

public class Check {
	public static boolean stringLengteCheck(int minlength,int maxlength,String s) {
		if(s.length() > maxlength || s.length() < minlength) {
			return false;
		}
		return true;
	}
}
