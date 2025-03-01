package com.pichincha.infra.adapter.db.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Identification_Type")
@Getter
@Setter
public class IdentificationType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "identification_type_id")
    private Long identificationTypeId;

    private String description;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @OneToMany(mappedBy="identificationType")
    private List<Persons> persons;
}
