package com.philip.study;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by philipl on 2020/1/11.
 */
@Component
public class ApplicationContextHelper implements ApplicationContextAware{

    static ApplicationContext applicationContextInstance;

    public static ApplicationContext instance(){
        return applicationContextInstance;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContextInstance = applicationContext;
    }

    public static void publishEvent(ApplicationEvent applicationEvent){
        applicationContextInstance.publishEvent(applicationEvent);
    }
    
}
