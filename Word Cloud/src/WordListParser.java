import java.util.*;

/**
 * Created by psweeney on 8/8/17.
 */
public class WordListParser {
    private static final SortedSet<String> WORDS_TO_IGNORE = new TreeSet<>(Arrays.asList(
            "a", "an", "it", "the", "them",  "us"
    ));

    private Set<String> validWords;
    private Map<String, Integer> frequencyMap;
    private String prefixFilter;
    private int maxFreqThreshold;

    public WordListParser(List<String> words, String prefixFilter, int maxFreqThreshold){
        validWords = new HashSet<>();
        frequencyMap = new HashMap<>();
        this.prefixFilter = prefixFilter;
        this.maxFreqThreshold = maxFreqThreshold;

        for(String word : words){
            addWord(word.toLowerCase());
        }

    }

    public void addWord(String word){
        if(WORDS_TO_IGNORE.contains(word)) return;

        if(prefixFilter != null && !word.substring(0, prefixFilter.length()).equals(prefixFilter)) return;

        if(maxFreqThreshold >= 0 && frequencyMap.containsKey(word) && frequencyMap.get(word) >= maxFreqThreshold){
            validWords.remove(word);
            return;
        }

        if(frequencyMap.containsKey(word)){
            frequencyMap.put(word, frequencyMap.get(word) + 1);
        } else {
            frequencyMap.put(word, 1);
            validWords.add(word);
        }
    }

    public void applyPostFilters(int minFreqThreshold, int maxWordCount, boolean alphabeticSorting){
        Set<String> invalidatedWords = new HashSet<>();
        if(minFreqThreshold >= 0){
            for (String word : validWords){
                if(frequencyMap.get(word) < minFreqThreshold) invalidatedWords.add(word);
            }
        }

        validWords.removeAll(invalidatedWords);

        SortedSet<String> sortedWords;
        if(alphabeticSorting) sortedWords = new TreeSet<>();
        else {
            sortedWords = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int freqComparison = frequencyMap.get(o2) - frequencyMap.get(o1);
                    if(freqComparison != 0) return freqComparison;
                    return o1.compareTo(o2);
                }
            });
        }
        sortedWords.addAll(validWords);

        if(maxWordCount >= 0){
            ArrayList<String> sortedWordList = new ArrayList<>(sortedWords);
            sortedWords.removeAll(sortedWordList.subList(maxWordCount, sortedWordList.size()));
        }
        validWords = sortedWords;
    }

    public WordCloud buildWordCloudFromCurrentState(){
        return new WordCloud(frequencyMap, new ArrayList<>(validWords));
    }
}
