package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable // 값타입
public class Address {

    @Column(length = 10) // 값 타입 사용으로 공통적으로 관리 해야할 값들을 한번에 관리 가능
    private String city;
    @Column(length = 20)
    private String street;
    @Column(length = 5)
    private String zipcode;

    // 값 타입이 좋은 이유는 아래처럼 의미있는 비즈니스로직 메소드를 만들어서 사용 할 수 있다.
    private String fullAddress() {
        return getCity() + " " + getStreet() + " " + getZipcode();
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }
    // 객체 사용시 Setter는 막아두는것이 좋다(아예 없애거나, private선언)
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public void setZipcode(String zipcode) {
//        this.zipcode = zipcode;
//    }

    // 값타입 사용을 위한 Equals, HashCode 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        // field에 직접 접근하면 프록시 계산이 안되기 때문에,
        // 자동 완성으로 코드 구현시 'Use getters during code generation' 옵션 사용
        return Objects.equals(getCity(), address.getCity())
                && Objects.equals(getStreet(), address.getStreet())
                && Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
