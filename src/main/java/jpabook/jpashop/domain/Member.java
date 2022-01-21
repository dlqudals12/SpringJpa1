package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private long id;

    private String name;

    @Embedded //adress 내정함
    private Address address;

    @OneToMany(mappedBy = "member") //맵핑 되었음 여기서 변경 X
    private List<Order> oders = new ArrayList<>();
}
