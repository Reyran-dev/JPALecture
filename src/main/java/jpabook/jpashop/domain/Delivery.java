package jpabook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    private long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;

    // Order와 1:1 Mapping
    @OneToOne(mappedBy = "delivery")
    private Order order;
}
