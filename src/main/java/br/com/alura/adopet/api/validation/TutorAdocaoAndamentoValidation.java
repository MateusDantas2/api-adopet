package br.com.alura.adopet.api.validation;

import br.com.alura.adopet.api.dto.adocao.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.domain.entity.Adocao;
import br.com.alura.adopet.api.enumeration.StatusAdocao;
import br.com.alura.adopet.api.domain.entity.Tutor;
import br.com.alura.adopet.api.domain.repository.AdocaoRepository;
import br.com.alura.adopet.api.domain.repository.TutorRepository;
import br.com.alura.adopet.api.impl.SolicitacaoAdocaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TutorAdocaoAndamentoValidation implements SolicitacaoAdocaoImpl {

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private TutorRepository tutorRepository;

    public void validar(SolicitacaoAdocaoDTO dto) {
        List<Adocao> adocoes = adocaoRepository.findAll();
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());
        for (Adocao a : adocoes) {
            if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
            }
        }
    }
}
