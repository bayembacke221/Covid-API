package com.example.hospitalapi.repository;

import com.example.hospitalapi.models.RendezVous;
import com.example.hospitalapi.models.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous,Integer> {

    @Query("SELECT R FROM RendezVous R WHERE R.appUser.id =?1")
    List<RendezVous> findRendezVousByUser(int id);
}
