package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Trabajador;


@Repository
public interface ITrabajadorRepository extends JpaRepository<Trabajador,Integer> {

}
