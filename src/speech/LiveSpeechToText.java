package speech;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
// edu.cmu.sphinx:sphinx4-core:5prealpha-SNAPSHOT
import java.io.IOException;

public class LiveSpeechToText implements Runnable {

    public  LiveSpeechToText()
    {

    }

    public static void main(String[] args) throws IOException
    {
        LiveSpeechToText l =  new LiveSpeechToText();
        new Thread(l).start();
       // System.out.println("dsad");


    }
    public void run()
    {
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        //configuration.setGrammarPath("E:\\Personal Assistant\\Assistant\\src\\speech\\grammar.gram");

            try {
                LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
                // Start recognition process pruning previously cached data.

                long currentTime = System.currentTimeMillis();
                recognizer.startRecognition(true);
                SpeechResult result = recognizer.getResult();
                System.out.println(result.getHypothesis() + " in "+ (System.currentTimeMillis()-currentTime)+"ms");
                recognizer.stopRecognition();
                // Pause recognition process. It can be resumed then with startRecognition(false)
            } catch (IOException e) {
                e.printStackTrace();
            }



    }



}
