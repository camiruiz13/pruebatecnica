package com.prueba.pruebatecnica.jpa;


import com.prueba.pruebatecnica.model.entity.RolDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<RolDAO, Long> {
}
