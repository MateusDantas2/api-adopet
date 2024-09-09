package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.pet.CadastroPetDTO;
import br.com.alura.adopet.api.dto.pet.PetDTO;
import br.com.alura.adopet.api.domain.entity.Abrigo;
import br.com.alura.adopet.api.domain.entity.Pet;
import br.com.alura.adopet.api.domain.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<PetDTO> buscarPetsDisponiveis() {
        return repository
                .findAllByAdotadoFalse()
                .stream()
                .map(PetDTO::new)
                .toList();
    }

    public void cadastrarPet(Abrigo abrigo, CadastroPetDTO dto) {
        repository.save(new Pet(dto, abrigo));
    }
}
