package com.nexfincorp.mms.entity;

import com.nexfincorp.mms.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "mandate")
@EqualsAndHashCode(callSuper = false)
public class Mandate extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, updatable = false)
  private String requestId;

  @Column(nullable = false, updatable = false)
  private String fromAccount;

  @Column(nullable = false, updatable = false)
  private String toAccount;

  @Column(nullable = false, updatable = false)
  private String frequency;

  @Temporal(TemporalType.DATE)
  private Date startDate;

  @Column(nullable = false)
  private String status;
}
