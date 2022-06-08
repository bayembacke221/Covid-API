package com.example.hospitalapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Structure implements Serializable {

    @SequenceGenerator(
            name="structure_sequence",
            sequenceName = "structure_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "structure_sequence"
    )
    int idStructure;
    private String nomHopital;
    private int contact;
    private String adresseHopital;
    private Double latitude;
    private Double longitude;
    private int nbVaccinDispo;
    private int nbTestDisp;
    @OneToMany(mappedBy="structure",

            targetEntity=RendezVous.class,
            fetch=FetchType.EAGER)
    @JsonIgnore
    private List<RendezVous> rendezVous;


}
