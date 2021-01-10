package com.amy.dom.VO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class BookDto implements Serializable {
    private String name;
    private String describe;
    private int amount;
    private double price;
}
