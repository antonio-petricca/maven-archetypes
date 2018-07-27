package com.ap.archetypes.jboss_web_api.ejb.session;

import com.ap.archetypes.jboss_web_api.common.configuration.AppConfiguration;
import com.ap.archetypes.jboss_web_api.common.logging.LoggerHelper;
import com.ap.archetypes.jboss_web_api.ejb.jpa.TablesEntity;
import java.util.List;
import java.util.stream.Collectors;
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
    public List<String> getTablesList() {
        LoggerHelper.getInstance().info("Calling \"getTablesList\"...");

        List<TablesEntity> list = 
            entityManager.createNamedQuery("tables.findAll")
            .getResultList()
        ;
        
        return list
            .stream()
            .map(item -> item.getName())
            .sorted()
            .collect(Collectors.toList())
        ;
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public String sayHello() {
        LoggerHelper.getInstance().info("Calling \"sayHello\"...");
        
        return AppConfiguration.getInstance().HELLO_MESSAGE;
    }
}
