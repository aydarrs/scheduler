package com.tat.development.skills.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MainController.
 * Main application controller.
 * @author Aydar_Safiullin
 */
@Controller
@RequestMapping("/skills")
public class MainController {
    /**
     * @return application main page.
     */
    @GetMapping("")
    public String getMainPage() {
        return "MainPage";
    }
}
