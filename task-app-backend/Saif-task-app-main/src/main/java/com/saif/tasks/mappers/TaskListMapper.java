package com.saif.tasks.mappers;

import com.saif.tasks.domain.dto.TaskListDto;
import com.saif.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
