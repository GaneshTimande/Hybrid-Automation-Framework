
package com.finals.framework.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();
    static {
        try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is != null) {
                props.load(is);
            } else {
                System.err.println("config.properties not found in classpath"); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String get(String key) {
        return props.getProperty(key);
    }
}
