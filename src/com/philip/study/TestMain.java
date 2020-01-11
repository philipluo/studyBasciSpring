package com.philip.study;

import com.philip.study.component.CDPlayer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by philipl on 2018/7/31.
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyFirstConfig.class);
        context.start();
        CDPlayer cdPlayer = context.getBean("CDPlayer", CDPlayer.class);
        cdPlayer.play();
//        List<Integer> myList = (List)context.getBean("myList");
//        myList.forEach(System.out::println);
    }

}
