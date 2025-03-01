package com.pichincha.infra.adapter.db.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Clients {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "client_id")
    private Long clientId;

    private String password;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_person_id", referencedColumnName = "person_id")
    private Persons persons;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;
}
