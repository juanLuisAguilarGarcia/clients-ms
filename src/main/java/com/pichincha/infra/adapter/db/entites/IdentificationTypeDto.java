package com.pichincha.infra.adapter.db.entites;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Identification_Type")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdentificationTypeDto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "identification_type_id")
    private Long identificationTypeId;

    private String description;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @OneToMany(mappedBy= "identification")
    private List<PersonsDto> people;
}
