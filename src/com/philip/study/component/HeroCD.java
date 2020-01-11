package com.philip.study.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by philipl on 2018/7/31.
 */
@Component("HeroCD")
public class HeroCD implements CompactDisk, BeanNameAware {

    public String getMyName() {
        return myName;
    }

    private String myName;


    public HeroCD(){
        System.out.println("HeroCD created");
    }

    @Override
    public void setBeanName(String s) {
        myName = s;
    }

    @Override
    public String singMyName() {
        return "I get my name from BeannameArare: "+myName;
    }

}
