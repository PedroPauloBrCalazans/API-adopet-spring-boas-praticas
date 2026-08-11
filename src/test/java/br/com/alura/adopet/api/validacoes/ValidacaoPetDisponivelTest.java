package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) //para o mockito interceptar essa classe, e o mock que vai ler os atributos etc
class ValidacaoPetDisponivelTest {

    @InjectMocks
    private ValidacaoPetDisponivel validacao;

    @Mock
    private PetRepository petRepository;

    @Test
    void deveriaPermitirSolicitacaoDeAdocaoPet() {

        //Arrange
        SolicitacaoAdocaoDTO dto = new SolicitacaoAdocaoDTO(
                7l,
                2l,
                "Motivo para Teste"
        );

        //ASSERT + ACT
        Assertions.assertDoesNotThrow(() -> validacao.validar(dto));
    }
}