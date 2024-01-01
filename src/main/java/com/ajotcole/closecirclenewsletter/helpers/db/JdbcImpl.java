package com.ajotcole.closecirclenewsletter.helpers.db;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcImpl {

    private final DataSource dataSource;

    public JdbcImpl(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void start() {
        final JdbcTemplate template = new JdbcTemplate(dataSource);
        template.execute("SELECT * FROM mail_recipients");
    }

}
