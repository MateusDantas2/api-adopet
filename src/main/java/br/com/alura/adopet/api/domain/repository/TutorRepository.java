package br.com.alura.adopet.api.domain.repository;

import br.com.alura.adopet.api.domain.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    boolean existsByTelefoneOrEmail(String telefone, String email);

}
