package br.com.orion.parlamentar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orion.parlamentar.model.Parlamentar;

@Repository
public interface ParlamentarRepository extends JpaRepository<Parlamentar, Integer> {

}
