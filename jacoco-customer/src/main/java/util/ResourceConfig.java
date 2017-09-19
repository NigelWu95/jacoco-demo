package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResourceConfig extends BaseConfig {
	private static Properties systemProperties = new Properties();
	private static final Logger logger = Logger.getLogger(ResourceConfig.class.getName());

	public static void initialize() throws IOException {
		initialize("resource.properties", systemProperties);
	}

	public static Properties getSystemProperty() {
		return systemProperties;
	}

	public static String get(String key) {

		return systemProperties.getProperty(key);
	}

	public static List<String> getAsList(String key) {
		String config = ResourceConfig.get(key);
		String[] items = config.split("\\|\\|");

		List<String> result = new ArrayList<String>();

		if (config.length() == 0) {
			logger.log(Level.WARNING,"config is null!");
			return result;
		}

		for (String item : items) {
			if (item == null || item.length() == 0) {
				continue;
			}
			result.add(item.trim());
		}
		return result;
	}

	public static String get(String key, String defaultValue) {
		String s = get(key);
		String retValue = defaultValue;
		if (s != null && !(s.trim().isEmpty())) {
			retValue = s;
		}
		return retValue;
	}

	public static int getAsInt(String key) {
		return Integer.parseInt(get(key));
	}

	public static int getAsInt(String key, int defaultValue) {
		try {
			return getAsInt(key);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static long getAsLong(String key) {
		return Long.parseLong(get(key));
	}

	public static long getAsLong(String key, long defaultValue) {
		try {
			return getAsLong(key);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	public static boolean getAsBoolean(String key) {
		return Boolean.parseBoolean(get(key));
	}
}
