package com.philip.study.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by philipl on 2018/7/31.
 */
@Component
@Primary
public class PokerFaceCD implements CompactDisk {
    @Override
    public String singMyName() {
        return "I don't know my name";
    }
}
