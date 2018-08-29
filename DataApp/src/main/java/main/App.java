package main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import config.Utils;
import entities.Author;
import entities.Book;
import entities.Card;
import entities.Customers;
import entities.Vehicle;

public class App 
{
    public static void main( String[] args )
    {
    	Book b1 = new Book("Java Complete Reference","Technology","1110-9090-899");
    	Book b2 = new Book("The Java Language Specification","Technology","1000-9090-899");
    	Book b3 = new Book("C++ The complete reference","Technology","1110-9990-899");
    	Book b4 = new Book("Head First C","Technology","6666-9990-899");
    	
    	Author a1 = new Author("Herbert","Schildt");
    	Author a2 = new Author("James","Gosling");
    	Author a3 = new Author("Sandra","Bullock");
    	
    	b1.getAuthors().add(a1);
    	b2.getAuthors().add(a1);
    	b2.getAuthors().add(a2);
    	b3.getAuthors().add(a1);
    	b4.getAuthors().add(a3);
    	
    	SessionFactory sf = Utils.getSessionFactory(); 
    	
    	Session session = sf.getCurrentSession();
    	
    	Transaction tx = session.beginTransaction();
    	session.persist(b1);
    	session.persist(b2);
    	session.persist(b3);
    	session.persist(b4);
    	tx.commit();    	
    	session.close();   
    	
    }
}
