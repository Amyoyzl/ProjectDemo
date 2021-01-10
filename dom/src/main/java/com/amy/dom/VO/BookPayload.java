package com.amy.dom.VO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BookPayload implements Serializable {
    private String bookId;
    private String status;
    private LocalDateTime timeStamp;
}
