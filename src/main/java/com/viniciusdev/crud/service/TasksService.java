package com.viniciusdev.crud.service;

import com.viniciusdev.crud.dto.MessageResponseDTO;
import com.viniciusdev.crud.dto.TasksRequestsDTO;
import com.viniciusdev.crud.dto.TasksResponseDTO;
import com.viniciusdev.crud.exceptions.InvalidTaskDataException;
import com.viniciusdev.crud.exceptions.TaskNotFoundException;
import com.viniciusdev.crud.model.TasksModel;
import com.viniciusdev.crud.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TasksService {

    public final TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public MessageResponseDTO createdTask(TasksRequestsDTO request){
        if(request.title() == null || request.title().isBlank() ||
        request.description() == null || request.description().isBlank()) {
            throw new InvalidTaskDataException("Preecha todos os campos");
        }

            TasksModel task = new TasksModel();
            task.setTitle(request.title());
            task.setDescription(request.description());
            tasksRepository.save(task);
            return new MessageResponseDTO("Usuário Cadastrado com sucesso");
    }

    public List<TasksResponseDTO> returnAllTask(){
            List<TasksModel> tasks = tasksRepository.findAll();
            return tasks.stream()
                    .map(task -> new TasksResponseDTO(task.getId(),task.getTitle(),task.getDescription()))
                    .toList();
    }

    public TasksResponseDTO returnTaskById(UUID id) {
        return tasksRepository.findById(id)
                .map(task -> new TasksResponseDTO(task.getId(), task.getTitle(), task.getDescription()))
                .orElseThrow(() -> new TaskNotFoundException("Tarefa com o ID " + id + " não foi encontrada."));
    }

    public MessageResponseDTO putTask(UUID id, TasksRequestsDTO updateTask){

        if(updateTask.title() == null || updateTask.title().isBlank() ||
        updateTask.description() == null || updateTask.description().isBlank()){
            throw new InvalidTaskDataException("Preecha todos os campos");
        }

        TasksModel task = tasksRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Tarefa com o ID " + id + " não foi encontrada."));

        task.setTitle(updateTask.title());
        task.setDescription(updateTask.description());

        tasksRepository.save(task);

        return new MessageResponseDTO("Edição feita com sucesso");
    }

    public MessageResponseDTO deleteTask(UUID id){

        tasksRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Tarefa com o ID " + id + " não foi encontrada."));

        tasksRepository.deleteById(id);
        return new MessageResponseDTO("Usuario deletado com sucesso");
    }

}
