package com.taskconnect.serviceprovider.repository;

import com.taskconnect.serviceprovider.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

}
