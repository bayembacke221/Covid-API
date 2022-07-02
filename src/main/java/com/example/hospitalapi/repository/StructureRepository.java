package com.example.hospitalapi.repository;

import com.example.hospitalapi.appuser.AppUser;
import com.example.hospitalapi.models.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StructureRepository extends JpaRepository<Structure,Integer> {

   Structure findById(int id);

   @Query("SELECT s from Structure s where s.nomHopital LIKE %?1%")
   public List<Structure> search(String keyword);
}
