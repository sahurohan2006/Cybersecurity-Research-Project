
import java.util.*;
import java.io.File;

public class Stopwords {
    private static Set<String> words;


    public Stopwords() throws Exception {
        words = new HashSet<>();
        Set<String> stopwords = new HashSet<>();
        File f = new File("Stopwords.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNext()) {
            String temp = sc.next();
            stopwords.add(temp);
        }
        sc.close();
        words = stopwords;

    }

    public Set<String> getWords() {
        return words;
    }

    public boolean containsWord(String word) {
        if(words.contains(word)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws Exception {
        Stopwords s = new Stopwords();
        System.out.println(s.words);

    }
}
