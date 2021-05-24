package com.mitramandiri.backend.controllers;

import com.mitramandiri.backend.configs.PathNotFoundException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultErrorController implements ErrorController {

    @GetMapping("/error")
    public void handleError() {
        throw new PathNotFoundException();
    }

}