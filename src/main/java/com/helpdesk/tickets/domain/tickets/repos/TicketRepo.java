package com.helpdesk.tickets.domain.tickets.repos;

import com.helpdesk.tickets.domain.tickets.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
}
