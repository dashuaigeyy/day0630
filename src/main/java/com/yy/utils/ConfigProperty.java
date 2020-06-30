package com.yy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * 这个类是单例设计模式：项目中至始至终只有一个实例
 * 1、构造器私有，不能new对象了，
 * 2、提供一个共有的静态的，返回值是类的本身的方法
 *
 * 单例分类：
 * 	懒汉式：用的时候，在new对象，但是容易多线程并打，
 * 	需要加锁，在方法上直接加锁，或导致运行效率低，建议二次判断，在方法里面加锁
 * 	饿汉式：已近类里面，就new对象，因为是静态所以只new一次
 */
public class ConfigProperty {

	private static ConfigProperty configProperty;
	private static Properties properties;
	
	private ConfigProperty() {
		String configFile="user.properties";
	    properties=new Properties();
		InputStream in=ConfigProperty.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 锁住了，一个一个运行，多个线程调用这个方法，必须一个运行完了，在一个运行
	 *
	 * @return
	 */

	public static  ConfigProperty getInstance(){
		if(configProperty==null){
			configProperty=new ConfigProperty();
		}
		return configProperty;
	}
	
	public String getString(String key){
		return properties.getProperty(key);
	}
}
