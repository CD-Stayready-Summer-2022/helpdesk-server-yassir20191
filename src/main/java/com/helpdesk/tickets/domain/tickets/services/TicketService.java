package com.helpdesk.tickets.domain.tickets.services;

import com.helpdesk.tickets.domain.core.ResourceNotFoundException;
import com.helpdesk.tickets.domain.tickets.models.Ticket;
import com.helpdesk.tickets.domain.tickets.repos.TicketRepo;

import java.util.List;

public interface TicketService {
    Ticket create(Ticket ticket);
    Ticket getById(Long id) throws ResourceNotFoundException;
    List<Ticket> getAll();
    Ticket update(Long id, Ticket ticketDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
