package com.mitrais.rms.me;

import com.mitrais.rms.EmployeeManageApplication;
import com.mitrais.rms.me.entity.Employee;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.iterableWithSize;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EmployeeManageApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryTest {

    @SuppressWarnings("rawtypes")
    private HttpMessageConverter mappingJackson2HttpMessageConverter;
    private MediaType contentType = new MediaType(MediaTypes.HAL_JSON.getType(), MediaTypes.HAL_JSON.getSubtype(), Charset.forName("utf8"));
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {
        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().
                filter(converter -> converter instanceof MappingJackson2HttpMessageConverter).
                findAny().get();
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAll() throws Exception {
        String name = "Thuat Nguyen";

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$['_embedded']['employees']", iterableWithSize(2)))
                .andExpect(jsonPath("$['_embedded']['employees'][0]['name']", containsString(name)));
    }

    @Test
    public void findByEmail() throws Exception {
        String email = "nqt289@gmail.com";

        mockMvc.perform(get("/employees/search/findByEmail?email=" + email))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$['_embedded']['employees']", iterableWithSize(1)))
                .andExpect(jsonPath("$['_embedded']['employees'][0]['email']", containsString(email)));
    }

}
