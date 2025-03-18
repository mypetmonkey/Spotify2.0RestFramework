package apiUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FiileUtility {
	
	public String getPropertyData(String key) throws IOException {
		FileInputStream fis=new FileInputStream("");
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data;
				
	}

}
