package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotNull;

/**
 * @author Mateus Dantas
 */
public record AprovacaoAdocaoDTO(@NotNull Long idAdocao) {}
