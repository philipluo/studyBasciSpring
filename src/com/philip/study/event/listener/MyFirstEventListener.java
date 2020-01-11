package com.philip.study.event.listener;

import com.philip.study.component.CompactDisk;
import com.philip.study.event.MyFirstEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Created by philipl on 2020/1/11.
 */
@Component
public class MyFirstEventListener {

    @EventListener
    @Async
    public void listenerProcess(MyFirstEvent myFirstEvent){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.isInstanceOf(CompactDisk.class, myFirstEvent.getSource());
        CompactDisk cd = (CompactDisk)myFirstEvent.getSource();
        System.out.println("MyFirstEventListener--->"+myFirstEvent.getMyFirstEevntMessage()+" --->from "+cd+" at: "+myFirstEvent.getTimestamp());

    }
}
