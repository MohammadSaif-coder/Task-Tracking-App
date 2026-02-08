package com.saif.tasks.services.impl;

import com.saif.tasks.domain.entities.Task;
import com.saif.tasks.domain.entities.TaskList;
import com.saif.tasks.domain.entities.TaskPriority;
import com.saif.tasks.domain.entities.TaskStatus;
import com.saif.tasks.repositories.TaskListRepository;
import com.saif.tasks.repositories.TaskRepository;
import com.saif.tasks.services.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;
  private final TaskListRepository taskListRepository;

  public TaskServiceImpl(TaskRepository taskRepository,
                         TaskListRepository taskListRepository) {
    this.taskRepository = taskRepository;
    this.taskListRepository = taskListRepository;
  }

  @Override
  public List<Task> listTasks(UUID taskListId) {
    return taskRepository.findByTaskListId(taskListId);
  }

  @Override
  public Task getTask(UUID taskListId, UUID taskId) {
    return taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task not found"));
  }


  @Override
  public Task createTask(UUID taskListId, Task task) {
    TaskList taskList = taskListRepository.findById(taskListId)
            .orElseThrow(() -> new RuntimeException("Task list not found"));

    task.setTaskList(taskList);

    // ✅ DEFAULT VALUES (THIS FIXES YOUR ERROR)
    if (task.getStatus() == null) {
      task.setStatus(TaskStatus.TODO);
    }

    if (task.getPriority() == null) {
      task.setPriority(TaskPriority.MEDIUM);
    }

    task.setCreated(LocalDateTime.now());
    task.setUpdated(LocalDateTime.now());

    return taskRepository.save(task);
  }


  @Override
  public Task updateTask(UUID taskListId, UUID taskId, Task task) {
    Task existingTask = taskRepository
            .findByTaskListIdAndId(taskListId, taskId)
            .orElseThrow(() -> new RuntimeException("Task not found"));

    existingTask.setTitle(task.getTitle());
    existingTask.setDescription(task.getDescription());
    existingTask.setDueDate(task.getDueDate());
    existingTask.setStatus(task.getStatus());
    existingTask.setPriority(task.getPriority());
    existingTask.setUpdated(LocalDateTime.now());

    return taskRepository.save(existingTask);
  }

  @Override
  public void deleteTask(UUID taskListId, UUID taskId) {
    Task task = taskRepository
            .findByTaskListIdAndId(taskListId, taskId)
            .orElseThrow(() -> new RuntimeException("Task not found"));

    taskRepository.delete(task);
  }
}
