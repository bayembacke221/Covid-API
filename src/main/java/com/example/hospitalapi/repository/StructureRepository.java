package com.example.hospitalapi.repository;

import com.example.hospitalapi.appuser.AppUser;
import com.example.hospitalapi.models.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StructureRepository extends JpaRepository<Structure,Integer> {

   Structure findById(int id);
}
