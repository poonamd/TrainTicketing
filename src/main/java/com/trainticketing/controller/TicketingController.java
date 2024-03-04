package com.trainticketing.controller;

import com.trainticketing.service.TicketService;
import com.trainticketing.model.Ticket;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ticket Controller class
 * @author poonam
 */
@RestController
@RequestMapping("/")
public class TicketingController
{
    
    @Autowired
    TicketService ticketService;

    @GetMapping("/purchaseTicket")
    @ResponseBody
    public String purchaseTicket(@RequestParam(name = "firstName") String firstName,
                                        @RequestParam(name = "lastName") String lastName,
                                        @RequestParam(name = "emailAddress") String emailAddress)
    {
        return ticketService.purchaseTicket(firstName, lastName, emailAddress);
    }
    
    @GetMapping("/getTicketDetails")
    @ResponseBody
    public Ticket getTicketDetails(@RequestParam(name = "emailAddress") String emailAddress)
    {
        return ticketService.getTicketDetails(emailAddress);
    }
    
    @GetMapping("/removeUser")
    @ResponseBody
    public String removeUser(@RequestParam(name = "emailAddress") String emailAddress)
    {
        return ticketService.removeUser(emailAddress);
    }
    
    @GetMapping("/getTicketDetailsBySection")
    @ResponseBody
    public List<Ticket> getTicketDetailsBySection(@RequestParam(name = "section") String section)
    {
        return ticketService.getTicketDetailsBySection(section);
    }
    
    @GetMapping("/modifyUserSeat")
    @ResponseBody
    public String modifyUserSeat(@RequestParam(name = "emailAddress") String emailAddress,
                        @RequestParam(name = "newSeatNo") int newSeatNo,
                        @RequestParam(name = "newSection") String newSection)
    {
        return ticketService.modifyUserSeat(emailAddress, newSeatNo, newSection);
    }
}
