package com.example.secondproject.example.task.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class TaskModels {
    public LocalDate createBy;
    public LocalDate deadlineBy;
    public String description;
    public Boolean isSuccess;
    public TaskModels(
            @NotNull String description,
            @NonNull LocalDate createBy,
            @Nullable LocalDate deadlineBy
    )
    {
        this.description = description;
        this.createBy = createBy;
        this.deadlineBy = deadlineBy;
    }
}
