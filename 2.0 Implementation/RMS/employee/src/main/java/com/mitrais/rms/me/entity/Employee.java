package com.mitrais.rms.me.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "employment_status")
    private String employmentStatus;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "business_unit")
    private String businessUnit;

    @Column(name = "division")
    private String division;

    @Column(name = "job_family")
    private String jobFamily;

    @Column(name = "stream")
    private String stream;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "reporting_manager")
    private int reportingManager;

    @Column(name = "retire_date")
    private Date retireDate;

    @Column(name = "suspend_date")
    private Date suspendDate;

    @Column(name = "active_ind")
    private int activeInd;

    @Column(name = "last_degree")
    private String lastDegree;

    @Column(name = "recruit_from")
    private String recruitFrom;

    @Column(name = "contract_expiry_date")
    private Date contractExpiryDate;

    @Column(name = "last_mod_date")
    private Timestamp lastModDate;

    @Column(name = "last_mod_user")
    private String lastModUser;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
    private Set<Address> addresses;

    @OneToMany(mappedBy = "employee")
    private Set<Dependent> dependents;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeHistory> empHistories;

    @OneToMany(mappedBy = "employee")
    private Set<GradeHistory> gradeHistories;

    @OneToMany(mappedBy = "employee")
    private Set<Location> locations;

    public Employee() {
    }

    public Employee(String name, Date dob, String gender, String maritalStatus, String phone, String email, Date hireDate, String employmentStatus, String nationality, String businessUnit, String division, String jobFamily, String stream, String jobTitle, int reportingManager, Date retireDate, Date suspendDate, int activeInd, String lastDegree, String recruitFrom, Date contractExpiryDate, Timestamp lastModDate, String lastModUser, Set<Address> addresses, Set<Dependent> dependents, Set<EmployeeHistory> empHistories, Set<GradeHistory> gradeHistories, Set<Location> locations) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.phone = phone;
        this.email = email;
        this.hireDate = hireDate;
        this.employmentStatus = employmentStatus;
        this.nationality = nationality;
        this.businessUnit = businessUnit;
        this.division = division;
        this.jobFamily = jobFamily;
        this.stream = stream;
        this.jobTitle = jobTitle;
        this.reportingManager = reportingManager;
        this.retireDate = retireDate;
        this.suspendDate = suspendDate;
        this.activeInd = activeInd;
        this.lastDegree = lastDegree;
        this.recruitFrom = recruitFrom;
        this.contractExpiryDate = contractExpiryDate;
        this.lastModDate = lastModDate;
        this.lastModUser = lastModUser;
        this.addresses = addresses;
        this.dependents = dependents;
        this.empHistories = empHistories;
        this.gradeHistories = gradeHistories;
        this.locations = locations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getJobFamily() {
        return jobFamily;
    }

    public void setJobFamily(String jobFamily) {
        this.jobFamily = jobFamily;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(int reportingManager) {
        this.reportingManager = reportingManager;
    }

    public Date getRetireDate() {
        return retireDate;
    }

    public void setRetireDate(Date retireDate) {
        this.retireDate = retireDate;
    }

    public Date getSuspendDate() {
        return suspendDate;
    }

    public void setSuspendDate(Date suspendDate) {
        this.suspendDate = suspendDate;
    }

    public int getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(int activeInd) {
        this.activeInd = activeInd;
    }

    public String getLastDegree() {
        return lastDegree;
    }

    public void setLastDegree(String lastDegree) {
        this.lastDegree = lastDegree;
    }

    public String getRecruitFrom() {
        return recruitFrom;
    }

    public void setRecruitFrom(String recruitFrom) {
        this.recruitFrom = recruitFrom;
    }

    public Date getContractExpiryDate() {
        return contractExpiryDate;
    }

    public void setContractExpiryDate(Date contractExpiryDate) {
        this.contractExpiryDate = contractExpiryDate;
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(Set<Dependent> dependents) {
        this.dependents = dependents;
    }

    public Set<EmployeeHistory> getEmpHistories() {
        return empHistories;
    }

    public void setEmpHistories(Set<EmployeeHistory> empHistories) {
        this.empHistories = empHistories;
    }

    public Set<GradeHistory> getGradeHistories() {
        return gradeHistories;
    }

    public void setGradeHistories(Set<GradeHistory> gradeHistories) {
        this.gradeHistories = gradeHistories;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }
}
