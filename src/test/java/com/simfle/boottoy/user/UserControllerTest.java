package com.simfle.boottoy.user;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //@Ignore
    @Test
    public void getUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(document("user"));
    }

    @Ignore
    @Test
    public void saveUser() throws Exception {
        String username = "USER04";
        String password = "USER04";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"username\": \"" + username + "\", " + "\"password\":\"" + password + "\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();

    }
}
