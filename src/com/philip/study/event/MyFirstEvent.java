package com.philip.study.event;

import com.philip.study.component.CompactDisk;
import org.springframework.context.ApplicationEvent;

/**
 * Created by philipl on 2020/1/11.
 */
public class MyFirstEvent extends ApplicationEvent {

    public String getMyFirstEevntMessage() {
        return myFirstEevntMessage;
    }

    private String myFirstEevntMessage;

    public MyFirstEvent(CompactDisk source, String message) {
        super(source);
        this.myFirstEevntMessage = message;
    }
}
