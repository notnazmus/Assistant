package events.reminders;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CreateEvent {


    public void test() throws  IOException
    {
        Path path = Paths.get("../data/events");
        //if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                //fail to create directory
                e.printStackTrace();
            }
            File file = new File("../data/events/reminder.txt");
            file.createNewFile();

        }

        while(true)
        {
            System.out.println("What reminder would you like to set?");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();


        }
    }

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("../data/events");
        //if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                //fail to create directory
                e.printStackTrace();
            }
            File file = new File("../data/events/reminder.txt");
            file.createNewFile();

        }

        while(true)
        {
            System.out.println("What reminder would you like to set?");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();


        }


    }

    public void createEvent()
    {

    }




}
