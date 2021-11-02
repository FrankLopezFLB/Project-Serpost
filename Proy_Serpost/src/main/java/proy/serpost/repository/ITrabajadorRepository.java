package proy.serpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proy.serpost.model.Trabajador;


@Repository
public interface ITrabajadorRepository extends JpaRepository<Trabajador,Integer> {

}
