package com.example.hospitalapi.models;

import com.example.hospitalapi.appuser.AppUser;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RendezVous implements Serializable {


    @SequenceGenerator(
            name = "rv_sequence",
            sequenceName = "rv_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rv_sequence"
    )
    int idRendezVous;

    @ManyToOne
    @JoinColumn(name = "user_id")
    AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "structure_id")
    Structure structure;

    private Date dateRv;
    private String objetRv;
    private String resultAnalyse;
    private Boolean statusRv;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}