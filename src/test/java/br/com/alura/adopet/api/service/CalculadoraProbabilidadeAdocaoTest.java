package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroAbrigoDTO;
import br.com.alura.adopet.api.dto.CadastroPetDTO;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CalculadoraProbabilidadeAdocaoTest {

    @Test
    void deveriaRetornarProbabilidadeAltaParaPetComPesoBaixoEIdadeBaixa() {
        //idade 4 anos e 4kg - Alta

        //PADRÃO ARRANGE
        Abrigo abrigo = new Abrigo(new CadastroAbrigoDTO(
                "Abrigo Feliz",
                "949999999",
                "abrigoFeliz@email.com.br"
        ));

        Pet pet = new Pet(new CadastroPetDTO(
                TipoPet.GATO,
                "Miau",
                "Siames",
                4,
                "Cinza",
                4.0f,
                false
        ), abrigo);

        CalculadoraProbabilidadeAdocaoService calculadora = new CalculadoraProbabilidadeAdocaoService();

        //ACT
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        //ASSERT
        Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
    }

    @Test
    void deveriaRetornarProbabilidadeMediaParaPetComPesoBaixoEIdadeAvancada() {
        //idade 15 anos e 4kg - Media

        Abrigo abrigo = new Abrigo(new CadastroAbrigoDTO(
                "Abrigo Feliz",
                "949999999",
                "abrigoFeliz@email.com.br"
        ));

        Pet pet = new Pet(new CadastroPetDTO(
                TipoPet.GATO,
                "Miau",
                "Siames",
                15,
                "Cinza",
                4.0f,
                false
        ), abrigo);

        CalculadoraProbabilidadeAdocaoService calculadora = new CalculadoraProbabilidadeAdocaoService();
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
    }
}