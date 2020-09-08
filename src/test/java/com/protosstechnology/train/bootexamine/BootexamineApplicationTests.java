package com.protosstechnology.train.bootexamine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.protosstechnology.train.bootexamine.entity.Document;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
class BootexamineApplicationTests {

//	@Test
//	void contextLoads() {
//	}

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Before
    public void setUp() throws Exception{}

    @After
    public void tearDown() throws Exception{}

    @Test
    public void addDocument_thenOk() throws Exception{

        Document doc = new Document();
        doc.setId(1);
        doc.setDocumentNumber("DocumentNumber");
        doc.setDescription("Description");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(doc);

        mockMvc.perform(post("/document").contentType(APPLICATION_JSON_UTF8).content(requestJson))
                      .andExpect(status().isOk());

    }

    @Test
    public void getDocument_thenOk() throws Exception{

        Document doc = new Document();
        doc.setId(1);
        doc.setDocumentNumber("DocumentNumber");
        doc.setDescription("Description");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(doc);

        mockMvc.perform(post("/document").contentType(APPLICATION_JSON_UTF8).content(requestJson));

        mockMvc.perform(get("/document/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"documentNumber\": \"DocumentNumber\",\"description\": \"Description\"}"));

    }

    @Test
    public void putDocument_thenOk() throws Exception{

        Document doc = new Document();
        doc.setId(1);
        doc.setDocumentNumber("DocumentNumber");
        doc.setDescription("Description");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(doc);

        mockMvc.perform(post("/document").contentType(APPLICATION_JSON_UTF8).content(requestJson));

        doc = new Document();
        doc.setDocumentNumber("DocumentNumber22");
        doc.setDescription("Description22");
        requestJson=ow.writeValueAsString(doc);

        mockMvc.perform(put("/document/1").contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"documentNumber\": \"DocumentNumber22\",\"description\": \"Description22\"}"));

    }

    @Test
    public void deleteDocument_thenOk() throws Exception{

        Document doc = new Document();
        doc.setId(1);
        doc.setDocumentNumber("DocumentNumber");
        doc.setDescription("Description");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(doc);

        mockMvc.perform(post("/document").contentType(APPLICATION_JSON_UTF8).content(requestJson));

        mockMvc.perform(delete("/document/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Delete Document{1} Successful"));

    }

}
