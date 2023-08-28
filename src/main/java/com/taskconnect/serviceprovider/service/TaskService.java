package com.taskconnect.serviceprovider.service;

import com.taskconnect.serviceprovider.model.Task;
import com.taskconnect.serviceprovider.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Set<String> listTasksAvailable() {
        return taskRepository.findAll().stream().map(Task::getTaskCategory).collect(Collectors.toSet());
    }


}
