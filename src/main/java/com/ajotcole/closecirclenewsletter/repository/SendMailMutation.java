package com.ajotcole.closecirclenewsletter.repository;

import com.ajotcole.closecirclenewsletter.model.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SendMailMutation {

    Logger logger = LoggerFactory.getLogger(SendMailMutation.class);

    public Boolean sendMail(Mail mail) {

        logger.info(String.valueOf(mail));

        // connect to strapi and retrieve template

        // fill template variables with values

        // send mail and add history row in db

        return true;
    }

}
