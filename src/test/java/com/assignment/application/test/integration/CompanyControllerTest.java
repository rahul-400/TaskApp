package com.assignment.application.test.integration;

import com.assignment.application.TaskAppApplication;
import com.assignment.application.constants.StringConstant;
import com.assignment.application.entity.Company;
import com.assignment.application.entity.CompleteInfo;
import com.assignment.application.update.CompanyInfoUpdate;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaskAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyControllerTest {

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders httpHeaders = new HttpHeaders();

    @LocalServerPort
    private int port;

    public void setHttpHeaders(HttpHeaders httpHeaders) {
        httpHeaders.add("access_token", "f9662650-ec3b-4d2e-96fd-6e29b8a77df7");
        this.httpHeaders = httpHeaders;
    }

    @Test
    public void test_GetCompany_Success() {
        setHttpHeaders(httpHeaders);
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        List<Company> companyList = new ArrayList<>();
        ResponseEntity<List<Company>> responseEntity =
                testRestTemplate.exchange("http://localhost:" + port + "//company",
                                          HttpMethod.GET, entity, new ParameterizedTypeReference<List<Company>>() {});
        Assert.assertEquals(5, responseEntity.getBody().size());
    }

    @Test
    public void test_GetCompleteCompInfo_success() {
        setHttpHeaders(httpHeaders);
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        List<CompleteInfo> companyList = new ArrayList<>();
        ResponseEntity<List<CompleteInfo>> responseEntity =
                testRestTemplate.exchange("http://localhost:" + port + "//company/9/complete-info",
                                          HttpMethod.GET, entity,
                                          new ParameterizedTypeReference<List<CompleteInfo>>() {});
        Assert.assertEquals(2, responseEntity.getBody().size());
    }

    @Test
    public void test_UpdateCompanyInfo_success() {
        setHttpHeaders(httpHeaders);
        this.restTemplate = testRestTemplate.getRestTemplate();
        HttpClient httpClient = HttpClientBuilder.create().build();
        this.restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
        CompanyInfoUpdate companyInfoUpdate = new CompanyInfoUpdate("Search Engine Platform");
        HttpEntity<CompanyInfoUpdate> entity = new HttpEntity<>(companyInfoUpdate, httpHeaders);
        List<CompleteInfo> companyList = new ArrayList<>();
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("http://localhost:" + port + "//company/9/company-update",
                                      HttpMethod.PATCH, entity, String.class);
        Assert.assertEquals(StringConstant.UPDATE_SUCCESSFUL, responseEntity.getBody());
    }

    //    @Test
    //    public void test_DeleteCompany_success(){
    //        setHttpHeaders(httpHeaders);
    //        HttpEntity<String> entity = new HttpEntity<>(null,httpHeaders);
    //        List<CompleteInfo> companyList = new ArrayList<>();
    //        ResponseEntity<String> responseEntity = testRestTemplate.exchange("http://localhost:" + port + "//company/15",
    //                HttpMethod.DELETE, entity, String.class);
    //        Assert.assertEquals(StringConstant.DELETION_SUCCESSFUL,responseEntity.getBody());
    //    }

}
