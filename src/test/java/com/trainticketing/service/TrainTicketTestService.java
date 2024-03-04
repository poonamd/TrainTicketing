package com.trainticketing.service;

import com.trainticketing.dao.TicketDao;
import com.trainticketing.model.Ticket;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author poonam
 */
@ExtendWith(SpringExtension.class)
public class TrainTicketTestService
{
    @Mock
    TicketDao ticketDaoMock;

    @InjectMocks
    TicketService ticketService;

    
    @Test
    public void testGetByEmailAddress()
    {
        Ticket expectedData = new Ticket("user1", "name1", "user1@gmail.com", "London", "France", "$5", 10, "A");
        when(ticketDaoMock.getTicketDetails("user1@gmail.com")).thenReturn(expectedData);
        Ticket ticket = ticketService.getTicketDetails("user1@gmail.com");
        assertEquals("user1", ticket.getUserFirstName());
    }
    
    @Test
    public void testPurchaseTicket()
    {
        Ticket expectedData = new Ticket("newUser", "abc", "newUser1@gmail.com", "London", "France", "$5", 13, "A");
        when(ticketDaoMock.getTicketDetails("newUser1@gmail.com")).thenReturn(expectedData);
        ticketService.purchaseTicket("newUser", "abc", "newUser1@gmail.com");
        Ticket ticket = ticketService.getTicketDetails("newUser1@gmail.com");
        assertEquals(13, ticket.getSeatNo());
    }
    
    
    @Test
    public void testModifySeat()
    {
        Ticket expectedData = new Ticket("newUser", "abc", "newUser1@gmail.com", "London", "France", "$5", 14, "B");
        when(ticketDaoMock.getTicketDetails("newUser1@gmail.com")).thenReturn(expectedData);
        ticketService.purchaseTicket("newUser", "abc", "newUser1@gmail.com");
        ticketService.modifyUserSeat("newUser1@gmail.com", 14, "B");
        Ticket ticket = ticketService.getTicketDetails("newUser1@gmail.com");
        assertEquals(14, ticket.getSeatNo());
    }
    
    @Test
    public void testTicketBySection()
    {
        Ticket expectedData = new Ticket("newUser", "abc", "newUser1@gmail.com", "London", "France", "$5", 14, "B");
        when(ticketDaoMock.getTicketDetails("newUser1@gmail.com")).thenReturn(expectedData);
        ticketService.purchaseTicket("newUser", "abc", "newUser1@gmail.com");
        ticketService.modifyUserSeat("newUser1@gmail.com", 14, "B");
        Ticket ticket = ticketService.getTicketDetails("newUser1@gmail.com");
        assertEquals("B", ticket.getSection());
    }
    
    
}
