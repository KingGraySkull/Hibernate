package main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import config.Utils;
import entities.Customers;

public class App 
{
    public static void main( String[] args )
    {
    	Customers c = new Customers("Pawan","Bhatt",new Date());
    	
    	SessionFactory sf = Utils.getSessionFactory(); 
    	
    	Session session = sf.getCurrentSession();
    	
    	Transaction tx = session.beginTransaction();
    	session.save(c);
    	tx.commit();    	
    	session.close();   	
    	
    }
}
