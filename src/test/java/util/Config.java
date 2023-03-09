package util;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	
	private static Properties userData;
	private static Properties requiredData;
	
	
	static {
		
		try {
			
			FileInputStream userDataFIS = new FileInputStream(Constants.userDataPath);
			FileInputStream requiredDataFIS = new FileInputStream(Constants.requiredDataPath);
			
			userData = new Properties();
			requiredData = new Properties();
			
			userData.load(userDataFIS);
			requiredData.load(requiredDataFIS);
			
			userDataFIS.close();
			requiredDataFIS.close();
					
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getUserData(String keyName) {
		return userData.getProperty(keyName);
	}
	
	public static String getRequiredData(String keyName) {
		return requiredData.getProperty(keyName);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
