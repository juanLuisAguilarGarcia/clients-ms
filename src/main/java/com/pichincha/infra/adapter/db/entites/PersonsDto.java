package com.pichincha.infra.adapter.db.entites;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "Persons", uniqueConstraints={@UniqueConstraint(columnNames = {"person_identification_type_id" , "identification_number"})})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonsDto {
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
    private IdentificationTypeDto identification;

    @OneToOne(mappedBy = "persons")
    private ClientsDto clientsDto;

    @Column(name = "identification_number")
    private Long identificationNumber;

    private String address;

    @Column(name = "telephon_number")
    private Long telephonNumber;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;
}
