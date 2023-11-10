package com.ajotcole.closecirclenewsletter.types;

public class MailReceipient {

    String name;
    String email;

    public MailReceipient(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public MailReceipient() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
