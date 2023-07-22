package com.taskconnect.serviceprovider.controller;

import com.taskconnect.serviceprovider.model.ServiceProvider;
import com.taskconnect.serviceprovider.model.dto.ServiceProviderDTO;
import com.taskconnect.serviceprovider.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/service-providers")
public class ServiceProviderController {
    @Autowired
    private ServiceProviderService serviceProviderService;


    @GetMapping(path = "/{id}")
    public ResponseEntity<ServiceProvider> getServiceProvider(@PathVariable Long id) {
        return new ResponseEntity<>(serviceProviderService.findServiceProviderById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ServiceProviderDTO>> getAllServiceProviders() {
        return new ResponseEntity<>(serviceProviderService.findAllServiceProviders(), HttpStatus.OK);
    }
}
