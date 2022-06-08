package com.example.hospitalapi.repository;

import com.example.hospitalapi.models.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous,Integer> {

}
