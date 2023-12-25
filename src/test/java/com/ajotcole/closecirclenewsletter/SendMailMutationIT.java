package com.ajotcole.closecirclenewsletter;

import com.ajotcole.closecirclenewsletter.controller.MainController;
import com.ajotcole.closecirclenewsletter.model.Book;
import com.ajotcole.closecirclenewsletter.model.MutationResponse;
import com.ajotcole.closecirclenewsletter.repository.BookRepository;
import com.ajotcole.closecirclenewsletter.repository.ListMailRecipientsQuery;
import com.ajotcole.closecirclenewsletter.repository.SendMailMutation;
import com.ajotcole.closecirclenewsletter.repository.SignUpMutation;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import({BookRepository.class, SendMailMutation.class, SignUpMutation.class, ListMailRecipientsQuery.class})
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
