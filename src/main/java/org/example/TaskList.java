package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TaskList {

    private String name;
    private final List<Task> taskList = new ArrayList<>();

    public TaskList(String name) {
        this.name = name;
    }

    public TaskList(String name, List<Task> taskList) {
        this.name = name;
        this.taskList.addAll(taskList);
    }

    public String getName() {
        return name;
    }

    public List<Task> getTaskList() {
        return new ArrayList<>(taskList);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        if (task.getName() != null && task.getPriority() != null) {
            taskList.add(task);
        }
    }

    public int numberTask(){
        return taskList.size();
    }

    public List<Task> getTaskPriority(Priority priority){
        return taskList.stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }

    public List<Task> getUncompletedTask (){
        return taskList.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }

    public List<Task> getExpiredTask () {
        return  taskList.stream()
                .filter(Task::isExpired)
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }

    public void removeTaskByName(String name){
        taskList.removeIf(task -> Objects.equals(task.getName(), name));
    }
    public void removeCompletedTask(){
        taskList.removeIf(Task::isCompleted);
    }

    public void removeAllTask(){
        taskList.clear();
    }

    public void add(Task task1) {
    }
}
