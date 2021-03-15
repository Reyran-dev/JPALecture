package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    private long id;

    private DeliveryStatus status;

    @Embedded
    private Address address;

    // 값타입 사용으로 주석 처리
//    private String city;
//    private String street;
//    private String zipcode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    // 값 타입 사용을 위한 Getter Setter
    public void setAddress(Address address) {
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // Order와 1:1 Mapping
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
}
