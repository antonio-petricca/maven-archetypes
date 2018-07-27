package com.ap.archetypes.jboss_web_api.ejb.session;

import com.ap.archetypes.jboss_web_api.common.configuration.AppConfiguration;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateless
@LocalBean
public class SessionBean implements SessionBeanLocal {
    
    @PersistenceContext(unitName = "mainPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public String sayHello() {
        return AppConfiguration.getInstance().HELLO_MESSAGE;
    }
}
