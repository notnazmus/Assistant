package events;

import events.reminders.CreateEvent;

import java.io.IOException;

public class EventHandler {

    private final String[] reminderKeyWords = {"set","create","schedule","event","reminder"};
    private long startTime;
    private  CreateEvent createEvent = new CreateEvent();
    private  String searchResult;
    private String searchQuery;


    public EventHandler()
    {
        startTime = System.currentTimeMillis();
    }

    public void eventSelection(String input) throws IOException
    {
        searchQuery = input;
        searchResult = search.GoogleSearch.basicSearch(input);
        if ((searchResult.contains("http" ) || searchResult.contains("http") ) && searchResult.contains("www"))
        {
            for (String i: reminderKeyWords)
            {
                if ( searchResult.toLowerCase().contains(i.toLowerCase()))
                {
                    searchResult = "";
                    createEvent.createEvent();
                }
            }
        }

    }

    public String getSearchResult() {
        return searchResult;
    }

    public String getSearchQuery() {
        return searchQuery;
    }
}
