package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Mateus Dantas
 */
public record SolicitacaoAdocaoDTO(@NotNull Long idPet, @NotNull Long idTutor, @NotBlank String motivo) {}
