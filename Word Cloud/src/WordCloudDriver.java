import java.util.Map;

/**
 * Created by psweeney on 8/8/17.
 */
public class WordCloudDriver {

    public static void main(String[] args){
        WordCloudBuilder builder = new WordCloudBuilder();

        for(int i = 0; i < args.length; i += 2){
            String argKey = args[i], argValue = args[i + 1];
            builder.processArg(argKey, argValue);
        }

        WordCloud wordCloud = builder.generateWordCloud();
        for(Map.Entry<String, Integer> wordCloudEntry : wordCloud){
            System.out.println("\"" + wordCloudEntry.getKey() + "\": " + wordCloudEntry.getValue());
        }
    }
}
