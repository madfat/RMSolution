package com.mitrais.rms.me.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "branch_office")
    private String branchOffice;

    @Column(name = "relocation_startdate")
    private Date relocationStartDate;

    @Column(name = "relocation_enddate")
    private Date relocationEndDate;

    @Column(name = "last_mod_date")
    private Timestamp lastModDate;

    @Column(name = "last_mod_user")
    private String lastModUser;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    public Location() {}

    public Location(String branchOffice, Date relocationStartDate, Date relocationEndDate, Timestamp lastModDate, String lastModUser, Employee employee) {
        this.branchOffice = branchOffice;
        this.relocationStartDate = relocationStartDate;
        this.relocationEndDate = relocationEndDate;
        this.lastModDate = lastModDate;
        this.lastModUser = lastModUser;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(String branchOffice) {
        this.branchOffice = branchOffice;
    }

    public Date getRelocationStartDate() {
        return relocationStartDate;
    }

    public void setRelocationStartDate(Date relocationStartDate) {
        this.relocationStartDate = relocationStartDate;
    }

    public Date getRelocationEndDate() {
        return relocationEndDate;
    }

    public void setRelocationEndDate(Date relocationEndDate) {
        this.relocationEndDate = relocationEndDate;
    }

    public Timestamp getLastModDate() {
        return lastModDate;
    }

    public void setLastModDate(Timestamp lastModDate) {
        this.lastModDate = lastModDate;
    }

    public String getLastModUser() {
        return lastModUser;
    }

    public void setLastModUser(String lastModUser) {
        this.lastModUser = lastModUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
