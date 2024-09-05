package br.com.alura.adopet.api.validation;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.validation.impl.SolicitacaoAdocaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.com.alura.adopet.api.model.StatusAdocao.AGUARDANDO_AVALIACAO;

/**
 * @author Mateus Dantas
 */
@Component
public class TutorAdocaoAndamentoValidation implements SolicitacaoAdocaoImpl {

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(SolicitacaoAdocaoDTO dto) {
        boolean tutorAdocaoEmAndamento = adocaoRepository.existsByIdTutorAndStatus(dto.idTutor(), AGUARDANDO_AVALIACAO);
        if (tutorAdocaoEmAndamento) {
            throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
        }
    }
}
