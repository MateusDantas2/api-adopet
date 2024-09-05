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
public class PetAdocaoAndamentoValidation implements SolicitacaoAdocaoImpl {

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(SolicitacaoAdocaoDTO dto) {
        boolean petAdocaoEmAndamento = adocaoRepository.existsByIdPetAndStatus(dto.idPet(), AGUARDANDO_AVALIACAO);

        if (petAdocaoEmAndamento) {
            throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
        }
    }
}
