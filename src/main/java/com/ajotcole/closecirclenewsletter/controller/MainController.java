package com.ajotcole.closecirclenewsletter.controller;

import com.ajotcole.closecirclenewsletter.repository.SignUpMutation;
import com.ajotcole.closecirclenewsletter.model.Book;
import com.ajotcole.closecirclenewsletter.model.Mail;
import com.ajotcole.closecirclenewsletter.repository.SendMailMutation;
import com.ajotcole.closecirclenewsletter.repository.BookRepository;
import com.ajotcole.closecirclenewsletter.model.MailReceipient;
import com.ajotcole.closecirclenewsletter.model.MutationResponse;
import com.ajotcole.closecirclenewsletter.service.MailRecipientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private SendMailMutation sendMailMutation;
    @Autowired
    private SignUpMutation signUpMutation;
    @Autowired
    private MailRecipientService mailRecipientService;

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @SchemaMapping(typeName = "Query", value = "allBooks")
    public List<Book> getAllBooks() {

        logger.info("All books working now");
        return bookRepository.allBooks();
    }

    @QueryMapping
    public Book bookById(@Argument Integer id) {
        return bookRepository.bookById(id);
    }

    @MutationMapping
    public Book updateBook(@Argument Integer id, @Argument String title) {
        return bookRepository.updateBook(id, title);
    }

    @QueryMapping
    public List<MailReceipient> listMailRecipients() {
        return mailRecipientService.getAllMailRecipients();
    }

    @MutationMapping
    public MutationResponse sendMail(@Argument Mail mail) {
        logger.info("Starting send mail mutation");

        return sendMailMutation.sendMail(mail);
    }

    @MutationMapping
    public MutationResponse signUp(@Argument String email, @Argument String name) {
        logger.info("Starting mutation to sign up for newsletter");

        // TODO create logic for mutation, also extend graphql definition

        return signUpMutation.createNewRecipient(email, name);
    }

}