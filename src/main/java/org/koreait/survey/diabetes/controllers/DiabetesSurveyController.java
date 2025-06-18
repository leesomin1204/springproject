package org.koreait.survey.diabetes.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.koreait.global.libs.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/survey/diabetes")
@SessionAttributes("requestDiabetesSurvey")
public class DiabetesSurveyController {

    private final Utils utils;

    @ModelAttribute("addCss")
    public List<String> addCss() {
        return List.of("survey/diabetes/style");
    }

    @ModelAttribute("requestDiabetesSurvey")
    public RequestDiabetesSurvey requestDiabetesSurvey() {
        return new RequestDiabetesSurvey();
    }

    @GetMapping("/step1")
    public String step1(@ModelAttribute RequestDiabetesSurvey form, Model model) {
        commonProcess("step", model);

        return utils.tpl("survey/diabetes/step1");
    }

    @PostMapping("/step2")
    public String step2(@Valid RequestDiabetesSurvey form, Errors errors, Model model) {
        commonProcess("step", model);

        if (errors.hasErrors()) {
            return utils.tpl("survey/diabetes/step1");
        }

        return utils.tpl("survey/diabetes/step2");
    }


    /**
     * 설문 저장 및 결과 처리
     *
     * @param form
     * @param errors
     * @return
     */
    @PostMapping("/process")
    public String process(@Valid RequestDiabetesSurvey form, Errors errors, Model model) {
        commonProcess("step", model);

        if (errors.hasErrors()) {
            return utils.tpl("survey/diabetes/step2");
        }

        return "redirect:/survey/diabetes/result/설문번호";
    }


    /**
     * 설문 결과 보기
     *
     * @return
     */
    @GetMapping("/result/{seq}")
    public String result(@PathVariable("seq") Long seq, Model model) {
        commonProcess("result", model);

        return utils.tpl("survey/diabetes/result");
    }

    /**
     * 컨트롤러 공통 처리
     *
     * @param mode
     * @param model
     */
    private void commonProcess(String mode, Model model) {
        mode = StringUtils.hasText(mode) ? mode : "step";
        String pageTitle = "";
        if (mode.equals("step")) {
            pageTitle = utils.getMessage("당뇨_고위험군_테스트");

        } else if (mode.equals("result")) {
            pageTitle = utils.getMessage("당뇨_고위험군_테스트_결과");
        }

        model.addAttribute("pageTitle", pageTitle);
    }
}