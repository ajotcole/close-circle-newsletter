package com.ajotcole.closecirclenewsletter;

import com.ajotcole.closecirclenewsletter.controller.MainController;
import com.ajotcole.closecirclenewsletter.model.MailReceipient;
import com.ajotcole.closecirclenewsletter.repository.BookRepository;
import com.ajotcole.closecirclenewsletter.repository.MailRecipientRepository;
import com.ajotcole.closecirclenewsletter.repository.SendMailMutation;
import com.ajotcole.closecirclenewsletter.repository.SignUpMutation;
import com.ajotcole.closecirclenewsletter.service.MailRecipientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest
@AutoConfigureGraphQlTester
public class ListMailRecipientsQueryIT {

    @Autowired
    GraphQlTester graphQlTester;

    @Test
    public void listAllMailRecipients() throws Exception {
        // language=GraphQL
        String query = """
            query ListMailRecipients {
              listMailRecipients {
                name,
                email
              }
            }
        """;

        // TODO update with test data
        graphQlTester.document(query)
                .execute()
                .path("listMailRecipients")
                .entityList(MailReceipient.class)
                .hasSize(0);

    }
}
