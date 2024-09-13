package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.adocao.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.service.AdocaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AdocaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdocaoService adocaoService;

    @Autowired
    private JacksonTester<SolicitacaoAdocaoDTO> jsonDTO;

    @Test
    void devolverCodigo400SolicitacaoAdocaoErrosTeste() throws Exception {
        //ARRANGE
        String json = "{}";
        //ACT
        MockHttpServletResponse response = mockMvc.perform(
                post("/adocoes")
                        .content(json)
                        .contentType(APPLICATION_JSON)
        ).andReturn().getResponse();
        //ASSERT
        assertEquals(400, response.getStatus());
    }

    @Test
    void devolverCodigo200SolicitacaoAdocaoTeste() throws Exception {
        //ARRANGE
        SolicitacaoAdocaoDTO dtoJson = new SolicitacaoAdocaoDTO(1l, 1l, "Preciso de um pet");
        //ACT
        MockHttpServletResponse response = mockMvc.perform(
                post("/adocoes")
                        .content(jsonDTO.write(dtoJson).getJson())
                        .contentType(APPLICATION_JSON)
        ).andReturn().getResponse();
        //ASSERT
        assertEquals(200, response.getStatus());
    }
}