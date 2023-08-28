package com.taskconnect.serviceprovider.service;

import com.taskconnect.serviceprovider.model.Provider;
import com.taskconnect.serviceprovider.model.Task;
import com.taskconnect.serviceprovider.model.dto.ProviderDTO;
import com.taskconnect.serviceprovider.repository.ProviderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;


    public Provider findServiceProviderById(Long id) {
        return providerRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("Provedor de serviço não encontrado.", 1));
    }

    public List<ProviderDTO> findAllServiceProviders() {
        return providerRepository.findAll().stream()
                .map(provider ->
                        new ProviderDTO(provider.getId(), provider.getFullName(), provider.getEmail()))
                .collect(Collectors.toList());
    }

    public List<ProviderDTO> findProvidersByTask(String task) {
        List<Provider> providersFromTask = new ArrayList<>();
        providerRepository.findAll().forEach(provider -> {
            for(Task t : provider.getTasksProvided()) {
                if (t.getTaskCategory().equalsIgnoreCase(task.strip())) {
                    providersFromTask.add(provider);
                };
            }
        });
        return providersFromTask.stream().map(provider ->
                        new ProviderDTO(provider.getId(), provider.getFullName(), provider.getEmail()))
        .collect(Collectors.toList());
    }
}
