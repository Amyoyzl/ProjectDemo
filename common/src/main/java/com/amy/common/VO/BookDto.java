package com.amy.common.VO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookDto {
    private String name;
    private String describe;
    private int amount;
    private double price;
}
