package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties prop;
	private final String propertyFilePath = "src/test/resources/TestData/PropertyFile.properties";

	public ConfigFileReader() throws IOException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propertyFilePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
	}

	public String getURL() {
		String url = prop.getProperty("URL");
		return url;
	}

	public String getEmailID() {
		String emailId = prop.getProperty("EMAIL");
		return emailId;
	}

	public String getPassword() {
		String password = prop.getProperty("PASSWORD");
		return password;
	}

	public String getBoardBaseURL() {
		String getBoardBaseURL = prop.getProperty("BOARD_BASE_URL");
		return getBoardBaseURL;
	}

	public String getCreateListURL() {
		String getCreateListURL = prop.getProperty("CREATE_LIST_URL");
		return getCreateListURL;
	}

	public String getCreateCardURL() {
		String getCreateCardURL = prop.getProperty("CREATE_CARD_URL");
		return getCreateCardURL;
	}

	public String getAPIKey() {
		String getAPIKey = prop.getProperty("API_KEY");
		return getAPIKey;
	}

	public String getToken() {
		String getToken = prop.getProperty("TOKEN");
		return getToken;
	}
	
	public String getBrowser() {
		String browser = prop.getProperty("BROWSER");
		return browser;
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = System.getProperty("user.dir")+prop.getProperty("EXTENT_CONFIG_PATH");
		System.out.println(reportConfigPath);
	    return reportConfigPath;
	}

}
