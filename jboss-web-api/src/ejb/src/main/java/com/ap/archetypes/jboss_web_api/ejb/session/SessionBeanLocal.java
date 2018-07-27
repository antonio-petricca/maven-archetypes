package com.ap.archetypes.jboss_web_api.ejb.session;

import javax.ejb.Local;

@Local
public interface SessionBeanLocal {
    
    String sayHello();
            
}
