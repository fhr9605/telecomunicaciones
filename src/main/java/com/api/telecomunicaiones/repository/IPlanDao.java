package com.api.telecomunicaiones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import com.api.telecomunicaiones.modelo.Plan;

@Transactional
@Repository
public interface IPlanDao extends JpaRepository<Plan,Integer>{

    @Modifying
    @Query(value = "delete from planes as p  where p.id_plan=?", nativeQuery = true)
    public void deleteByIdString(String id);
}
