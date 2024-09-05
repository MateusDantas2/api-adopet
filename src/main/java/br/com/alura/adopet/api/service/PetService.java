package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.pet.PetDTO;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mateus Dantas
 */
@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public List<PetDTO> listarTodosDisponiveis() {
        return petRepository.findAllByAdotadoFalse()
                .stream()
                .map(PetDTO::new)
                .toList();
    }
}
