package Crawler;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RelicnguoikesuCrawler extends AbstractCrawler {

	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		int MAX_PAGE = 30;
		int STEP_PAGE = 10;
		LinkedList crawler = new LinkedList<>();
		String ROOT_URL = "https://nguoikesu.com"; // root url
		for (int i=0; i<MAX_PAGE; i+=STEP_PAGE) {
			try {
				String url = ROOT_URL +"/di-tich-lich-su?start=" + Integer.toString(i);
				Document doc = Jsoup.connect(url).get(); // connect to server
				for (Element sup: doc.select("sup")) // remove all notes
					sup.remove();
				Elements el = doc.select("li.list-group-item").select("h3").select("a[href^=/dia-danh/]");
				// select all elements that have class "li.list-group-item", "h3" and have hyper reference "/dia-danh/"
				for (Element sup: el) {
					String eleName = sup.text();
//					System.out.println(eleName);   // print all the names of relics
					HashMap<String, String> addInfo = new HashMap<String, String>();
					
			    	String relic_info_url = ROOT_URL+ sup.attr("href"); 
			    	Document info = Jsoup.connect(relic_info_url).get(); // connect to each relic in the document
			    	Elements relic_info = info.select("div.infobox"); // select all elements that contain class "div.infobox"
			    	System.out.println(relic_info.text());
			    	for (Element relic_info_ele: relic_info) {
			    		addInfo.put(relic_info_ele.text(), relic_info_ele.parent().select("td").text());
			    		// select and add information of the relic
//			    		System.out.println(relic_info_ele.text()); // print information of each relic 
			    	}
				}
			} catch (Exception e) {
				System.out.println(e);  
			}
		}
	}
//	testing
	public static void main(String[] args) throws Exception {
        RelicnguoikesuCrawler crawler = new RelicnguoikesuCrawler();
//        crawler.start();
    }

}
