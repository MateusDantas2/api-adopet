package br.com.alura.adopet.api.validation;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.api.validation.impl.SolicitacaoAdocaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.com.alura.adopet.api.model.StatusAdocao.AGUARDANDO_AVALIACAO;

/**
 * @author Mateus Dantas
 */
@Component
public class PetAdocaoAndamentoValidation implements SolicitacaoAdocaoImpl {

    @Autowired
    private AdocaoRepository adocaoRepository;
    @Autowired
    private PetRepository petRepository;

    public void validar(SolicitacaoAdocaoDTO dto) {
        List<Adocao> adocoes = adocaoRepository.findAll();
        Pet pet = petRepository.getReferenceById(dto.idPet());
        for (Adocao a : adocoes) {
            if (a.getPet() == pet && a.getStatus() == AGUARDANDO_AVALIACAO) {
                throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
            }
        }
    }
}
