package com.mitrais.rms.me.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lookup_master")
public class LookupMaster {

    @Id
    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "lookupMaster", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Lookups> lookups;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Lookups> getLookups() {
        return lookups;
    }

    public void setLookups(Set<Lookups> lookups) {
        this.lookups = lookups;
    }
}
