package com.ajotcole.closecirclenewsletter;

import com.ajotcole.closecirclenewsletter.controller.MainController;
import com.ajotcole.closecirclenewsletter.model.Book;
import com.ajotcole.closecirclenewsletter.model.MutationResponse;
import com.ajotcole.closecirclenewsletter.repository.BookRepository;
import com.ajotcole.closecirclenewsletter.repository.SendMailMutation;
import com.ajotcole.closecirclenewsletter.repository.SignUpMutation;
import com.ajotcole.closecirclenewsletter.service.MailRecipientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Import({BookRepository.class, SendMailMutation.class, SignUpMutation.class, MailRecipientService.class})
@GraphQlTest(MainController.class)
public class SendMailMutationIT {

    @Autowired
    GraphQlTester graphQlTester;

    @Test
    public void firstSampleTest() throws Exception {
        // language=GraphQL
        String query = """
                query {
                    allBooks {
                        id
                        title
                    }
                }
                """;

            graphQlTester.document(query)
                    .execute()
                    .path("allBooks")
                    .entityList(Book.class)
                    .hasSize(2);
    }

    @Test
    public void sendMailSuccessfully() throws Exception {
        // language=GraphQL
        String query = """
                query sendMail {
                    sendMail(mail: {
                        recipients: [
                            name: "testName"
                            email: "test@mail.com"
                        ]
                        subject: "testSubject"
                        message: "test message"
                    })
                }""";

        graphQlTester.document(query)
                .execute()
                .path("sendMail")
                .entity(MutationResponse.class);
    }
}
