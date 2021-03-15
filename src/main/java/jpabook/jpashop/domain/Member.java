package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    // 값타입 사용으로 주석 처리
//    private String city;
//    private String street;
//    private String zipcode;

    @Embedded // 값 타입임을 표시(안적어도 되긴 함)
    private Address address;

    // 사실 Member 객체에서 Order에 대한 연관관계는 대개 필요 없다.
    @OneToMany(mappedBy = "member") //연관관계의 주인은 Order객체의 member.. 연관관계의 주인은 외래키를 가진 객체를 주인으로 삼는다.
    private List<Order> orders = new ArrayList<>();

    ////////////// Getter Setter /////////////////

    // 값타입 사용을 위한 Getter Setter
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 값타입 사용으로 주석 처리
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getZipcode() {
//        return zipcode;
//    }
//
//    public void setZipcode(String zipcode) {
//        this.zipcode = zipcode;
//    }
}
