package com.cvc.techarch.simplejms.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.io.FileInputStream;


public class SimpleFileMessageProducer implements MessageProducer {

    @Autowired
    public SimpleFileMessageProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public void sendMessage() {

        Logger logger = LoggerFactory.getLogger(SimpleFileMessageProducer.class);

        logger.info("Filename=" + fileName);
        try {
            String message = FileUtil.stringFromInputStream( new FileInputStream(fileName) );
            jmsTemplate.convertAndSend((Object) message, new MessagePostProcessor() {
                @Override
                public Message postProcessMessage(Message message) throws JMSException {
                    message.setBooleanProperty("JMS_TIBCO_COMPRESS", true);
                    return message;
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("Done");
    }

    private JmsTemplate jmsTemplate;
    private Destination destination;
    private String fileName;
}
