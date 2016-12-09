package com.mitrais.rms.me.entity;

import javax.persistence.*;

@Entity
public class Lookups {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "data_code")
    private String dataCode;

    @Column(name = "data_desc")
    private String dataDesc;

    @ManyToOne
    @JoinColumn(name = "data_type", referencedColumnName = "type")
    private LookupMaster lookupMaster;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LookupMaster getLookupMaster() {
        return lookupMaster;
    }

    public void setLookupMaster(LookupMaster lookupMaster) {
        this.lookupMaster = lookupMaster;
    }
}
