package com.viniciusdev.crud.controller;
import com.viniciusdev.crud.dto.MessageResponseDTO;
import com.viniciusdev.crud.dto.TasksRequestsDTO;
import com.viniciusdev.crud.dto.TasksResponseDTO;
import com.viniciusdev.crud.service.TasksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/tasks")
public class TasksController {

    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    // Created User
    @PostMapping
    public ResponseEntity<MessageResponseDTO> created(@RequestBody TasksRequestsDTO request){
        MessageResponseDTO response = tasksService.createdTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Return All Tasks
    @GetMapping
    public ResponseEntity<List<TasksResponseDTO>> returnAllTasks(){
        List<TasksResponseDTO> response = tasksService.returnAllTask();
        return ResponseEntity.ok(response);
    }

    // Return Tasks by ID
    @GetMapping("/{id}")
    public ResponseEntity<TasksResponseDTO> returnByTaskId(@PathVariable UUID id){
        TasksResponseDTO response = tasksService.returnTaskById(id);
        return ResponseEntity.ok(response);
    }

    // Put Task
    @PutMapping("/{id}")
    public ResponseEntity<MessageResponseDTO> updateTask(@PathVariable UUID id, @RequestBody TasksRequestsDTO updateTask){
        MessageResponseDTO response = tasksService.putTask(id, updateTask);
        return ResponseEntity.ok(response);
    }

    // Delete Task
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDTO> deleteTask(@PathVariable UUID id){
        MessageResponseDTO response = tasksService.deleteTask(id);
        return ResponseEntity.ok(response);
    }


}
