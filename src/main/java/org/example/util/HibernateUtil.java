package org.example.util;

import java.util.Properties;

import org.example.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                // MssqlDB Config
//                Properties settings = new Properties();
//                settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                settings.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=forhibernatetest;encrypt=true;trustServerCertificate=true;");
//                settings.put(Environment.USER, "sa");
//                settings.put(Environment.PASS, "sa@Password");

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                // OracleDB Config
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "oracle.jdbc.OracleDriver");
                settings.put(Environment.URL, "jdbc:oracle:thin:@//localhost:1521/HOSSEINTESTDB");
                settings.put(Environment.USER, "HR");
                settings.put(Environment.PASS, "hr");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Person.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}


