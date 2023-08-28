package com.taskconnect.serviceprovider.controller;

import com.taskconnect.serviceprovider.model.dto.ProviderDTO;
import com.taskconnect.serviceprovider.service.ProviderService;
import com.taskconnect.serviceprovider.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private ProviderService providerService;

    @GetMapping
    public ResponseEntity<Set<String>> getAvailableTasks(){
        return ResponseEntity.ok().body(taskService.listTasksAvailable());
    }

    @GetMapping(path = "/{taskCategory}")
    public ResponseEntity<List<ProviderDTO>> getProvidersFromTask(@PathVariable String taskCategory) {
        return ResponseEntity.ok().body(providerService.findProvidersByTask(taskCategory));
    }
}
