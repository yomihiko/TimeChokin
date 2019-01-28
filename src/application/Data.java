package application;

public class Data {
	protected static String filepath = "database/.database";
	public boolean stringLengteCheck(int minlength,int maxlength,String s) {
		if(s.length() > maxlength || s.length() < minlength) {
			return false;
		}
		return true;
	}
	public boolean betweenNum(int num,int min,int max) {
		if(num < min || num > max) {
			return false;
		}
		return true;
	}
}
