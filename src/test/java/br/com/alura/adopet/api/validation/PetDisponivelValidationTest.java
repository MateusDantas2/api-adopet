package br.com.alura.adopet.api.validation;

import br.com.alura.adopet.api.domain.entity.Pet;
import br.com.alura.adopet.api.domain.repository.PetRepository;
import br.com.alura.adopet.api.dto.adocao.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetDisponivelValidationTest {

    @InjectMocks
    private PetDisponivelValidation validation;
    @Mock
    private PetRepository petRepository;
    @Mock
    private Pet pet;
    @Mock
    private SolicitacaoAdocaoDTO dto;

    @Test
    void pemitirSolicitacaoAdocaoPet() {

        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(false);

        Assertions.assertDoesNotThrow(() -> validation.validar(dto));
    }

    @Test
    void naoPemitirSolicitacaoAdocaoPet() {

        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(true);

        Assertions.assertThrows(ValidacaoException.class, () -> validation.validar(dto));
    }
}