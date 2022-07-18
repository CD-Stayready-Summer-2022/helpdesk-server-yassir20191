package com.helpdesk.tickets.domain.tickets.controller;

import com.helpdesk.tickets.domain.tickets.models.Ticket;
import com.helpdesk.tickets.domain.tickets.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAll(){
        List<Ticket> tickets = ticketService.getAll();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ticket> getById(@PathVariable("id")Long id){
        Ticket ticket = ticketService.getById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket){
        ticket = ticketService.create(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Ticket> update(@PathVariable("id")Long id, @RequestBody Ticket ticketDetail){
        ticketDetail = ticketService.update(id, ticketDetail);
        return new ResponseEntity<>(ticketDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        ticketService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
