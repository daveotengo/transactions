package com.imto.transfer.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;

public class PropsCache {
	private final Properties prop = new Properties();
	public static final boolean IS_DEBUG_MODE = false;
	
	public static final String LOG4J_DEBUG = "cfg/log4j.properties";
	public static final String PROPS_DEBUG = "cfg/config.properties";
	
	public static final String LOG4J_PROD = "cfg/log4j.properties";
	public static final String PROPS_PROD = "cfg/config.properties";
	
	String log4jPath = IS_DEBUG_MODE ? LOG4J_DEBUG : LOG4J_PROD;
	String configPath = IS_DEBUG_MODE ? PROPS_DEBUG : PROPS_PROD;

	private PropsCache() {
		PropertyConfigurator.configure(log4jPath);
		
		try {
			prop.load(new FileInputStream(new File(configPath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class LazyHolder {
		private static final PropsCache INSTANCE = new PropsCache();
	}

	public static PropsCache getInstance() {
		return LazyHolder.INSTANCE;
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	public Set<String> getAllPropertyNames() {
		return prop.stringPropertyNames();
	}

	public boolean containsKey(String key) {
		return prop.containsKey(key);
	}
}
