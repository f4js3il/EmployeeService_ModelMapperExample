package com.example.EmployeeService.Repository;

import com.example.EmployeeService.Payload.Employee;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;


import java.net.http.HttpClient;
import java.util.Arrays;
import java.util.List;

@Component
public class ExternalEmployeeRepository {
    public List<Employee> getEmployeesFromApi(){
        String uri = "http://dummy.restapiexample.com/api/v1/employees";
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object[]> entity=new HttpEntity<>(headers);
         return restTemplate.exchange(uri, HttpMethod.GET, entity, EmployeeResponse.class).getBody().getData();
    }
}
