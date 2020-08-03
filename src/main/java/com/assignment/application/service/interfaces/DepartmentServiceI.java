package com.assignment.application.service.interfaces;

import com.assignment.application.entity.Department;
import com.assignment.application.update.DepartmentUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentServiceI {

    Department addDepartment(Long companyId, Department department);

    Page<Department> getDepartments(Pageable pageable);

    Page<Department> getDepartmentsOfCompany(Long companyId, Pageable pageable);

    Department getDepartment(Long companyId, Long id);

    String updateDepartmentInfo(Long companyId, Long id, DepartmentUpdate departmentUpdate);

    String deleteDepartmentOfCompany(Long id, Long companyId);

}
