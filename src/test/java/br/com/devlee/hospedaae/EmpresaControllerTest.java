package br.com.devlee.hospedaae;
import br.com.devlee.hospedaae.model.EmpresaModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EmpresaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final String empresaJson = "{ \"nomeFantasia\": \"Hospeda Teste\", \"cnpj\": \"99.999.999/0001-99\" }";

    @Test
    void shouldCreateNewEmpresa() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/empresas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(empresaJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nomeFantasia").value("Hospeda Teste"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cnpj").value("99.999.999/0001-99"));
    }

    @Test
    void shouldReturnAllEmpresas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/empresas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(empresaJson));

        mockMvc.perform(MockMvcRequestBuilders.get("/empresas"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nomeFantasia").value("Hospeda Teste"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cnpj").value("99.999.999/0001-99"));
    }

    @Test
    void shouldUpdateEmpresa() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.post("/empresas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(empresaJson))
                .andReturn().getResponse().getContentAsString();

        EmpresaModel createdEmpresa = objectMapper.readValue(response, EmpresaModel.class);

        String updatedEmpresaJson = "{ \"nomeFantasia\": \"Hospeda Atualizada\", \"cnpj\": \"99.999.999/0001-99\" }";

        mockMvc.perform(MockMvcRequestBuilders.put("/empresas/{id}", createdEmpresa.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedEmpresaJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(createdEmpresa.getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nomeFantasia").value("Hospeda Atualizada"));
    }

    @Test
    void shouldDeleteEmpresa() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.post("/empresas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(empresaJson))
                .andReturn().getResponse().getContentAsString();

        EmpresaModel createdEmpresa = objectMapper.readValue(response, EmpresaModel.class);

        mockMvc.perform(MockMvcRequestBuilders.delete("/empresas/{id}", createdEmpresa.getId()))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
