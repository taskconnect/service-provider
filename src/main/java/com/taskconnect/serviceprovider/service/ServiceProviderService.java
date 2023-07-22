package com.taskconnect.serviceprovider.service;

import com.taskconnect.serviceprovider.model.ServiceProvider;
import com.taskconnect.serviceprovider.model.dto.ServiceProviderDTO;
import com.taskconnect.serviceprovider.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceProviderService {
    @Autowired
    private ServiceProviderRepository serviceProviderRepository;


    public ServiceProvider findServiceProviderById(Long id) {
        //? Create a custom exception?
        return serviceProviderRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("Provedor de serviço não encontrado.", 1));
    }

    public List<ServiceProviderDTO> findAllServiceProviders() {
        return serviceProviderRepository.findAll().stream()
                .map(serviceProvider ->
                        new ServiceProviderDTO(serviceProvider.getId(), serviceProvider.getFullName(), serviceProvider.getEmail()))
                .collect(Collectors.toList());
    }
}
