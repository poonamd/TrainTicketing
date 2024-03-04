package com.trainticketing;

import com.trainticketing.dao.TicketDao;
import com.trainticketing.service.TicketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main application file
 * @author poonam
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
    }

    @Bean
    public TicketDao ticketDao()
    {
        TicketDao ticketDao = new TicketDao();
        return ticketDao;
    }

    @Bean
    public TicketService ticketService()
    {
        TicketService ticketService = new TicketService();
        return ticketService;
    }
    
    

}
