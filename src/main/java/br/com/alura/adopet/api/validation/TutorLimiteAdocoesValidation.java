package br.com.alura.adopet.api.validation;

import br.com.alura.adopet.api.dto.adocao.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.validation.impl.SolicitacaoAdocaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.com.alura.adopet.api.model.StatusAdocao.APROVADO;

/**
 * @author Mateus Dantas
 */
@Component
public class TutorLimiteAdocoesValidation implements SolicitacaoAdocaoImpl {

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(SolicitacaoAdocaoDTO dto) {
        boolean tutorAdocaoEmAndamento = adocaoRepository.existsByIdTutorAndStatus(dto.idTutor(), APROVADO);
        int contador = 0;
        if (tutorAdocaoEmAndamento) {
            contador = contador + 1;
        }
        if (contador == 5) {
            throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
        }
    }
}
