import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class TF {
    private static double numDocs;
    private File f;
    private static double numDocsWithWord;
    private Word w;

    public TF(File f, Word w) throws Exception {
        this.f = f;
        numDocs++;
        this.w = w;

    }

    public boolean hasWord() throws Exception {
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            String line = sc.next();
            String[] words = line.split(" ");
            for (String str : words) {
                if (str.toLowerCase().equals(w.getWord().toLowerCase()) && !w.isStopWord()) {
                    return true;
                }
            }

        }
        return false;

    }

    public double calcTF() throws Exception {
        if(hasWord()) {
            numDocsWithWord++;
        }
        double totalCount = 0;
        double wordCount = 0;
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            String line = sc.next();
            String[] words = line.split(" ");
            for (String str : words) {
                if(str.toLowerCase().equals(w.getWord().toLowerCase()) && !w.isStopWord()) {
                    wordCount++;
                }
                totalCount++;
            }
        }
        return wordCount/totalCount;
    }

    public double calcIDF() throws Exception {
        return Math.log(numDocs/(numDocsWithWord+1));
    }

    public void TFIDF() throws Exception {
        w.setTFIDF(calcTF()/calcIDF());
    }

}

