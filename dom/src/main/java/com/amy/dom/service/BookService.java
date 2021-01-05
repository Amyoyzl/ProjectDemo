package com.amy.dom.service;

import com.amy.common.VO.BookDto;
import com.amy.common.VO.BookPayload;
import com.amy.common.constant.MessageConstant;
import com.amy.dom.Sender;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;

@Service
public class BookService {

    private final Sender<BookPayload> sender;

    public BookService(Sender<BookPayload> sender) {
        this.sender = sender;
    }

    public String createUser(BookDto bookDto) {
        // todo: convert Dto to model, then save
        String bookId = DigestUtils.md5DigestAsHex(bookDto.getName().getBytes());
        BookPayload bookPayload = BookPayload.builder().bookId(bookId).status(MessageConstant.STATUS_CREAT)
                .timeStamp(LocalDateTime.now()).build();
        sender.send("", "", bookPayload);
        return bookId;
    }

}
