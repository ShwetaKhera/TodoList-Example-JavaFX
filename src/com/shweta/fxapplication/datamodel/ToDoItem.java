package com.shweta.fxapplication.datamodel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ToDoItem {
    private String shortDesc;
    private String details;
    private LocalDate deadline;

    public ToDoItem(String shortDesc, String details, LocalDate deadline) {
        this.shortDesc = shortDesc;
        this.details = details;
        this.deadline = deadline;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

//    @Override
//    public String toString() {
//        return shortDesc;
//    }
}
