package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.tutor.AtualizacaoTutorDTO;
import br.com.alura.adopet.api.dto.tutor.CadastroTutorDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.domain.entity.Tutor;
import br.com.alura.adopet.api.domain.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public void cadastrar(CadastroTutorDTO dto) {
        boolean jaCadastrado = repository.existsByTelefoneOrEmail(dto.telefone(), dto.email());

        if (jaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");
        }

        repository.save(new Tutor(dto));
    }

    public void atualizar(AtualizacaoTutorDTO dto) {
        Tutor tutor = repository.getReferenceById(dto.id());
        tutor.atualizarDados(dto);
    }

}
