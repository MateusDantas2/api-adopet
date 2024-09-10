package br.com.alura.adopet.api.validation;

import br.com.alura.adopet.api.dto.adocao.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.enumeration.StatusAdocao;
import br.com.alura.adopet.api.domain.repository.AdocaoRepository;
import br.com.alura.adopet.api.impl.SolicitacaoAdocaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetAdocaoImplAndamentoValidation implements SolicitacaoAdocaoImpl {

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(SolicitacaoAdocaoDTO dto) {
        boolean petTemAdocaoEmAndamento = adocaoRepository
                .existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO);

        if (petTemAdocaoEmAndamento) {
            throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
        }
    }

}
