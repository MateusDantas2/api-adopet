package br.com.alura.adopet.api.domain.repository;

import br.com.alura.adopet.api.domain.entity.Adocao;
import br.com.alura.adopet.api.enumeration.StatusAdocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

    boolean existsByPetIdAndStatus(Long idPet, StatusAdocao status);

}
