package com.example.hospitalapi.models;

import com.example.hospitalapi.appuser.AppUser;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class RendezVous implements Serializable {


    @SequenceGenerator(
            name="rv_sequence",
            sequenceName = "rv_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rv_sequence"
    )
    Long idRendezVous;

    @ManyToOne
    @JoinColumn(name = "user_id")
    AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "structure_id")
    Structure structure;

    private String dateRv;
    private String objetRv;
    private String resultAnalyse;
    private Boolean statusRv;

    public RendezVous() {
    }

    public RendezVous(AppUser appUser,
                      Structure structure,
                      String dateRv,
                      String objetRv,
                      String resultAnalyse,
                      Boolean statusRv) {
        this.appUser = appUser;
        this.structure = structure;
        this.dateRv = dateRv;
        this.objetRv = objetRv;
        this.resultAnalyse = resultAnalyse;
        this.statusRv = statusRv;
    }

    public Long getIdRendezVous() {
        return idRendezVous;
    }

    public void setIdRendezVous(Long idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public String getDateRv() {
        return dateRv;
    }

    public void setDateRv(String dateRv) {
        this.dateRv = dateRv;
    }

    public String getObjetRv() {
        return objetRv;
    }

    public void setObjetRv(String objetRv) {
        this.objetRv = objetRv;
    }

    public String getResultAnalyse() {
        return resultAnalyse;
    }

    public void setResultAnalyse(String resultAnalyse) {
        this.resultAnalyse = resultAnalyse;
    }

    public Boolean getStatusRv() {
        return statusRv;
    }

    public void setStatusRv(Boolean statusRv) {
        this.statusRv = statusRv;
    }

    @Override
    public String toString() {
        return "RendezVous{" +
                "idRendezVous=" + idRendezVous +
                ", appUser=" + appUser +
                ", structure=" + structure +
                ", dateRv='" + dateRv + '\'' +
                ", objetRv='" + objetRv + '\'' +
                ", resultAnalyse='" + resultAnalyse + '\'' +
                ", statusRv=" + statusRv +
                '}';
    }
}
