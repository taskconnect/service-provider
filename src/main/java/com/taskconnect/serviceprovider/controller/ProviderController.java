package com.taskconnect.serviceprovider.controller;

import com.taskconnect.serviceprovider.model.Provider;
import com.taskconnect.serviceprovider.model.dto.ProviderDTO;
import com.taskconnect.serviceprovider.service.ProviderService;
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
public class ProviderController {
    @Autowired
    private ProviderService providerService;


    @GetMapping(path = "/{id}")
    public ResponseEntity<Provider> getServiceProvider(@PathVariable Long id) {
        return new ResponseEntity<>(providerService.findServiceProviderById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProviderDTO>> getAllServiceProviders() {
        return new ResponseEntity<>(providerService.findAllServiceProviders(), HttpStatus.OK);
    }
}
