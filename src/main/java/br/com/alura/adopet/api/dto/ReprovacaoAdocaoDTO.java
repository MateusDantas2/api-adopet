package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Mateus Dantas
 */
public record ReprovacaoAdocaoDTO(@NotNull Long idAdocao, @NotBlank String justificativa) {}
