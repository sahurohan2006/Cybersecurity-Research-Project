import java.io.File;
import java.util.Scanner;
import java.util.*;

public class Test{

    public static void main(String[] args) throws Exception {

        ArrayList<Map<String,Word>> docsStats = new ArrayList<>();

        File corpus = new File("/Users/shalinisahu/Desktop/Research Project/corpus1");
        File docs[] = corpus.listFiles();
        for (File f : docs) {
            if (f.isFile()) {
                docsStats.add(calcuatetfIDF(f, docs.length));
            }
        }


        // create a separate method

        for( Map<String, Word> tokensInDoc : docsStats) {


            List<String> vals = new LinkedList<String>(tokensInDoc.keySet());

            Collections.sort(vals, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    if (tokensInDoc.get(o1).getTFIDF() > tokensInDoc.get(o2).getTFIDF()) {
                        return -1;
                    }
                    if (tokensInDoc.get(o1).getTFIDF() < tokensInDoc.get(o2).getTFIDF()) {
                        return 1;
                    }
                    return 0;
                }
            });

            Map<String, Word> sorted = new HashMap<>();
            Iterator it = vals.iterator();
            while (it.hasNext()) {
                String temp = (String) it.next();
                sorted.put(temp, tokensInDoc.get(temp));
            }

            int i = 0;
            for (String str : sorted.keySet()) {
                if( i<5 ) {
                    System.out.println(str + " --> " + sorted.get(str).getTFIDF());
                    i++;
                }else{
                    break;
                }
            }
            System.out.println("----------------");
        }




        // read the stop words and add them into a list or instantiate the existing class

        // read all files in a loop
        // per each file invoke calculate TF





        /*
        File doc2 = new File("AssetManagementDoc#2");
        sc = new Scanner(doc2);
        while(sc.hasNext()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            for(String s:words) {
                Word w = new Word(s);
                allWords.add(w);
                TF t = new TF(doc2, w);
                t.TFIDF();
                map.put(w.getTFIDF(), w);

            }
        }
        File doc3 = new File("AssetManagementDoc#3");
         sc = new Scanner(doc3);
        while(sc.hasNext()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            for(String s:words) {
                Word w = new Word(s);
                allWords.add(w);
                TF t = new TF(doc3, w);
                t.TFIDF();
                map.put(w.getTFIDF(), w);

            }
        }

        File doc4 = new File("AssetManagementDoc#4");
        sc = new Scanner(doc4);
        while(sc.hasNext()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            for(String s:words) {
                Word w = new Word(s);
                TF t = new TF(doc4, w);
                t.TFIDF();
                map.put(w.getTFIDF(), w);

            }
        }

        File doc5 = new File("AssetManagementDoc#5");
        sc = new Scanner(doc5);
        while(sc.hasNext()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            for(String s:words) {
                Word w = new Word(s);
                TF t = new TF(doc5, w);
                t.TFIDF();
                map.put(w.getTFIDF(), w);

            }
        }

        File doc6 = new File("AssetManagementDoc#6");
        sc = new Scanner(doc6);
        while(sc.hasNext()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            for(String s:words) {
                Word w = new Word(s);
                TF t = new TF(doc6, w);
                t.TFIDF();
                map.put(w.getTFIDF(), w);

            }
        }

        File doc7 = new File("AssetManagementDoc#7");
        sc = new Scanner(doc7);
        while(sc.hasNext()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            for(String s:words) {
                Word w = new Word(s);
                TF t = new TF(doc7, w);
                t.TFIDF();
                map.put(w.getTFIDF(), w);

            }
        }


        for(Double d: map.keySet()) {
            System.out.println(d + " --> " + map.get(d));
        }

*/


        /*







         */





        /*




        sc4.close();

        sc5.close();

        sc6.close();

        sc7.close();



         */
    }

    static Map<String, Word> calcuatetfIDF(File f, int numFiles) throws Exception {
        int totalWords = 0;
        Stopwords s = new Stopwords();

        //System.out.println(stopwords);
        Map<String,Word> tokensInDoc = new HashMap<>();

        Scanner sc = new Scanner(f);
        Word w;

        while (sc.hasNext()) {
            String line = sc.nextLine();

            // remove all not alphanumeric symbols from the line
            // regular expression
            line = line.replaceAll("[^a-zA-Z0-9]", " ");



            String[] words = line.split(" ");

            for (String x : words) {
                Set<String> stopwords = s.getWords();
                // use tokensInDoc to count the number of occurrnces for each word
                //x = x.trim();

                if (!s.containsWord(x.toLowerCase()) && tokensInDoc.containsKey(x.toLowerCase()) && x.length() > 0) {
                    //System.out.println("***" + x + "***" );
                    tokensInDoc.get(x.toLowerCase()).incrementFrequency();

                    // tokensInDoc.put(x, tokensInDoc.get(x) + 1);

                    //}
                } else if(!s.containsWord(x.toLowerCase())) {
                    w = new Word(x.toLowerCase());
                    w.incrementFrequency();
                    w.incrementNumDocsWithWord();
                    tokensInDoc.put(x.toLowerCase(), w);
                   }
                }
                totalWords++;
                // Loop through the map and create word objects

            }


        for (String str : tokensInDoc.keySet()) {
            double tempTF = (double) Math.log( 1 + ((double) tokensInDoc.get(str).getFrequency()/totalWords));
            tokensInDoc.get(str).setTF(tempTF);
            double tempIDF = Math.log((double) numFiles/((double) tokensInDoc.get(str).getNumDocsWithWord()+1));
            tokensInDoc.get(str).setIDF(tempIDF);
            tokensInDoc.get(str).setTFIDF(tempTF/tempIDF);
        }

        return tokensInDoc;

    }


}
