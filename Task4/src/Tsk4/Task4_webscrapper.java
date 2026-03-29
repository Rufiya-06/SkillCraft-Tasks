package Tsk4;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class Task4_webscrapper {
	   public static void main(String[] args) {
	        String url = "https://books.toscrape.com/";
	        String websiteType = "E-commerce (Books Store)";
	        try {
	            System.out.println("Java Web Scraper (Jsoup)");
	            System.out.println("Connecting to: " + url);
	            System.out.println("Website Type: " + websiteType);

	            Document doc = Jsoup.connect(url).get();
	            System.out.println("Connection successful!\n");

	            System.out.println("Fetching product details...");

	            Elements products = doc.select(".product_pod");

	            FileWriter writer = new FileWriter("products.csv");
	            writer.append("Title,Price,Rating\n");

	            for (Element product : products) {

	                String title = product.select("h3 a").attr("title");
	                String price = product.select(".price_color").text();
	                String rating = product.select(".star-rating")
	                        .attr("class")
	                        .replace("star-rating", "")
	                        .trim();

	                writer.append(title).append(",")
	                        .append(price).append(",")
	                        .append(rating).append("\n");
	            }

	            writer.close();

	            System.out.println("Scraping completed successfully!");
	            System.out.println("Total products extracted: " + products.size());
	            System.out.println("Data saved to 'products.csv'");

	        } catch (IOException e) {
	            System.out.println("Error occurred: " + e.getMessage());
	        }
	    }
	}
