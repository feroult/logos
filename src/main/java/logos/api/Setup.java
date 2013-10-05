package logos.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Setup {

	public static final String CONSUMER_KEY = "logos.consumer.key";
	public static final String CONSUMER_SECRET = "logos.consumer.secret";
	public static final String TOKEN = "logos.token";
	public static final String TOKEN_SECRET = "logos.token.secret";
	
	private static final String SPREADSHEET_KEY = "logos.spreadsheet.key";

	private static Properties properties;

	public static String logosProperty(String key) {
		if(properties == null) {
			properties = loadProperties();
		}

		return properties.getProperty(key);
	}

	private static Properties loadProperties() {
		try {
			Properties properties = new Properties();

			InputStream in = Setup.class.getResourceAsStream("/logos.properties");
			properties.load(in);
			in.close();
			return properties;

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String spreadsheetKey() {
		return logosProperty(SPREADSHEET_KEY);
	}
}
