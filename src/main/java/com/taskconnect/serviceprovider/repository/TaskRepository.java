package com.taskconnect.serviceprovider.repository;

import com.taskconnect.serviceprovider.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
