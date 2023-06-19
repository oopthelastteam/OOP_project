package Crawler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Wiki {
//	get document from wikipedia by the given url
	public static Document getDocument(String url) {
		Document doc = null;
		try {
            doc = Jsoup.connect(url).get();
            Elements sups = doc.select("sup");
    		for (Element sup: sups) sup.remove(); // remove all notes    		
        } catch (Exception e) {
            e.printStackTrace();
        }
		return doc;
	}
//	get the headers of the given table
	public static List<String> getTableHeaders(Element table) {
		if (table == null) 
			return null;
		
		Elements headers = table.select("table tbody > tr th");
		int numHeaders = headers.size();
		
		List<String> listHeaderTexts = new ArrayList<String>(numHeaders);
		
		for (Element header: headers) {
			listHeaderTexts.add(header.text());
		}
		
		return listHeaderTexts;
	}
//	get the contents of the given table
	public static List<List<Element>> getTableElements(Element table){
		Elements rect = table.select("table tbody > tr");
		
		int rows = rect.size() - 1; // remove the first row containing the table's header
		int cols = rect.get(0).select("th").size();
		
		List<List<Element>> elements = new ArrayList<List<Element>>(rows);
		
		for (int i = 0; i < rows; i++) {
			ArrayList<Element> temp = new ArrayList<Element>(cols);
			for (int j = 0; j < cols; j++) temp.add(null);
			elements.add(new ArrayList<Element>(temp));
		}
		
		
	}
}
