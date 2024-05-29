package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Task {

    private final String name;
    private final String description;
    private final LocalDate timeToDo;
    private boolean isCompleted;
    private final Priority priority;

    public Task(String name, String description, LocalDate timeToDo, boolean status, Priority priority) {
        this.name = name;
        this.description = description;
        this.timeToDo = timeToDo;
        this.isCompleted = status;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isExpired() {
        return timeToDo.isBefore(LocalDate.now());
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isCompleted == task.isCompleted
                && Objects.equals(name, task.name)
                && Objects.equals(description, task.description)
                && Objects.equals(timeToDo, task.timeToDo)
                && priority == task.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, timeToDo, isCompleted, priority);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timeToDo=" + timeToDo +
                ", isCompleted=" + isCompleted +
                ", priority=" + priority +
                '}';
    }
}
