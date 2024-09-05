package br.com.alura.adopet.api.dto.adocao;

import jakarta.validation.constraints.NotNull;

/**
 * @author Mateus Dantas
 */
public record AprovacaoAdocaoDTO(@NotNull Long idAdocao) {}
