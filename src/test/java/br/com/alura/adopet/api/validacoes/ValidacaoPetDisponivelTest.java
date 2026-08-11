package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidacaoPetDisponivelTest {

    @Test
    void deveriaPermitirSolicitacaoDeAdocaoPet() {

        //Arrange
        SolicitacaoAdocaoDTO dto = new SolicitacaoAdocaoDTO(
                7l,
                2l,
                "Motivo para Teste"
        );

        ValidacaoPetDisponivel validacao = new ValidacaoPetDisponivel();

        //ACT
        validacao.validar(dto);

        //ASSERT + ACT
        Assertions.assertDoesNotThrow(() -> validacao.validar(dto));
    }
}