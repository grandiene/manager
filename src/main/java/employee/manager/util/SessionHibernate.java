package employee.manager.util;

import org.hibernate.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class SessionHibernate {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public Session getSession() {
        Session sessionHibernate = entityManager.unwrap(Session.class);
        return sessionHibernate;
    }
}
