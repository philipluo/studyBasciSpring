package com.philip.study.component;

import com.philip.study.ApplicationContextHelper;
import com.philip.study.event.EventPublisher;
import com.philip.study.event.MyFirstEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by philipl on 2018/7/31.
 * Spring工厂在初始化bean的时候会先new实例，调用类的构造方法
 * 所以构造方法注入会先被执行
 * setter方法注入会后被执行
 * 如果在Config中使用了构造方法注入或者setter方法装配，会被类中的@Autowired装备覆盖
 */
@Component
@Scope("prototype")
public class CDPlayer {

    @Autowired
    EventPublisher eventPublisher;

    private CompactDisk compactDisk;

    @Autowired
    @Qualifier("HeroCD")
    public void setCompactDisk(CompactDisk compactDisk) {
        this.compactDisk = compactDisk;
    }

    public CDPlayer(){}

    public CDPlayer(CompactDisk cd){
        this.compactDisk=cd;
    }

    public void play(){
        System.out.println("CDPlayer started to play at:"+System.currentTimeMillis());
        //the 1st one: use ApplicationContext to publish event
        ApplicationContextHelper.publishEvent(new MyFirstEvent(compactDisk, "haha :) this is a event message"));

        //the 2nd one: user ApplicationEventAware to pulish event
        eventPublisher.publish(new MyFirstEvent(compactDisk, "hehe ^_^ this is another message"));

        System.out.println("CDPlayer ended play at: "+System.currentTimeMillis()+": "+compactDisk.singMyName());
    }

}
