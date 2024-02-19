package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.BatchEntity;
import entity.LaptopEntity;
import entity.StudentEntity;
import entity.SubjctEntity;

public class SessionFactoryConfiguration {
    private static SessionFactoryConfiguration sessionFactoryConfiguration;

    private SessionFactory sessionFactory;

    private SessionFactoryConfiguration() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(StudentEntity.class)
                .addAnnotatedClass(LaptopEntity.class).addAnnotatedClass(BatchEntity.class)
                .addAnnotatedClass(SubjctEntity.class);
        sessionFactory = configuration.buildSessionFactory();

    }

    public static SessionFactoryConfiguration getInstance() {
        if (sessionFactoryConfiguration == null) {
            sessionFactoryConfiguration = new SessionFactoryConfiguration();
        }
        return sessionFactoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
