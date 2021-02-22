package jpabook.jpashop;

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
