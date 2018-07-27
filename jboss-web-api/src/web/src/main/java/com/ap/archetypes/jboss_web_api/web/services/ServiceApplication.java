package com.ap.archetypes.jboss_web_api.web.services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("${application.context.rest}")
public class ServiceApplication extends Application {
}
