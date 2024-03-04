package com.trainticketing.model;

/**
 *
 * @author poonam
 */
public class Ticket
{
    private String userFirstName;
    private String userLasttName;
    private String userEmailAddress;
    private String from;
    private String to;
    private String price;
    private int seatNo;
    private String section;

    public Ticket(String userFirstName, String userLasttName, String userEmailAddress,
            String from, String to, String price, int seatNo, String section)
    {
        this.userFirstName = userFirstName;
        this.userLasttName = userLasttName;
        this.userEmailAddress = userEmailAddress;
        this.from = from;
        this.to = to;
        this.price = price;
        this.seatNo = seatNo;
        this.section = section;
    }

    public String getUserFirstName()
    {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName)
    {
        this.userFirstName = userFirstName;
    }

    public String getUserLasttName()
    {
        return userLasttName;
    }

    public void setUserLasttName(String userLasttName)
    {
        this.userLasttName = userLasttName;
    }

    public String getUserEmailAddress()
    {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress)
    {
        this.userEmailAddress = userEmailAddress;
    }

    
    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public int getSeatNo()
    {
        return seatNo;
    }

    public void setSeatNo(int seatNo)
    {
        this.seatNo = seatNo;
    }

    public String getSection()
    {
        return section;
    }

    public void setSection(String section)
    {
        this.section = section;
    }

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public String getTo()
    {
        return to;
    }

    public void setTo(String to)
    {
        this.to = to;
    }
}
