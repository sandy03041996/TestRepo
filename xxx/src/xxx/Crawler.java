package xxx;
import java.awt.Font;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfDocument;



public class Crawler {

	private HashSet<String> links;
    private static int counter=1;
    
    public Crawler() {
        links = new HashSet<String>();
    }

    public void getPageLinks(String URL) throws Exception {
        
    	 if (!links.contains(URL)) {           //Check if you have already crawled the URLs
             try {
             	
             	
                 if (links.add(URL)) {  //check if link was added to HashSet links 
                 	System.out.println(URL);
                 }	
                     URL url = new URL(URL);
         			URLConnection u = url.openConnection();
         			String type = u.getHeaderField("Content-Type");
                 	
                 	if(type.equals("text/html;charset=UTF-8")){
                 	
                         InputStream in = url.openStream();

                         OutputStream fos = new FileOutputStream("E:\\"+counter+".html");

                         int length = -1;

                         byte[] buffer = new byte[1024];

                         while((length = in.read(buffer)) != -1) {

                             fos.write(buffer, 0, length);

                         }            

                 		counter++;
                 		//Fetch the HTML code
                 		Document document = Jsoup.connect(URL).ignoreHttpErrors(true).followRedirects(true).get();
                 
                 		//Parse the HTML to extract links to other URLs
                 		Elements linksOnPage = (Elements) document.select("a[href]");
                 
                 		//For each extracted URL call function getPageLinks
                 		for (Element page : linksOnPage) {
                 				getPageLinks(page.attr("abs:href"));
                 		}
                 		
                 		
                 		
                 		
                 		
                 	}
                 	
             } catch (IOException e) {
                 System.err.println("For '" + URL + "': " + e.getMessage());
             }
         }

    
    }

    
    
    

    public static void main(String[] args) throws Exception {
        
        new Crawler().getPageLinks("http://catalogue.jumbo.mu/9308/epicerie");  //Pick a URL and call getPageLinks function
    }

	
	
	
	
	
}
