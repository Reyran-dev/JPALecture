package jpabook.jpashop.domain;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // BaseEntity에 있는 요소들을 각 Class에서 공통으로 사용할 때
public class BaseEntity {
    // BaseEntity를 상속 시켜주면, 각 Class의 요소 + BaseEntity 요소가 된다.
    private String createdBy;
    private LocalDateTime createdDate;
    private String laseModifyBy;
    private LocalDateTime lastModifyDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLaseModifyBy() {
        return laseModifyBy;
    }

    public void setLaseModifyBy(String laseModifyBy) {
        this.laseModifyBy = laseModifyBy;
    }

    public LocalDateTime getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(LocalDateTime lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }
}
