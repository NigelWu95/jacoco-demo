package util;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseConfig {
	private static final Logger logger = Logger.getLogger(BaseConfig.class.getName());

	BaseConfig(){

	}

	public static void initialize(String resource, Properties properties) throws IOException {
			InputStream stream = BaseConfig.class.getResourceAsStream("/"+resource);
			logger.log(Level.INFO, "The resource file is %s", resource);
			BufferedReader br = new BufferedReader(new InputStreamReader(stream, "utf-8"));
				properties.load(br);
				stream.close();
	}
}
