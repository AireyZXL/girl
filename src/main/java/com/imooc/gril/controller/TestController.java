package com.imooc.gril.controller;

import com.imooc.gril.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class TestController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/say/{id}", method = {RequestMethod.GET})
    public String say(@PathVariable("id") Integer id) {
        return "id: " + id;
    }

    @RequestMapping(value = "/say", method = {RequestMethod.GET})
    public String sayParam(@RequestParam("id") Integer myId) {
        return "id: " + myId;
    }

    // @RequestMapping(value = "/saydef", method = {RequestMethod.GET})
    @GetMapping(value = "saydef")
    public String sayDefault(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id: " + myId;
    }
}
