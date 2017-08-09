# ADS-Word-Cloud

After building, from "out/production/Word\ Cloud/", run "java WordCloudDriver " followed by the desired arguments via command line. The arguments should be given in pairs of two, with the first being the name of the argument and the second being the value. The argument names are as follows:

# "-file" - String describing a filename whose text will be used to generate the word builder. ("-file test.txt")
# "-string" - String containing text that will be used to generate the word builder. ("-string 'Hello Hello World'")
# "-prefix" - String with a prefix that all words must match to be included in the word cloud. ("-prefix sa")
# "-minfreq" - Integer corresponding to minimum required appearances a word must have to be included in the word cloud. ("-minfreq 10")
# "-maxfreq" - Integer corresponding to maximum allowed appearances a word must have to be included in the word cloud. ("-maxfreq 20")
# "-maxword" - Integer determining how many results will be displayed - the first X words will be displayed. ("-maxword 10")
# "-alphasort" - Boolean denoting whether or not results should be sorted alphabetically by word rather than the default, which is numerically according to frequency. ("-alphasort true")

When running the driver via command line, results will be printed to stdout via System.out, and each word will be printed on its own line. So, the command "java WordCloudDriver -string 'Hello Hello Hello World World Goodbye Goodbye Goodbye Goodbye' -alphasort true" produces a result as follows (all words are converted to lowercase upon entry):

"goodbye": 4
"hello": 3
"world": 2
