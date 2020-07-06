package constants;

import utilities.ProjectHelpers;

public class Constants {

	public  static final int defaultTimeout = 30;
	
	public  static final String pathToChromedriver = ProjectHelpers.getProjectPath()+"\\src\\main\\java\\drivers\\Chrome\\Versions\\";
	public  static final String pathToFirefoxdriver = ProjectHelpers.getProjectPath()+"\\src\\main\\java\\drivers\\Firefox\\Versions\\26\\";
	public  static final String pathToIEdriver = ProjectHelpers.getProjectPath()+"\\src\\main\\java\\drivers\\IE\\Versions\\3.9\\";
}
