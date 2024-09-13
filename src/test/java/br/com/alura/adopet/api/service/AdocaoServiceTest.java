package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.domain.entity.Abrigo;
import br.com.alura.adopet.api.domain.entity.Adocao;
import br.com.alura.adopet.api.domain.entity.Pet;
import br.com.alura.adopet.api.domain.entity.Tutor;
import br.com.alura.adopet.api.domain.repository.AdocaoRepository;
import br.com.alura.adopet.api.domain.repository.PetRepository;
import br.com.alura.adopet.api.domain.repository.TutorRepository;
import br.com.alura.adopet.api.dto.adocao.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.impl.EmailService;
import br.com.alura.adopet.api.impl.SolicitacaoAdocaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AdocaoServiceTest {

    @InjectMocks
    private AdocaoService adocaoService;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private TutorRepository tutorRepository;

    @Mock
    private EmailService emailService;

    @Spy
    private List<SolicitacaoAdocaoImpl> validacoes = new ArrayList<>();

    @Mock
    private SolicitacaoAdocaoImpl validador1;

    @Mock
    private SolicitacaoAdocaoImpl validador2;

    @Mock
    private Pet pet;

    @Mock
    private Tutor tutor;

    @Mock
    private Abrigo abrigo;

    private SolicitacaoAdocaoDTO dto;

    @Captor
    private ArgumentCaptor<Adocao> adocaoCaptor;

    @Test
    void salvarSolicitacaoAdocaoTest() {
        //ARRANGE
        this.dto = new SolicitacaoAdocaoDTO(10l, 20l, "motivo qualquer");
        given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
        given(pet.getAbrigo()).willReturn(abrigo);

        //ACT
        adocaoService.solicitar(dto);

        //ASSERT
        then(adocaoRepository).should().save(adocaoCaptor.capture());
        Adocao adocaoSalva = adocaoCaptor.getValue();
        Assertions.assertEquals(pet, adocaoSalva.getPet());
        Assertions.assertEquals(tutor, adocaoSalva.getTutor());
        Assertions.assertEquals(dto.motivo(), adocaoSalva.getMotivo());
    }

    @Test
    void chamarValidadoresAdocaoAoSolicitarTest() {
        //ARRANGE
        this.dto = new SolicitacaoAdocaoDTO(10l, 20l, "motivo qualquer");
        given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
        given(pet.getAbrigo()).willReturn(abrigo);
        validacoes.add(validador1);
        validacoes.add(validador2);

        //ACT
        adocaoService.solicitar(dto);

        //ASSERT
        then(validador1).should().validar(dto);
        then(validador2).should().validar(dto);
    }
}