package Crawler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RelicWikiCrawler extends AbstractCrawler {
	public void start() throws Exception{
		LinkedList crawler = new LinkedList<>();
		String url = "https://vi.wikipedia.org/wiki/Danh_sách_Di_tích_quốc_gia_Việt_Nam";
		Document doc = Wiki.getDocument(url); // connection to wikipedia
		Elements tableEles = doc.select(".wikitable"); // select tables
		
		for (Element element : tableEles) {
			List<String> table_header = Wiki.getTableHeaders(doc);
			
		}
		
		
	}
	
//	test
	public static void main(String[] args) throws Exception {
		RelicWikiCrawler crawler = new RelicWikiCrawler();
		crawler.start();
	}
}
