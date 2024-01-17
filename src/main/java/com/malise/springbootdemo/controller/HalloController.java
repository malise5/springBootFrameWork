package com.malise.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloController {

  @GetMapping("/")
  public String helloWorld() {
    return "Welcome to Daily Code Buffer!";
  }

}
 