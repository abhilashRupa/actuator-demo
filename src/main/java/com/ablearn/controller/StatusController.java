package com.ablearn.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class StatusController {

  @GetMapping("/test")
  public String getStatus(@RequestParam String updatedStatus) {

    return "success";

  }

}
