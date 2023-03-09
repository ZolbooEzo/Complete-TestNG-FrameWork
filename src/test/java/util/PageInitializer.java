package util;

import pageObjects.HomePage;

public class PageInitializer extends BaseClass{

	public static HomePage hp;
	
	public static void initializer() {
		hp = new HomePage();
	}
	
}
