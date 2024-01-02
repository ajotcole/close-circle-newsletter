package com.ajotcole.closecirclenewsletter.service;

import com.ajotcole.closecirclenewsletter.model.MailReceipient;
import com.ajotcole.closecirclenewsletter.repository.MailRecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MailRecipientService {

    private final MailRecipientRepository mailRecipientRepository;

    public MailRecipientService(MailRecipientRepository mailRecipientRepository) {
        this.mailRecipientRepository = mailRecipientRepository;
    }

    public List<MailReceipient> getAllMailRecipients() {
        return mailRecipientRepository.findAll();
    }

}
