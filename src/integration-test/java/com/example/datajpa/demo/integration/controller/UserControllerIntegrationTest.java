package com.example.datajpa.demo.integration.controller;

import com.example.datajpa.demo.integration.IntegrationTest;
import com.example.datajpa.demo.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class UserControllerIntegrationTest extends IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void checkUserExsit_whenCall_ThenSuccess() throws Exception {
        doReturn(true).when(userService).findUser("test");

        MvcResult mvcResult = mockMvc.perform(get("/user/info/test"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        String isFoundUser = mvcResult.getResponse().getContentAsString();
        assertTrue(Boolean.valueOf(isFoundUser));
    }
}
