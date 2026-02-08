package com.saif.tasks.services;

import com.saif.tasks.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
  List<Task> listTasks(UUID taskListId);

  Task createTask(UUID taskListId, Task task);

  Task updateTask(UUID taskListId, UUID taskId, Task task);

  void deleteTask(UUID taskListId, UUID taskId);

  Task getTask(UUID taskListId, UUID taskId);
}
