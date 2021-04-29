package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.yaml.snakeyaml.introspector.Property;

public class PropertyFileReader {
	
	public Properties getProperty()throws IOException{
		
	FileInputStream inputstream=null;
	Properties properties= new Properties();
	try {
		properties.load(new FileInputStream("resourses/browser-config.properties"));
	}catch(Exception e){
		System.out.println("Exception" + e);
		
	}
	return properties;
		
	}

}
