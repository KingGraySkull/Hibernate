package config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class Utils
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
	
	public static void shutdown()
	{
		sf.close();
	}
}
