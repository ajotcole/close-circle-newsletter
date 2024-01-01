package com.ajotcole.closecirclenewsletter.repository;

import com.ajotcole.closecirclenewsletter.model.MailReceipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRecipientRepository extends JpaRepository<MailReceipient, Long> {


}
