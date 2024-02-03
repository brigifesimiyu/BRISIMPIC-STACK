package com.example.demo.Details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Details")

public class DetailController {
    public final DetailService DetailService;

    @Autowired

    public DetailController(DetailService
    {
       this.DetailService = detailService;
    }


    @GetMapping
    private List<Details> getDetails(){
return DetailService.getDetails();
    }
}