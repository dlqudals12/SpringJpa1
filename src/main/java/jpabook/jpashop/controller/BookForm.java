package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter
public class BookForm {

    private String name;
    private Long id;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;
}
