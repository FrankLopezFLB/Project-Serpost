package proy.serpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proy.serpost.model.Menu;
@Repository
public interface IMenuRepository extends JpaRepository<Menu,Integer> {

}
