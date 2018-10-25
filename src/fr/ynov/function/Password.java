package fr.ynov.function;

public class Password {
	public static boolean verifyPassword(String password){
			String regex = "^(?=.+[a-z])(?=.+[A-Z])(?=.+\\d)(?=.+[#$^+=!*()@%&])().{8,}$";
		return password.matches(regex);
	}
}
