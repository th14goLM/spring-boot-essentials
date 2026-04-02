package br.com.thiago.spring_boot_essentials.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hello")
public class HelloWorldController {

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String get1(@PathVariable("id") String id) {
        return "Hello World " + id;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String get2(@RequestParam(value = "name", required = true) String name) {
        return "Hello World " + name;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody String name) {
        return "Hello World " + name;
    }
}