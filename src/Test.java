import java.io.File;
public class Test {
    public static void main(String[] args) throws Exception {
        Main m = new Main();
        File f = new File("AssetManagementDoc.txt");
        m.checkStopWordsInDoc(f);
    }
}
