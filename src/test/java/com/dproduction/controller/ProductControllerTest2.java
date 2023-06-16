package com.dproduction.controller;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dproduction.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
class ProductControllerTest2 {

    @Autowired private MockMvc mockMvc;

    @Autowired private WebApplicationContext context;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocumentation) {
        this.mockMvc =
                MockMvcBuilders.webAppContextSetup(context)
                        .apply(
                                MockMvcRestDocumentation.documentationConfiguration(
                                        restDocumentation))
                        .build();
    }

    @Test
    void givenProducts_GetProductsEndpoint_ShouldReturnProductsList() throws Exception {
        ResultActions result =
                mockMvc.perform(get("/v1/products"))
                        .andExpect(status().isOk())
                        .andDo(document("get-products"));

        // Additional assertions
        // ...
    }

    @Test
    void givenANewProduct_PostProductsEndpoint_ShouldAddANewProduct() throws Exception {
        ProductDto productSamsung =
                new ProductDto("Sony 4K TV 75", 3049.99, "Sony LED 4k Smart TV");

        ResultActions result =
                mockMvc.perform(
                                post("/v1/products")
                                        .contentType("application/json")
                                        .content(productSamsung.toString()))
                        .andExpect(status().isCreated())
                        .andDo(document("post-products"));

        // Additional assertions
        // ...
    }
}
