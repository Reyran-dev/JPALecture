package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends BaseEntity {
    @Id  @GeneratedValue
    private Long id;

    private String name;

    // Self로 양방향을 잡는다
    // Many to one과 One to One은 기본 fetch가 즉시로딩이므로 지연로딩으로 변경하는것을 권장
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    // Item과 다대다 관계
    @ManyToMany
    // 실제 Category와 Item사이에 중간 Table이 없으나, 존재하는 것 처럼 처리 
    @JoinTable(name = "CATEGORY_ITEM"
            , joinColumns = @JoinColumn(name = "CATEGORY_ID")
            , inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<Item> items = new ArrayList<>();
}
