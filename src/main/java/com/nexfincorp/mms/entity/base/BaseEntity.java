package com.nexfincorp.mms.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
    value = {"createdDt", "updatedDt"},
    allowGetters = true
)
public class BaseEntity implements Serializable {

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  @CreatedDate
  private Date createdDt;

  @Column
  @CreatedBy
  private Long createdBy;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  @LastModifiedDate
  private Date updatedDt;

  @Column
  @LastModifiedBy
  private Long updatedBy;

}

