package com.saif.tasks.mappers;

import com.saif.tasks.domain.dto.TaskDto;
import com.saif.tasks.domain.entities.Task;

public interface TaskMapper {

  Task fromDto(TaskDto taskDto);

  TaskDto toDto(Task task);

}
