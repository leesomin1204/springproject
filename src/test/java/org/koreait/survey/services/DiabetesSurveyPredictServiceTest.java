package org.koreait.survey.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.koreait.global.constants.Gender;
import org.koreait.survey.diabetes.constants.SmokingHistory;
import org.koreait.survey.diabetes.controllers.RequestDiabetesSurvey;
import org.koreait.survey.diabetes.services.DiabetesSurveyPredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DiabetesSurveyPredictServiceTest {
    @Autowired
    private DiabetesSurveyPredictService service;

    @Autowired
    private ObjectMapper om;

    @Test
    void test() throws Exception {
        String json = "[[0.0, 39.0, 0.0, 0.0, 1.0, 24.11, 3.5, 145.0], [1.0, 78.0, 0.0, 1.0, 5.0, 30.27, 5.7, 200.0], [1.0, 66.0, 0.0, 0.0, 4.0, 36.09, 3.5, 158.0], [0.0, 53.0, 0.0, 0.0, 1.0, 25.5, 6.5, 126.0], [1.0, 51.0, 0.0, 0.0, 4.0, 28.92, 6.0, 160.0]]";

        List<List<Number>> items = om.readValue(json, new TypeReference<>() {});

        List<Integer> results = service.process(items);
        System.out.println(results);
    }

    @Test
    void test2() {
        // List<Number> item = List.of(1, 39.0, 0.0, 0.0, 3, 24.11, 3.5, 130);
//        List<Number> item = List.of(1, 41, 0, 0, 0, 29.6, 8.2, 126);
//
//        boolean result = service.isDiabetes(item);
//        System.out.println(result);
        RequestDiabetesSurvey form = new RequestDiabetesSurvey();
        form.setGender(Gender.MALE);
        form.setAge(41);
        form.setHypertension(false);
        form.setHeartDisease(false);
        form.setSmokingHistory(SmokingHistory.EVER);
        form.setHeight(178.5);
        form.setWeight(120);
        form.setHbA1c(8.2);
        form.setBloodGlucoseLevel(126);

        boolean result = service.isDiabetes(form);
        System.out.println(result);
    }
}
