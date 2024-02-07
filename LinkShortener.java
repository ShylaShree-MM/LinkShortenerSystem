import java.util.HashMap;
import java.util.Random;

public class LinkShortener {
    private HashMap<String, String> shortToLongMap;
    private HashMap<String, String> longToShortMap;
    public LinkShortener() {
        shortToLongMap = new HashMap<>();
        longToShortMap = new HashMap<>();
    }
    public String shortenURL(String longURL) {
        if (longToShortMap.containsKey(longURL)) {
            return longToShortMap.get(longURL);
        } else {
            String shortURL = generateShortURL();
            shortToLongMap.put(shortURL, longURL);
            longToShortMap.put(longURL, shortURL);
            return shortURL;
        }
    }
    public String expandURL(String shortURL) {
        if (shortToLongMap.containsKey(shortURL)) {
            return shortToLongMap.get(shortURL);
        } else {
            return "Short URL not found";
        }
    }
    private String generateShortURL() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortURL = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            shortURL.append(characters.charAt(random.nextInt(characters.length())));
        }
        return "http://short.url/" + shortURL.toString();
    }
    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();

        String longURL = "https://www.example.com/very-long-url-that-needs-to-be-shortened";
        String shortURL = linkShortener.shortenURL(longURL);
        System.out.println("Shortened URL: " + shortURL);

        String expandedURL = linkShortener.expandURL(shortURL);
        System.out.println("Expanded URL: " + expandedURL);
    }
}
