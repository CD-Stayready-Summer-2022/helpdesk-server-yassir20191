package com.helpdesk.tickets.domain.tickets.services;

import com.helpdesk.tickets.domain.core.ResourceNotFoundException;
import com.helpdesk.tickets.domain.tickets.models.Ticket;
import com.helpdesk.tickets.domain.tickets.repos.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
    private TicketRepo ticketRepo;

    @Autowired
    public TicketServiceImpl(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @Override
    public Ticket create(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    @Override
    public Ticket getById(Long id) throws ResourceNotFoundException {
        Ticket ticket = ticketRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Ticket with id not found " + id));
        return ticket;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepo.findAll();
    }

    @Override
    public Ticket update(Long id, Ticket ticketDetail) throws ResourceNotFoundException {
        Ticket ticket = getById(id);
        ticket.setTitle(ticketDetail.getTitle());
        ticket.setBody(ticketDetail.getBody());
        return ticketRepo.save(ticket);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Ticket ticket = getById(id);
        ticketRepo.delete(ticket);
    }
}
