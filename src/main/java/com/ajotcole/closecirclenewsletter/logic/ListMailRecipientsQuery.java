package com.ajotcole.closecirclenewsletter.logic;

import com.ajotcole.closecirclenewsletter.types.MailReceipient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ListMailRecipientsQuery {

    Logger logger = LoggerFactory.getLogger(ListMailRecipientsQuery.class);


    public List<MailReceipient> getMailRecipients() {
        // TODO remove when fully implemented
        MailReceipient sampleRecipient = new MailReceipient
                .Builder()
                .setName("Testname")
                .setEmail("foo@mail.com")
                .build();

        var sampleRecipientList = List.of(sampleRecipient);

        logger.info("Retrieved {} recipients", sampleRecipientList.size());

        return sampleRecipientList;
    }

}
