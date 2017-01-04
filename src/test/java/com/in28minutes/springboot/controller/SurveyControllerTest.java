package com.in28minutes.springboot.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.springboot.model.Question;
import com.in28minutes.springboot.service.SurveyService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SurveyController.class, secure = false)
public class SurveyControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SurveyService service;

    @Test
    public void retrieveQuestion() throws Exception {

        Question mockQuestion = new Question("Question1", "First Alphabet",
                "A", Arrays.asList("A", "B", "C", "D"));

        when(service.retrieveQuestion(anyString(), anyString())).thenReturn(
                mockQuestion);

        MvcResult result = mvc
                .perform(
                        MockMvcRequestBuilders.get(
                                "/surveys/Survey1/questions/1").accept(
                                        MediaType.APPLICATION_JSON))
                                        .andExpect(status().isOk()).andReturn();

        String expected = "{id:Question1,description:First Alphabet,correctAnswer:A,options:[A,B,C,D]}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

    }

    @Test
    public void retrieveSurveyQuestions() throws Exception {
        List<Question> mockList = Arrays.asList(
                new Question("Question1", "First Alphabet", "A", Arrays.asList(
                        "A", "B", "C", "D")),
                new Question("Question2", "Last Alphabet", "Z", Arrays.asList(
                        "A", "X", "Y", "Z")));

        when(service.retrieveQuestions(anyString())).thenReturn(mockList);

        MvcResult result = mvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/surveys/Survey1/questions").accept(
                                        MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        String expected = "["
                + "{id:Question1,description:First Alphabet,correctAnswer:A,options:[A,B,C,D]},"
                + "{id:Question2,description:Last Alphabet,correctAnswer:Z,options:[A,X,Y,Z]}"
                + "]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void createSurveyQuestion() throws Exception {
        Question mockQuestion = new Question("1", "Smallest Number", "1",
                Arrays.asList("1", "2", "3", "4"));

        String question = "{\"description\":\"Smallest Number\",\"correctAnswer\":\"1\",\"options\":[\"1\",\"2\",\"3\",\"4\"]}";

        when(service.addQuestion(anyString(), any(Question.class))).thenReturn(
                mockQuestion);

        mvc.perform(
                MockMvcRequestBuilders.post("/surveys/Survey1/questions")
                        .content(question)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(
                        header().string("location",
                                containsString("/surveys/Survey1/questions/1")));
    }
}