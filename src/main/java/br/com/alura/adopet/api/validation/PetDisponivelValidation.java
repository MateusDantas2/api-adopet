package br.com.alura.adopet.api.validation;

import br.com.alura.adopet.api.dto.adocao.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.domain.entity.Pet;
import br.com.alura.adopet.api.domain.repository.PetRepository;
import br.com.alura.adopet.api.impl.SolicitacaoAdocaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetDisponivelValidation implements SolicitacaoAdocaoImpl {

    @Autowired
    private PetRepository petRepository;

    public void validar(SolicitacaoAdocaoDTO dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());
        if (pet.getAdotado()) {
            throw new ValidacaoException("Pet já foi adotado!");
        }
    }
}
