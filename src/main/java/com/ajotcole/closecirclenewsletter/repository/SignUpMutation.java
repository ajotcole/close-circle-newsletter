package com.ajotcole.closecirclenewsletter.repository;

import com.ajotcole.closecirclenewsletter.model.MutationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SignUpMutation {

    Logger logger = LoggerFactory.getLogger(SignUpMutation.class);

    public MutationResponse createNewRecipient(String email, String name) {

        logger.info("Start creating new recipient with email {} and name {}", email, name);

        return new MutationResponse.Builder().setMessage("Test").setStatusCode(200).build();

    }
}
