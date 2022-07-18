package com.helpdesk.tickets.domain.tickets.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Persister;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @PrePersist
    public void onCreate(){
        created = new Date();
    }
}
