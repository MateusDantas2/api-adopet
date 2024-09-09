package br.com.alura.adopet.api.domain.repository;

import br.com.alura.adopet.api.domain.entity.Abrigo;
import br.com.alura.adopet.api.domain.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findAllByAdotadoFalse();

    List<Pet> findByAbrigo(Abrigo abrigo);
}
