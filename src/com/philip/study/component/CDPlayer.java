package com.philip.study.component;

import com.philip.study.ApplicationContextHelper;
import com.philip.study.event.MyFirstEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by philipl on 2018/7/31.
 */
@Component
@Scope("prototype")
public class CDPlayer {

    @Autowired
    @Qualifier("HeroCD")
    private CompactDisk compactDisk;

    public void play(){
        System.out.println("CDPlayer started to play at:"+System.currentTimeMillis());
        ApplicationContextHelper.publishEvent(new MyFirstEvent(compactDisk, "haha :) this is a event message"));
        System.out.println("CDPlayer ended play at: "+System.currentTimeMillis()+": "+compactDisk.singMyName());
    }

}
