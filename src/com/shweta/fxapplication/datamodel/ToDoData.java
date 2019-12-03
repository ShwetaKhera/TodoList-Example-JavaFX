package com.shweta.fxapplication.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ToDoData {
    private static ToDoData instance = new ToDoData();
    private static String fileName = "ToDoListItems.txt";

    private ObservableList<ToDoItem> toDoItems;
    private DateTimeFormatter formatter;

    public static ToDoData getInstance(){
        return instance;
    }

    private ToDoData(){
        formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
    }

    public ObservableList<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    public void addToDoItem(ToDoItem toDoItem){
        toDoItems.add(toDoItem);
    }

    public void setToDoItems(ObservableList<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }

    public void loadToDoItems() throws IOException{
        toDoItems = FXCollections.observableArrayList();
        Path path = Paths.get(fileName);
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        String input;

        try {
            while ((input = bufferedReader.readLine()) != null){
                String[] itemPieces = input.split(" \t ");
                String shortDesc = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];

                LocalDate date = LocalDate.parse(dateString);
                ToDoItem toDoItem = new ToDoItem(shortDesc,details,date);

                toDoItems.add(toDoItem);
            }
        } finally {
            bufferedReader.close();
        }
    }

    public void storeToDoItems() throws IOException{
        Path path = Paths.get(fileName);
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path);

        try {

            for (ToDoItem toDoItem : toDoItems) {
                bufferedWriter.write(String.format("%s \t %s \t %s",
                        toDoItem.getShortDesc(),
                        toDoItem.getDetails(),
                        toDoItem.getDeadline()));

                bufferedWriter.newLine();
            }
        } finally {
            bufferedWriter.close();
        }
    }

    public void deleteToDoItem(ToDoItem toDoItem){
        toDoItems.remove(toDoItem);
    }
}
