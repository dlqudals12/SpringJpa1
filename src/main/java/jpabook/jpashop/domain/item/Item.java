package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //Book, Album, Movie를 한 테이블에 다 때려박음
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
// abstract --> 추상 클래스
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    // 비지니스 로직

    //stock(제고) 증가
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int reststock = this.stockQuantity - quantity;
        if(reststock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = reststock;
    }



}
