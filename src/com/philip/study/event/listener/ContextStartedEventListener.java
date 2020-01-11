package com.philip.study.event.listener;

import com.philip.study.ApplicationContextHelper;
import com.philip.study.component.CompactDisk;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by philipl on 2020/1/11.
 */
@Component
public class ContextStartedEventListener implements ApplicationListener<ContextStartedEvent>{

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("Context was started: "+contextStartedEvent);
        ApplicationContext context = ApplicationContextHelper.instance();
        String[] allBeanNames = context.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            System.out.println(beanName);
//            if("pokerFaceCD".equals(beanName)) {
//                CompactDisk cd = context.getBean(beanName, CompactDisk.class);
//                System.out.println("ContextStartedEventListener---->"+cd.singMyName());
//            }
        }
    }
}
