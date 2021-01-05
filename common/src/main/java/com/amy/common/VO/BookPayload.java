package com.amy.common.VO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BookPayload {
    private String bookId;
    private String status;
    private LocalDateTime timeStamp;
}
