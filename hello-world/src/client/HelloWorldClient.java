package client;

import org.hibernate.Session;

import util.HibernateUtil;
import entity.Address;
import entity.Guide;
import entity.Message;
import entity.Person;
import entity.Student;


public class HelloWorldClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		session.beginTransaction();
                /*
        		Message message = new Message( "Hello World with Hibernate & JPA Annotations 2" );
        		*/
        		/*
        		Address address = new Address("DR. Erkin", "Istanbul", "34152");
        		Person person = new Person("emre", address);
        
        		session.save(person);
        		*/
        		
        		Guide guide = new Guide("2000MO10789", "Mike Lawson", 1000);
    			Student student = new Student("2014JT50123", "John Smith", guide);

    			//session.save(guide);
    			session.persist(student);
        
        		session.getTransaction().commit();
        		session.close();
	
	}
}

