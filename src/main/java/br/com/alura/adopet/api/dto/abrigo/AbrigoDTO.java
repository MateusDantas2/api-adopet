package br.com.alura.adopet.api.dto.abrigo;

import br.com.alura.adopet.api.model.Abrigo;

/**
 * @author Mateus Dantas
 */
public record AbrigoDTO(Long id, String nome) {
    public AbrigoDTO(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome());
    }
}
