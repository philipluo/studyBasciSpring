package com.philip.study;

import com.philip.study.component.CDPlayer;
import com.philip.study.component.CompactDisk;
import com.philip.study.component.PokerFaceCD;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.Arrays;
import java.util.List;

/**
 * Created by philipl on 2018/7/31.
 * 一些更新
 * 1. @ComponentScan默认扫描其类路径下的所有声明了@Component的bean并将其注册到bean工厂
 * 2. 通过@Bean可以实例化想要的任何一个实例（bean）并将其注册到Spring bean工厂里面，和@Configration是一样的
 * 3. 为了实现异步Event listener，声明了一个声明了SimpleAsyncTaskExecutor
 * 并将其注入到新声明的一个SimpleApplicationEventMulticaster的实例中
 * bean的名称是applicationEventMulticaster
 * 等同于AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME
 * 才能被AbstractApplicationContext在initApplicationEventMulticaster的时候拿到
 * 4. 或者直接使用@EnableAsync，等同于3，开启异步功能，但此异步与3中加一个SimpleAsyncTaskExecutor不一样
 */
@ComponentScan
//@EnableAsync
public class MyFirstConfig {

    @Bean
    public List<Integer> myList(){
        return Arrays.asList(1, 2, 3, 4, 5);
    }

    @Bean
    public CompactDisk newSecondCd(){
        CompactDisk cd = new PokerFaceCD();
        return cd;
    }

    /**
     * 注意，此处注入的 newSecondCD(PorkerFaceCD.class)是无效的，因为CDPlayer有自己的Autowired装配
     * newSecondCD仍然会使用其自动装配的HeroCD实例
     * @return
     */
    @Bean
    public CDPlayer newCdPlayer(){
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCompactDisk(newSecondCd());
        return cdPlayer;
    }

    @Bean
    public SimpleAsyncTaskExecutor taskExecutor(){
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        return simpleAsyncTaskExecutor;
    }

    /**
     * SimpleApplicationEventMulticaster is the bean to execute the published events
     * Inject a Async executor to SimpleApplicationEventMulticaster so that the event listeners could be run async
     * @return
     */
    @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster(){
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
        simpleApplicationEventMulticaster.setTaskExecutor(taskExecutor());
        return simpleApplicationEventMulticaster;
    }
}
