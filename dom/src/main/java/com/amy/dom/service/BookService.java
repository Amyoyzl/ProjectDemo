package com.amy.dom.service;

import com.amy.dom.VO.BookDto;
import com.amy.dom.VO.BookPayload;
import com.amy.dom.constant.MessageConstant;
import com.amy.dom.message.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;

@Service
@Slf4j
public class BookService {

    private final Sender<BookPayload> sender;

    public BookService(Sender<BookPayload> sender) {
        this.sender = sender;
    }

    public String createBook(BookDto bookDto) {
        // todo: convert Dto to model, then save
        String bookId = DigestUtils.md5DigestAsHex(bookDto.getName().getBytes());
        BookPayload bookPayload = BookPayload.builder().bookId(bookId).status(MessageConstant.STATUS_CREAT)
                .timeStamp(LocalDateTime.now()).build();
        sender.send("demo.book.update", bookPayload);
        log.info("Send message {}", bookPayload);
        return bookId;
    }

    public void updateBook(String id, BookDto bookDto) {
        // todo: use id to found book from db, then update book
        log.info("update book {}", bookDto);
        BookPayload bookPayload = BookPayload.builder().bookId(id).status(MessageConstant.STATUS_UPDATE)
                .timeStamp(LocalDateTime.now()).build();
        sender.send("demo.book.update.work", bookPayload);
        log.info("Send message {}", bookPayload);
    }

    public void updateBookPrice(String id, double price) {
        // todo: use id to found book from db, then update book price
        log.info("update book price: " + price);
        BookPayload bookPayload = BookPayload.builder().bookId(id).status(MessageConstant.STATUS_UPDATE)
                .timeStamp(LocalDateTime.now()).build();
        sender.publish("ex_book.publish", bookPayload);
        log.info("publish message {}", bookPayload);
    }
}
