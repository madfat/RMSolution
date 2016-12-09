package com.mitrais.rms.me.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "data_type")
    @NotNull
    private String dataType;

    @Column(name = "data_code")
    @NotNull
    private String dataCode;

    @Column(name = "data_desc")
    @NotNull
    private String dataDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }
}
