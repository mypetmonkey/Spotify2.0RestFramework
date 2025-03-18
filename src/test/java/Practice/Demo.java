package Practice;

import apiUtility.TokenManager;

public class Demo {
	
	public static void main(String[] args) {
		String token = TokenManager.getToken();
		System.out.println(token);
	}

}
