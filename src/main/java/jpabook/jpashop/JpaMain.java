package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // Entity Manager Factory는 Build시, 한번만 생성한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml에 있는 name값

        // Entity Manager는 Query 실행시, Business단위로 생성한다.
        EntityManager em = emf.createEntityManager();

        // Transaction 생성
        EntityTransaction tx = em.getTransaction();
        // Transaction 실행
        tx.begin();
        
        try {
            // JPA의 핵심은 단방향 연관관계 Mapping를 잘 설정하는 것이 Best

            // 1. 양방향 연관관계 Mapping 적용시(주로 개발상의 편의로 양방향 연관관계를 작성한다.)
//            Order order = new Order();
//            order.addOrderItem(new OrderItem());
            
            // 2. 양방향 연관관계 Mapping 미적용시(이런식으로 개발해도 구현 자체는 문제가 없다.)
            Order order = new Order();
            em.persist(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);

            em.persist(orderItem);


            //DB Update및 Insert 시점은 Commit 실행시 수행
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            // 사용이 끝난 Manager 삭제
            em.close();
        }

        // 사용이 끝난 Manager Factory 삭제
        emf.close();
    }
}
