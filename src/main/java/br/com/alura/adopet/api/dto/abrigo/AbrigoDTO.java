package br.com.alura.adopet.api.dto.abrigo;

import br.com.alura.adopet.api.domain.entity.Abrigo;

public record AbrigoDTO(Long id, String nome) {

    public AbrigoDTO(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome());
    }

}
