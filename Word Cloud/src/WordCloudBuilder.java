import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by psweeney on 8/8/17.
 */
public class WordCloudBuilder {
    private String inputText = null;
    private String prefixFilter = null;
    private int minFreqThreshold = 0;
    private int maxFreqThreshold = 0;
    private int maxWordCount = 0;
    private boolean alphabeticSorting = false;

    public void processArg(String argKey, String argValue){
        switch (argKey){
            case "-file":
                setInputTextViaFilename(argValue);
                break;
            case "-string":
                setInputText(argValue);
                break;
            case "-pref":
                setPrefixFilter(argValue);
                break;
            case "-minfreq":
                setMinFreqThreshold(Integer.parseInt(argValue));
                break;
            case "-maxfreq":
                setMaxFreqThreshold(Integer.parseInt(argValue));
                break;
            case "-maxword":
                setMaxWordCount(Integer.parseInt(argValue));
                break;
            case "-alphsort":
                setAlphabeticSorting(Boolean.parseBoolean(argValue));
                break;
        }
    }

    public void setInputText(String string){
        inputText = string;
    }

    public void setInputTextViaFilename(String filename){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder wordCloudBuilder = new StringBuilder();
            String line = reader.readLine();
            while(line != null){
                if(wordCloudBuilder.length() != 0) wordCloudBuilder.append(' ');
                wordCloudBuilder.append(line);
            }
            setInputText(wordCloudBuilder.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getInputText() {
        return inputText;
    }

    public void setPrefixFilter(String prefixFilter) {
        this.prefixFilter = prefixFilter;
    }

    public String getPrefixFilter() {
        return prefixFilter;
    }

    public void setMinFreqThreshold(int minFreqThreshold) {
        this.minFreqThreshold = minFreqThreshold;
    }

    public int getMinFreqThreshold() {
        return minFreqThreshold;
    }

    public void setMaxFreqThreshold(int maxFreqThreshold) {
        this.maxFreqThreshold = maxFreqThreshold;
    }

    public int getMaxFreqThreshold() {
        return maxFreqThreshold;
    }

    public void setMaxWordCount(int maxWordCount) {
        this.maxWordCount = maxWordCount;
    }

    public int getMaxWordCount() {
        return maxWordCount;
    }

    public void setAlphabeticSorting(boolean alphabeticSorting) {
        this.alphabeticSorting = alphabeticSorting;
    }

    public boolean isAlphabeticSorting() {
        return alphabeticSorting;
    }
}
