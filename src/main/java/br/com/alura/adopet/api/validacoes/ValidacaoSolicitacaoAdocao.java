package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.adocao.SolicitacaoAdocaoDTO;

public interface ValidacaoSolicitacaoAdocao {

    void validar(SolicitacaoAdocaoDTO dto);

}
