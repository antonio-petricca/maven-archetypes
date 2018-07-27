package com.ap.archetypes.jboss_web_api.ejb.session;

import java.util.List;
import javax.ejb.Local;

@Local
public interface SessionBeanLocal {
    
    List<String> getTablesList();
    String       sayHello();
            
}
