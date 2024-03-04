# TrainTicketing Project
A train ticket purchase app for train between London and France.

Assumptions -
	1.	One email address can only purchase 1 ticket.
	2. 	Only 50 tickets can be purchased per section.
	3.	Section A of train will be filled before Section B.
 
Following are the APIs as requested
	1.	/purchaseTicket - a ticket is purchased in either section A or section B of the train.
         Parameters - firstName - user first name 
                      lastName - user last name
                      emailAddress - user email address
	2.	/getTicketDetails - returns ticket details
         Parameters - emailAddress - user email address for the ticket
	3.	/removeUser - removes tickets for the given user 
         Parameters - emailAddress - user email address
	4.	/getTicketDetailsBySection - returns tickets for the given section
         Parameters - section - "A" or "B"
	5.	/modifyUserSeat - modifies user seats to new seat no and new section if that seat is free
         Parameters - emailAddress - user email address
                      newSeatNo - new seat no newSection - new section

