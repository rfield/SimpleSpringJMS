package com.cvc.techarch.simplejms.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: RFIELD
 * Date: 12/14/11
 * Time: 2:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProducerMain {

    public static void main(String args[]) {

        Logger log = LoggerFactory.getLogger(ProducerMain.class);

        log.info("ProducerMain is running...");
        System.out.println(System.getProperty("user.dir"));

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("producer.xml");

        SimpleFileMessageProducer producer = applicationContext.getBean("producer", SimpleFileMessageProducer.class);
        producer.sendMessage();

        log.info("Message sent.");
    }
}
