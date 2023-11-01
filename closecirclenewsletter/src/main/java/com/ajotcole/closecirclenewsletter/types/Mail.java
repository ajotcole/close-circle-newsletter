package com.ajotcole.closecirclenewsletter.types;

import java.util.List;

public class Mail {
    String subject;
    String message;
    List<MailReceipient> receipients;

    public Mail(String subject, String message, List<MailReceipient> receipients) {
        super();
        this.subject = subject;
        this.message = message;
        this.receipients = receipients;
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

    public List<MailReceipient> getReceipients() {
        return receipients;
    }

    public void setReceipients(List<MailReceipient> receipients) {
        this.receipients = receipients;
    }
}
