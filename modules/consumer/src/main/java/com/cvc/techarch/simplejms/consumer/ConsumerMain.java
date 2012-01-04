package com.cvc.techarch.simplejms.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: RFIELD
 * Date: 6/8/11
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ConsumerMain {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(ConsumerMain.class);

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");

        log.info("Consumer listening...");
    }
}
