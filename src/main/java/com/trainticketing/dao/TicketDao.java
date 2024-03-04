package com.trainticketing.dao;

import com.trainticketing.model.Ticket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This Dao Stores tickets and provides methods to get ticket details and update tickets
 * @author poonam
 */
public class TicketDao
{
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(TicketDao.class);
    
    private static final int MAX_NO_OF_PASSENGER_PER_SECTION = 20;
    
    // variable to store all tickets
    private final List<Ticket> tickets;
    
    // variables to maintain free seats in each section
    private final List<Integer> freeSeatsInSectionA;
    private final List<Integer> freeSeatsInSectionB;

    /**
     * Constructor
     */
    public TicketDao()
    {
        tickets = new ArrayList<>();
        freeSeatsInSectionA = new ArrayList<>();
        freeSeatsInSectionB = new ArrayList<>();

        for (int i = 0; i < MAX_NO_OF_PASSENGER_PER_SECTION; i++)
        {
            freeSeatsInSectionA.add(i+1);
            freeSeatsInSectionB.add(i+1);
        }
    }
    
    /**
     * Method to purchase ticket
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param from
     * @param to
     * @param ticketPrice
     * @param seatNo
     * @param section
     * @return new ticket
     */
    public Ticket purchaseTicket(String firstName, String lastName, String emailAddress,
            String from, String to, String ticketPrice, int seatNo, String section)
    {
        // create new ticket and add to ticket list
        Ticket newTicket = new Ticket(firstName, lastName, emailAddress, from, to, ticketPrice, seatNo, section);
        tickets.add(newTicket);
        return newTicket;
    }

    /**
     * finds free seat in given section
     * @param section
     * @return 
     */
    public int findFreeSeatInSection(String section)
    {
        List<Integer> sectionSeatList;
        if (section.equalsIgnoreCase("A"))
        {
            sectionSeatList = freeSeatsInSectionA;
        }
        else if (section.equalsIgnoreCase("B"))
        {
            sectionSeatList = freeSeatsInSectionB;
        }
        else
        {
            return -1;
        }
        
        if (sectionSeatList.isEmpty())
        {
            return -1;
        }
        Integer freeSeat = sectionSeatList.get(0);
        sectionSeatList.remove(freeSeat);
        
        return freeSeat;
    }

    /**
     * Method to find tickets by section
     * @param section
     * @return list of tickets
     */
    public List<Ticket> getTicketBySection(String section)
    {
        List<Ticket> ticketsToReturn = new ArrayList<>();
        for (Ticket t : tickets)
        {
            if (t.getSection().equalsIgnoreCase(section))
            {
                ticketsToReturn.add(t);
            }
        }
        return Collections.unmodifiableList(ticketsToReturn);
    }
    
    /**
     * Method to delete user
     * @param emailAddress
     * @return list of tickets
     */
    public boolean removeUser(String emailAddress)
    {
        Ticket ticketToDelete = null;
        for (Ticket t : tickets)
        {
            if (t.getUserEmailAddress().equalsIgnoreCase(emailAddress))
            {
                ticketToDelete = t;
                break;
            }
        }
        if (ticketToDelete != null)
        {
            tickets.remove(ticketToDelete);
            return true;
        }
        return false;
    }
    
    /**
     * Method to get Ticket details by user
     * @param emailAddress
     * @return tickets
     */
    public Ticket getTicketDetails(String emailAddress)
    {
        for (Ticket t : tickets)
        {
            if (t.getUserEmailAddress().equalsIgnoreCase(emailAddress))
            {
                return t;
            }
        }
        return null;
    }
    
    public Ticket getTicket(int seatNo, String section)
    {
        for (Ticket t : tickets)
        {
            if (t.getSeatNo() == seatNo && t.getSection().equalsIgnoreCase(section))
            {
                return t;
            }
        }
        return null;
    }
    
    public boolean checkIfSeatFree(int seatNo, String section)
    {
        List<Integer> sectionSeatList;
        if (section.equalsIgnoreCase("A"))
        {
            sectionSeatList = freeSeatsInSectionA;
        }
        else if (section.equalsIgnoreCase("B"))
        {
            sectionSeatList = freeSeatsInSectionB;
        }
        else
        {
            return false;
        }
        
        return sectionSeatList.contains((Integer) seatNo);
    }
    
    public Ticket updateTicket(String emailAddress, int newSeatNo, String newSection)
    {
        for (Ticket t : tickets)
        {
            if (t.getUserEmailAddress().equalsIgnoreCase(emailAddress))
            {
                int oldSeatNo = t.getSeatNo();
                String oldSection = t.getSection();
                t.setSeatNo(newSeatNo);
                t.setSection(newSection);

                // remove new seat from appropriate free seat section list
                if (newSection.equalsIgnoreCase("A"))
                {
                    freeSeatsInSectionA.remove((Integer)newSeatNo);
                }
                else if (oldSection.equalsIgnoreCase("B"))
                {
                    freeSeatsInSectionB.remove((Integer)newSeatNo);
                }
                
                // add old seat back to appropriate free seat section list
                if (oldSection.equalsIgnoreCase("A"))
                {
                    freeSeatsInSectionA.add(oldSeatNo);
                }
                else if (oldSection.equalsIgnoreCase("B"))
                {
                    freeSeatsInSectionB.add(oldSeatNo);
                }

                return t;
            }
        }
        return null;
    }    
}
