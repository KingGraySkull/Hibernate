package config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utils
{
	private static SessionFactory sf = null;
	
	static 
	{
		Configuration cfg = new Configuration();		
		cfg.configure("hibernate.cfg.xml");
		System.out.println("Hibernate Configuration File Loaded");
		sf = cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sf;
	}
	
}
