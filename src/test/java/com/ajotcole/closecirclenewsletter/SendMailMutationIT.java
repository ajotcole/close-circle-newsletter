package com.ajotcole.closecirclenewsletter;

import net.minidev.json.JSONObject;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SendMailMutationIT {

    private final MockMvc mockMvc;

    @Autowired
    public SendMailMutationIT(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void firstSampleTest() throws Exception {
        String query = "query allBooks() {" +
                " allBooks {" +
                "  id" +
                "  title" +
                " }" +
                "}";
        JSONObject variables = new JSONObject();

        MvcResult mvcResult = mockMvc.perform(post("/graphql")
                        .content(generateRequest(query, variables))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(notNullValue()))
                .andReturn();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void sendMailSuccessfully() throws Exception {
        String query = "mutation SendMail {\n" +
                "  sendMail(mail: {\n" +
                "    recipients: [\n" +
                "      {\n" +
                "        name: \"testName\"\n" +
                "        email: \"test@mail.com\"\n" +
                "      }\n" +
                "    ]\n" +
                "    subject: \"testSubject\"\n" +
                "    message: \"test message\"\n" +
                "  }\n" +
                "  )\n" +
                "}";
        JSONObject variables = new JSONObject();

        MvcResult mvcResult = mockMvc.perform(post("/graphql")
                        .content(generateRequest(query, variables))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(notNullValue()))
                .andReturn();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private String generateRequest(String query, JSONObject variables) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("query", query);
        if (variables != null) {
            jsonObject.put("variables", variables);
        }
        return jsonObject.toString();
    }
}
