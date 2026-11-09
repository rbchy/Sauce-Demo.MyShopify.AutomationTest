package utils;

import java.io.InputStream;
import java.util.Properties;

/** Reads src/test/resources/config.properties; a -Dkey=value system property overrides the file. */
public final class ConfigReader {

    private static final Properties PROPS = new Properties();

    static {
        try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) {
                throw new IllegalStateException("config.properties not found in src/test/resources");
            }
            PROPS.load(in);
        } catch (Exception e) {
            throw new IllegalStateException("Could not load config.properties", e);
        }
    }

    private ConfigReader() {
    }

    public static String get(String key) {
        String value = System.getProperty(key, PROPS.getProperty(key));
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Missing config value: " + key);
        }
        return value.trim();
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(System.getProperty(key, PROPS.getProperty(key, "false")).trim());
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}
