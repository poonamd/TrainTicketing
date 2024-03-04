package com.trainticketing.service;

import com.trainticketing.model.Ticket;
import com.trainticketing.dao.TicketDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * DataStore to save tickets
 * @author poonam
 */
public class TicketService
{
    @Autowired
    TicketDao ticketDao;
    
    private static final String TICKET_PRICE = "$5";
    private static final String FROM_CITY = "London";
    private static final String TO_CITY = "France";
    

    /**
     * Method to purchase tickets
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @return msg details
     */
    public String purchaseTicket(String firstName, String lastName, String emailAddress)
    {
        // check if user already has ticket
        Ticket t = ticketDao.getTicketDetails(emailAddress);
        if (t != null)
        {
            return "Ticket already exist for emailAddress - " + emailAddress;
        }

        // find free seat in section A
        int seatNo = ticketDao.findFreeSeatInSection("A");
        if (seatNo != -1)
        {
            ticketDao.purchaseTicket(firstName, lastName, emailAddress, FROM_CITY, TO_CITY, TICKET_PRICE, seatNo, "A");
            return "Ticket Purchased";
        }
        else
        {
            // find free seat in section B
            seatNo = ticketDao.findFreeSeatInSection("B");
            if (seatNo != -1)
            {
                ticketDao.purchaseTicket(firstName, lastName, emailAddress, FROM_CITY, TO_CITY, TICKET_PRICE, seatNo, "B");
                return "Ticket Purchased";
            }
        }
        return "No free seats in any section";
    }

    /**
     * Method to get ticket details
     * @param emailAddress
     * @return ticket details
     */
    public Ticket getTicketDetails(String emailAddress)
    {
        return ticketDao.getTicketDetails(emailAddress);
    }
    
    /**
     * Method to remove user
     * @param emailAddress
     * @return msg string
     */
    public String removeUser(String emailAddress)
    {
        boolean ret = ticketDao.removeUser(emailAddress);
        if (ret)
        {
            return "User - " + emailAddress + " removed.";
        }
        else
        {
            return "User - " + emailAddress + " not found.";
        }
    }
    
    /**
     * Method to get list of tickets by section
     * @param section
     * @return ticket list
     */
    public List<Ticket> getTicketDetailsBySection(String section)
    {
        return ticketDao.getTicketBySection(section);
    }
    
    /**
     * Method to update user seat in the ticket
     * @param emailAddress
     * @param seatNo
     * @param section
     * @return 
     */
    public String modifyUserSeat(String emailAddress, int seatNo, String section)
    {
        // first check if seatNo is free in section
        boolean seatFree = ticketDao.checkIfSeatFree(seatNo, section);
        if (!seatFree)
        {
            return "Seat " + seatNo + " in Section " + section + " not free";
        }
        else
        {
            Ticket ticket = ticketDao.updateTicket(emailAddress, seatNo, section);
            if (ticket != null)
            {
                return "Ticket updated";
            }
            else
            {
                return "Email address not found.";
            }
        }
    }

}
