package com.philip.study.event.listener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by philipl on 2020/1/11.
 * Use Annotation instead of implementing ApplicationListener
 */
@Component
public class ContextRefreshedEventListener2 {

    @EventListener
    public void listenerProcess(ContextRefreshedEvent contextRefreshedEvent){
        System.out.println("ContextRefreshedEventListener2---->"+contextRefreshedEvent.toString());
    }
}
