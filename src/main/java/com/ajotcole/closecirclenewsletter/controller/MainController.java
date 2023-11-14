package com.ajotcole.closecirclenewsletter.controller;

import com.ajotcole.closecirclenewsletter.logic.ListMailRecipientsQuery;
import com.ajotcole.closecirclenewsletter.logic.SignUpMutation;
import com.ajotcole.closecirclenewsletter.types.Book;
import com.ajotcole.closecirclenewsletter.types.Mail;
import com.ajotcole.closecirclenewsletter.logic.SendMailMutation;
import com.ajotcole.closecirclenewsletter.repository.BookRepository;
import com.ajotcole.closecirclenewsletter.types.MailReceipient;
import com.ajotcole.closecirclenewsletter.types.MutationResponse;
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
    private  ListMailRecipientsQuery listMailRecipientsQuery;

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
        return listMailRecipientsQuery.getMailRecipients();
    }

    @MutationMapping
    public MutationResponse sendMail(@Argument Mail mail) {
        logger.info("Starting send mail mutation");

        //return sendMailMutation.sendMail(mail);

        return new MutationResponse();
    
    }

    @MutationMapping
    public MutationResponse signUp(@Argument String mailAddress) {
        logger.info("Starting mutation to sign up for newsletter");

        // TODO create logic for mutation, also extend graphql definition

        return new MutationResponse();
    }

}