
package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import entity.Guide;
import entity.Person;
import entity.Student;

public class HibernateUtil {
	
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {        	
            // for Hibernate 4.3.x users
            // Create the SessionFactory from hibernate.cfg.xml 
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");  
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(Guide.class);
            configuration.addAnnotatedClass(Student.class);
            return configuration.buildSessionFactory( new StandardServiceRegistryBuilder().applySettings( configuration.getProperties() ).build() );

            // for Hibernate 5.x users
            // Create the SessionFactory from hibernate.cfg.xml
            /*
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
            */
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
	
}



