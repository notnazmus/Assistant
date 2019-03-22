package scenes.controllers;

import events.EventHandler;
import events.reminders.CreateEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import search.GoogleSearch;

import java.io.IOException;

public class Controller {

    public Label display;
    public AnchorPane innerPane;
    public ScrollPane scrollPane;
    public TextField textField;
    public Label queryDisplay;
    public EventHandler eventHandler = new EventHandler();


    public void submit() throws IOException
    {
        display.setText("");

        eventHandler.eventSelection(textField.getText());
        display.setText(eventHandler.getSearchResult());
        queryDisplay.setText("Search: "+eventHandler.getSearchQuery());
        textField.setText("");
    }




    public void initialize()
    {

        display.setText("");
        display.setWrapText(true);
        queryDisplay.setWrapText(true);
        display.setMaxWidth(innerPane.getPrefWidth()-15);
        display.setPrefHeight(-1.0);
    }


}
