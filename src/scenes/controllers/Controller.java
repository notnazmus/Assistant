package scenes.controllers;



import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;


public class Controller {

    public ChoiceBox<String> requestBox;
    public TextField query;


    private String[] str = {"Google Search", "Music Search", "Video Search", "Events" };






    public void submit() throws IOException
    {
        if (requestBox.getValue() != null)
            System.out.println(requestBox.getValue()+": "+query.getText());
    }




    public void initialize()
    {
        requestBox.setItems(FXCollections.observableArrayList(str));

    }


}
