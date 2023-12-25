package com.ajotcole.closecirclenewsletter;

import com.ajotcole.closecirclenewsletter.controller.MainController;
import com.ajotcole.closecirclenewsletter.model.MailReceipient;
import com.ajotcole.closecirclenewsletter.repository.BookRepository;
import com.ajotcole.closecirclenewsletter.repository.ListMailRecipientsQuery;
import com.ajotcole.closecirclenewsletter.repository.SendMailMutation;
import com.ajotcole.closecirclenewsletter.repository.SignUpMutation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

@Import({BookRepository.class, SendMailMutation.class, SignUpMutation.class, ListMailRecipientsQuery.class})
@GraphQlTest(MainController.class)
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
                .hasSize(1);

    }
}
