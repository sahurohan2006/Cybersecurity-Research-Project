public class Word {
    private String word;
    private double TF;
    private double IDF;
    private double TFIDF;
    private int frequency;
    private int numDocsWithWord;

    public Word(String word) {
        this.word = word;
        this.TF = 0;
        this.IDF = 0;
        this.TFIDF = 0;
        this.frequency = 0;
    }

    public void incrementFrequency() {
        this.frequency++;
    }
    public void incrementNumDocsWithWord() {
        this.numDocsWithWord++;
    }

    public int getNumDocsWithWord() {
        return numDocsWithWord;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public double getTF() {
        return TF;
    }

    public void setTF(double TF) {
        this.TF = TF;
    }

    @Override
    public String toString() {
        return word;
    }

    public double getIDF() {
        return IDF;
    }

    public void setIDF(double IDF) {
        this.IDF = IDF;
    }

    public double getTFIDF() {
        return TFIDF;
    }

    public void setTFIDF(double TFIDF) {
        this.TFIDF = TFIDF;
    }

    public boolean isStopWord() throws Exception {
        Stopwords s = new Stopwords();
        if(s.getWords().contains(word.toLowerCase())) {
            return true;
        }
        return false;
    }

    public String getWord() {
        return word;
    }

    // add a comparator to sort Word objects based on TFIDF value

}
