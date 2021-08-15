package com.mikhail.andersentrainee;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private final static Properties INSTANCE = new Properties();

    static {
        loadProperties();
    }



    public static String getProperty(String key) {
        return INSTANCE.getProperty(key);
    }

    public static void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("dbProperties.properties")){

            INSTANCE.load(inputStream);
            System.out.println();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadProperties(String resourceFileName) {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(resourceFileName)){

            INSTANCE.load(inputStream);
            System.out.println();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
