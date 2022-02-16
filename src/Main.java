import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.FileWriter;
public class Main {
    private static Stopwords s;
    private static Set<String> stopwords;
    public Main() throws Exception {
       s = new Stopwords();
       stopwords = s.getWords();
    }

    public void checkStopWordsInDoc(File f) throws Exception {
        FileWriter file = new FileWriter("unusedWords.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNext()) {
            String line = sc.next();
            String[] words = line.split(" ");
            for(String str: words) {
                if(stopwords.contains(str)) {
                    file.write( str + "\n");
                }
            }
        }
        sc.close();
        file.close();
    }

}
