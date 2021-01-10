package com.amy.dom.controller;

import com.amy.dom.VO.BookDto;
import com.amy.dom.VO.Response;
import com.amy.dom.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService userService) {
        this.bookService = userService;
    }

    @PostMapping
    public Response createBook(@RequestBody BookDto bookDto) {
        return Response.create(bookService.createBook(bookDto));
    }

    @PutMapping("/{id}")
    public Response updateBook(@PathVariable String id, @RequestBody BookDto bookDto) {
        bookService.updateBook(id, bookDto);
        return Response.update(id);
    }

    @PutMapping("/{id}/price")
    public Response updateBook(@PathVariable String id, @RequestParam double price) {
        bookService.updateBookPrice(id, price);
        return Response.update(id);
    }
}
