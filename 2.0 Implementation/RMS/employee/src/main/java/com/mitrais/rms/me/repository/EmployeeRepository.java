package com.mitrais.rms.me.repository;

import com.mitrais.rms.me.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmail(@Param("email") String email);
}