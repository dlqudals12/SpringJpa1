package jpabook.jpashop.repository;

import jpabook.jpashop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class OrderSearch {

    private String membername;
    private OrderStatus orderStatus; //주문상태[order cancel]
}
