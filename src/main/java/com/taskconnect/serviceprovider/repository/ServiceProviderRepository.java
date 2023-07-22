package com.taskconnect.serviceprovider.repository;

import com.taskconnect.serviceprovider.model.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

}
