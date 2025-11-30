package com.louazri.webapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value=Exception.class)
    public ModelAndView exceptionHandler( Exception e){
        ModelAndView errorpage = new ModelAndView();
        errorpage.setViewName("error");
        errorpage.addObject("errormsg",e.getMessage());
        return errorpage;
    }

}
