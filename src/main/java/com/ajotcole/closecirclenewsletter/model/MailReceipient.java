package com.ajotcole.closecirclenewsletter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MailReceipient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public MailReceipient() {
        super();
    }

    public Long getId() {
        return id;
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

    public static class Builder {
        private final MailReceipient mailReceipient = new MailReceipient();

        public Builder setName(String name) {
            mailReceipient.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            mailReceipient.email = email;
            return this;
        }

        public MailReceipient build() {
            return mailReceipient;
        }
    }
}
