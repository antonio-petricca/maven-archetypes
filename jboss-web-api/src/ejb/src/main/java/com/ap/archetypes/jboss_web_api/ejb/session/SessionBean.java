package com.ap.archetypes.jboss_web_api.ejb.session;

import com.ap.archetypes.jboss_web_api.common.configuration.AppConfiguration;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class SessionBean implements SessionBeanLocal {
    
    @Override
    public String sayHello() {
        return AppConfiguration.getInstance().HELLO_MESSAGE;
    }
}
