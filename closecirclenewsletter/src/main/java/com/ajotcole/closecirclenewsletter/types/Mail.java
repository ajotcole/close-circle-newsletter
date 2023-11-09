package com.ajotcole.closecirclenewsletter.types;

import java.util.List;

public class Mail {
    String subject;
    String message;
    List<MailReceipient> recipients;

    public Mail(String subject, String message, List<MailReceipient> recipients) {
        super();
        this.subject = subject;
        this.message = message;
        this.recipients = recipients;
    }

    public Mail() {
        super();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MailReceipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<MailReceipient> recipients) {
        this.recipients = recipients;
    }
}
