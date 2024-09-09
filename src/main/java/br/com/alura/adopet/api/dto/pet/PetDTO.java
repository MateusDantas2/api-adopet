package br.com.alura.adopet.api.dto.pet;

import br.com.alura.adopet.api.domain.entity.Pet;
import br.com.alura.adopet.api.enumeration.TipoPet;

public record PetDTO(Long id, TipoPet tipo, String nome, String raca, Integer idade) {

    public PetDTO(Pet pet) {
        this(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade());
    }

}
