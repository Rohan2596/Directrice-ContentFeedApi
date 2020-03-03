package com.directrice.contentfeed.controller;

import com.directrice.contentfeed.dto.AddContentFeedDTO;
import com.directrice.contentfeed.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/directrice/content")
public class ContentFeedController {

    @PostMapping("/add")
    public ResponseEntity<Response> addContent(@RequestBody @Valid AddContentFeedDTO addContentFeedDTO,
                                               BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity<Response>(new Response(bindingResult.getAllErrors().get(0).getDefaultMessage(),""),
                    HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Response>(new Response("Content Added Successfully.", ""),
                HttpStatus.CREATED);
    }


}
