package br.com.alura.adopet.api.validation;

import br.com.alura.adopet.api.domain.entity.Abrigo;
import br.com.alura.adopet.api.domain.entity.Pet;
import br.com.alura.adopet.api.dto.abrigo.CadastroAbrigoDTO;
import br.com.alura.adopet.api.dto.pet.CadastroPetDTO;
import br.com.alura.adopet.api.enumeration.ProbabilidadeAdocao;
import br.com.alura.adopet.api.enumeration.TipoPet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Mateus Dantas
 */
class CalculadoraProbabilidadeValidationTest {

    @Test
    void retornarProbabilidadeAltaParaPetComIdadeBaixaPesoBaixo() {
        Abrigo abrigo = new Abrigo(
                new CadastroAbrigoDTO(
                        "Abrigo feliz",
                        "8399654715",
                        "abrigofeliz@gmail.com"
                )
        );
        Pet pet = new Pet(
                new CadastroPetDTO(
                        TipoPet.GATO,
                        "Luna",
                        "Siames",
                        4,
                        "Cinza",
                        4.0f
                ), abrigo
        );
        CalculadoraProbabilidadeValidation calculadora = new CalculadoraProbabilidadeValidation();
        ProbabilidadeAdocao probalidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probalidade);
    }

    @Test
    void retornarProbabilidadeMediaParaPetComIdadeAltaPesoBaixo() {
        Abrigo abrigo = new Abrigo(
                new CadastroAbrigoDTO(
                        "Abrigo feliz",
                        "8399654715",
                        "abrigofeliz@gmail.com"
                )
        );
        Pet pet = new Pet(
                new CadastroPetDTO(
                        TipoPet.GATO,
                        "Luna",
                        "Siames",
                        15,
                        "Cinza",
                        4.0f
                ), abrigo
        );
        CalculadoraProbabilidadeValidation calculadora = new CalculadoraProbabilidadeValidation();
        ProbabilidadeAdocao probalidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probalidade);
    }

    @Test
    void retornarProbabilidadeBaixaParaPetComIdadeAltaPesoAlto() {
        Abrigo abrigo = new Abrigo(
                new CadastroAbrigoDTO(
                        "Abrigo feliz",
                        "8399654715",
                        "abrigofeliz@gmail.com"
                )
        );
        Pet pet = new Pet(
                new CadastroPetDTO(
                        TipoPet.GATO,
                        "Luna",
                        "Siames",
                        15,
                        "Cinza",
                        11.0f
                ), abrigo
        );
        CalculadoraProbabilidadeValidation calculadora = new CalculadoraProbabilidadeValidation();
        ProbabilidadeAdocao probalidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.BAIXA, probalidade);
    }
}