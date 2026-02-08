package com.saif.tasks.controllers;

import com.saif.tasks.domain.dto.TaskDto;
import com.saif.tasks.mappers.TaskMapper;
import com.saif.tasks.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//@RestController
//@RequestMapping("api/task-lists/{task_list_id}/tasks")
//public class TasksController {
//
//  private final TaskService taskService;
//  private final TaskMapper taskMapper;
//
//  public TasksController(TaskService taskService, TaskMapper taskMapper) {
//    this.taskService = taskService;
//    this.taskMapper = taskMapper;
//  }
//
//  // ✅ GET tasks
//  @GetMapping
//  public List<TaskDto> listTasks(@PathVariable("task_list_id") UUID taskListId) {
//    return taskService.listTasks(taskListId)
//            .stream()
//            .map(taskMapper::toDto)
//            .toList();
//  }
//
//  // ✅ CREATE task
//  @PostMapping
//  public TaskDto createTask(
//          @PathVariable("task_list_id") UUID taskListId,
//          @RequestBody TaskDto taskDto
//  ) {
//    Task createdTask = taskService.createTask(
//            taskListId,
//            taskMapper.fromDto(taskDto)
//    );
//    return taskMapper.toDto(createdTask);
//  }
//
//  // ✅ UPDATE task (THIS FIXES YOUR ERROR)
//  @PutMapping("/{task_id}")
//  public TaskDto updateTask(
//          @PathVariable("task_list_id") UUID taskListId,
//          @PathVariable("task_id") UUID taskId,
//          @RequestBody TaskDto taskDto
//  ) {
//    Task updatedTask = taskService.updateTask(
//            taskListId,
//            taskId,
//            taskMapper.fromDto(taskDto)
//    );
//    return taskMapper.toDto(updatedTask);
//  }
//
//  // ✅ DELETE task
//  @DeleteMapping("/{task_id}")
//  public void deleteTask(
//          @PathVariable("task_list_id") UUID taskListId,
//          @PathVariable("task_id") UUID taskId
//  ) {
//    taskService.deleteTask(taskListId, taskId);
//  }
//}
@RestController
@RequestMapping("/api/task-lists/{task_list_id}/tasks")
public class TasksController {

  private final TaskService taskService;
  private final TaskMapper taskMapper;

  public TasksController(TaskService taskService, TaskMapper taskMapper) {
    this.taskService = taskService;
    this.taskMapper = taskMapper;
  }

  // ✅ LIST TASKS
  @GetMapping
  public List<TaskDto> listTasks(@PathVariable UUID task_list_id) {
    return taskService.listTasks(task_list_id)
            .stream()
            .map(taskMapper::toDto)
            .toList();
  }

  // ✅ GET SINGLE TASK (THIS FIXES YOUR ERROR)
  @GetMapping("/{task_id}")
  public TaskDto getTask(
          @PathVariable UUID task_list_id,
          @PathVariable UUID task_id
  ) {
    return taskMapper.toDto(
            taskService.getTask(task_list_id, task_id)
    );
  }

  // ✅ CREATE
  @PostMapping
  public TaskDto createTask(
          @PathVariable UUID task_list_id,
          @RequestBody TaskDto taskDto
  ) {
    return taskMapper.toDto(
            taskService.createTask(task_list_id, taskMapper.fromDto(taskDto))
    );
  }

  // ✅ UPDATE
  @PutMapping("/{task_id}")
  public TaskDto updateTask(
          @PathVariable UUID task_list_id,
          @PathVariable UUID task_id,
          @RequestBody TaskDto taskDto
  ) {
    return taskMapper.toDto(
            taskService.updateTask(task_list_id, task_id, taskMapper.fromDto(taskDto))
    );
  }

  // ✅ DELETE
  @DeleteMapping("/{task_id}")
  public void deleteTask(
          @PathVariable UUID task_list_id,
          @PathVariable UUID task_id
  ) {
    taskService.deleteTask(task_list_id, task_id);
  }
}
