package com.example.hospitalapi.models;

import javax.persistence.*;
import java.io.Serializable;

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
    Long idStructure;
    private int nomHopital;
    private int contact;
    private int adresseHopital;
    private Double latitude;
    private Double longitude;
    private int nbVaccinDispo;
    private int nbTestDisp;

    public Structure() {
    }

    public Structure(int nomHopital,
                     int contact,
                     int adresseHopital,
                     Double latitude,
                     Double longitude,
                     int nbVaccinDispo,
                     int nbTestDisp) {
        this.nomHopital = nomHopital;
        this.contact = contact;
        this.adresseHopital = adresseHopital;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nbVaccinDispo = nbVaccinDispo;
        this.nbTestDisp = nbTestDisp;
    }

    public Long getIdStructure() {
        return idStructure;
    }

    public void setIdStructure(Long idStructure) {
        this.idStructure = idStructure;
    }

    public int getNomHopital() {
        return nomHopital;
    }

    public void setNomHopital(int nomHopital) {
        this.nomHopital = nomHopital;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getAdresseHopital() {
        return adresseHopital;
    }

    public void setAdresseHopital(int adresseHopital) {
        this.adresseHopital = adresseHopital;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getNbVaccinDispo() {
        return nbVaccinDispo;
    }

    public void setNbVaccinDispo(int nbVaccinDispo) {
        this.nbVaccinDispo = nbVaccinDispo;
    }

    public int getNbTestDisp() {
        return nbTestDisp;
    }

    public void setNbTestDisp(int nbTestDisp) {
        this.nbTestDisp = nbTestDisp;
    }

    @Override
    public String toString() {
        return "Structure{" +
                "idStructure=" + idStructure +
                ", nomHopital=" + nomHopital +
                ", contact=" + contact +
                ", adresseHopital=" + adresseHopital +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", nbVaccinDispo=" + nbVaccinDispo +
                ", nbTestDisp=" + nbTestDisp +
                '}';
    }
}
