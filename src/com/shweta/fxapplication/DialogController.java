package com.shweta.fxapplication;

import com.shweta.fxapplication.datamodel.ToDoData;
import com.shweta.fxapplication.datamodel.ToDoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML private TextField shortDesc;
    @FXML private TextArea detailsArea;
    @FXML private DatePicker deadlinePicker;

    public ToDoItem processResult(){
        String shortDescField = shortDesc.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadline = deadlinePicker.getValue();

        ToDoItem toDoItem = new ToDoItem(shortDescField, details, deadline);
        ToDoData.getInstance().addToDoItem(toDoItem);
        return toDoItem;
    }
}
