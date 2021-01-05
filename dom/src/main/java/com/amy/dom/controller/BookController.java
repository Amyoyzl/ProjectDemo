package com.amy.dom.controller;

import com.amy.common.VO.BookDto;
import com.amy.dom.service.BookService;
import com.amy.common.VO.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BookController {

    private BookService userService;

    public BookController(BookService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Response createUser(@RequestBody BookDto userDto) {
        return Response.create(userService.createUser(userDto));
    }
}
