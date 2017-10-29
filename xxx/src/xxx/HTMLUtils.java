package xxx;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import com.google.common.base.Charsets;
import org.jsoup.Jsoup;

public class HTMLUtils {
  private HTMLUtils() {}
  static ArrayList<String> all = new ArrayList<String>();
  public static String extractText(Reader reader) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(reader);
    String line;
    while ( (line=br.readLine()) != null) {
      sb.append(line);
      String textOnly = Jsoup.parse(sb.toString()).text();
      all.add(textOnly);
      System.out.println(textOnly);
      sb.append("#");
      br.readLine();
    }
    //String textOnly = Jsoup.parse(sb.toString()).text();
    return "dfdf";
  }

  public final static void main(String[] args) throws Exception{
   FileReader reader = new FileReader("E:\\1.html");
    System.out.println(HTMLUtils.extractText(reader));
  }
}