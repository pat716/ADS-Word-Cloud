import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

        System.out.println(builder.getInputText());
        System.out.println(builder.getPrefixFilter());
        System.out.println(builder.getMinFreqThreshold());
        System.out.println(builder.getMaxFreqThreshold());
        System.out.println(builder.getMaxWordCount());
        System.out.println(builder.isAlphabeticSorting());
    }
}
