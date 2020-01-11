package com.philip.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by philipl on 2018/7/31.
 */
@ComponentScan
public class MyFirstConfig {

    @Bean
    public List<Integer> myList(){
        return Arrays.asList(1, 2, 3, 4, 5);
    }

    /**
     * SimpleApplicationEventMulticaster is the bean to execute the published events
     * Inject a Async executor to SimpleApplicationEventMulticaster so that the event listeners could be run async
     * @return
     */
    @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster(){
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
        simpleApplicationEventMulticaster.setTaskExecutor(simpleAsyncTaskExecutor);
        return simpleApplicationEventMulticaster;
    }

//    @Bean
//    public SimpleAsyncTaskExecutor taskExecutor(){
//        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
//        return simpleAsyncTaskExecutor;
//    }

}
