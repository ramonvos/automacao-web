package constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import utilities.ProjectHelpers;

public class LoadConfigurations {

	public static Properties getProperties() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

        	input = new FileInputStream(ProjectHelpers.getProjectPath()+"\\configuration.properties");
            // load a properties file
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;

    }
}
