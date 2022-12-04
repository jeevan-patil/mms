package com.nexfincorp.mms.entity;

import com.nexfincorp.mms.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "mandate_request")
@EqualsAndHashCode(callSuper = false)
public class MandateRequest extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(unique = true)
  private String fileName;

  @Column
  private String status;

  @Column
  private Long version;

  public void setVersion(final Long version) {
    this.version = Objects.isNull(version) ? 1L : (version + 1);
  }
}
