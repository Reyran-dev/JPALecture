package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS") //Table명 강제로 변경
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    //외래키 값을 Mapping 해서 그대로 가져오지 말고 아래처럼 객체로 가져오자.
//    @Column(name = "MEMBER_ID")
//    private Long MemberId;

    @ManyToOne // Order의 입장에서 Member와의 관계(한명의 회원이 여러개의 주문을 생성)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    // 주문서를 중심으로 어떤 Item이 필요한지 파악하기 위한 양방향 연관관계
    @OneToMany(mappedBy = "order") // 연관관계의 주인은 OrderItem의 order 객체
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    ////////////// Getter Setter /////////////////

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getMemberId() {
//        return MemberId;
//    }
//
//    public void setMemberId(Long memberId) {
//        MemberId = memberId;
//    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) { this.status = status; }
}
