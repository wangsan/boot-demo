package com.example.demo.customer;

import javax.persistence.Access;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

/**
 * 提供默认的实现
 */
@Data
@MappedSuperclass
public abstract class DefaultIdDO implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(value = javax.persistence.AccessType.PROPERTY)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

