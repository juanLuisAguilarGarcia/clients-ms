package com.pichincha.infra.adapter.db.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Persons {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String gender;
    private Integer age;

    @ManyToOne
    @JoinColumn(name="person_identification_type_id", nullable=false)
    private IdentificationType identificationType;

    @OneToOne(mappedBy = "persons")
    private Clients clients;

    @Column(name = "identification_number")
    private Long identification_number;

    private String address;

    @Column(name = "telephon_number")
    private Long telephonNumber;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;
}
