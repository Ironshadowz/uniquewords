package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String dirPath = args[0];
        String fileName = args[1];
        File dir =new File(dirPath);
        File fileN = new File(dirPath+File.separator+fileName);
        if(dir.exists())
        {

        } else 
        {
            dir.mkdir();
            fileN.createNewFile();
        }
        if(fileN.exists())
        {

        } else
        {
            fileN.createNewFile();
        }

        FileReader fr = new FileReader(fileN);
        BufferedReader br = new BufferedReader(fr);
        String lines = "";
        StringBuilder sb = new StringBuilder();
        while((lines=br.readLine())!=null)
        {
            sb.append(lines);
        }
        br.close();
        fr.close();
        lines=sb.toString();
        String[] STOPWORDS = {
            "a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "as", "at", "be",
            "because", "been", "before", "being", "below", "between", "both", "but", "by", "can't", "cannot", "could",
            "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down", "during", "each", "few", "for", "from",
            "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll",
            "he's", "her", "here", "here's", "hers", "herself", "him", "himself", "his", "how", "how's", "i", "i'd", "i'll",
            "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its", "itself", "let's", "me", "more",
            "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", "ought",
            "our", "ours", "ourselves", "out", "over", "own", "same", "shan't", "she", "she'd", "she'll", "she's", "should",
            "shouldn't", "so", "some", "such", "than", "that", "that's", "the", "their", "theirs", "them", "themselves", "then",
            "there", "there's", "these", "they", "they'd", "they'll", "they're", "they've", "this", "those", "through", "to",
            "too", "under", "until", "up", "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were",
            "weren't", "what", "what's", "when", "when's", "where", "where's", "which", "while", "who", "who's", "whom", "why",
            "why's", "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your", "yours",
            "yourself", "yourselves"
        };
        // lines = lines.toLowerCase();
        // for(int i =0 ; i<STOPWORDS.length; i++)
        // {
        //     String x = STOPWORDS[i];
        //     if(lines.contains(x))
        //     {
        //         lines=lines.replaceAll(x, "");
        //     }
           // System.out.println(i);
        //}
       // System.out.println(lines);
        String[] words = lines.replaceAll("\\p{Punct}", "").toLowerCase().trim().split("\\s+");
        Map<String, Integer> uniqueWord = new HashMap<>();
        int j=0;
        List<String> holder = new ArrayList<>();
        for(int i =0 ; i<STOPWORDS.length; i++)
        {
            String x = STOPWORDS[i];
           for(String y : words)
           {
                String ww= y.trim();
                if(ww.equals(x))
                {
                   // System.out.println(x);
                } else
                {
                    Integer wordExist = uniqueWord.get(ww);
                    if(wordExist==null)
                    {
                        j++;
                        uniqueWord.put(ww, 1);
                    } else
                    {
                        uniqueWord.put(ww, wordExist+1);
                    } 
                }
           }
           //System.out.println();
        }
        
        for (String k: uniqueWord.keySet()) {
            System.out.printf("word: %s \n", k);
        }

       // System.out.println(holder);
        // for(String uw : holder)
        // {
        //     Integer wordExist = uniqueWord.get(uw);
        //     if(wordExist==null)
        //     {
        //         j++;
        //     } else
        //     {
        //         uniqueWord.put(uw, wordExist+1);
        //     } 
        // }
        System.out.println("Number of unique words: "+j);
    }
}
