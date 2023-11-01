package com.ajotcole.closecirclenewsletter.controller;

import com.ajotcole.closecirclenewsletter.types.Book;
import com.ajotcole.closecirclenewsletter.types.Mail;
import com.ajotcole.closecirclenewsletter.logic.SendMailMutation;
import com.ajotcole.closecirclenewsletter.repository.BookRepository;
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
    private SendMailMutation sendMailMutation;

    @SchemaMapping(typeName = "Query", value = "allBooks")
    public List<Book> getAllBooks() {
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

    @MutationMapping
    public Boolean sendMail(@Argument Mail mail) {
        return sendMailMutation.sendMail(mail);
    
    }

}