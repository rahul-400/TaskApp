package com.assignment.application.service.interfaces;

import com.assignment.application.entity.Company;
import com.assignment.application.entity.CompleteInfo;
import com.assignment.application.update.CompanyInfoUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface CompanyService {

    Company createNewCompany(Company company);

    Page<Company> getCompanyList(Pageable pageable);

    Page<CompleteInfo> getCompleteCompInfo(Long companyId, Pageable pageable);

    String updateCompanyInfo(Long id, CompanyInfoUpdate companyInfoUpdate);

    String deleteCompany(Long id);

    String verifyUser(String username);

}