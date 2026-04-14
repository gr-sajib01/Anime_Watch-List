package File;
import java.io.File;
import java.util.Scanner;

import Entity.Anime;
import Entity.Watchlist;

public class FileIO {
    public static void loadFromFile(Watchlist watchlist) {
        try {
            File file = new File("watchlist.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String title = parts[0];
                String genre = parts[1];
                int episodes = Integer.parseInt(parts[2]);
                String status = parts[3];
                double rating = Double.parseDouble(parts[4]);
                
                Anime anime = new Anime(title, genre, episodes, status, rating);
                watchlist.addAnime(anime);
            }
            scanner.close();
    } catch (Exception e) {
        System.out.println("Error loading from file: " + e.getMessage());
    }
}

public static void saveToFile(Watchlist watchlist) {
    try {
        java.io.FileWriter writer = new java.io.FileWriter("Watchlist.txt");
        StringBuilder sb = new StringBuilder();
        for (Anime anime : watchlist.getList()) {
            if (anime == null) {
                continue; 
            }
            sb.append(anime.getTitle()).append(",")
              .append(anime.getGenre()).append(",")
              .append(anime.getEpisodes()).append(",")
              .append(anime.getStatus()).append(",")
              .append(anime.getRating()).append("\n");
        }
        writer.write(sb.toString());
        writer.close();
    } catch (Exception e) {
        System.out.println("Error saving to file: " + e.getMessage());
    }
}


    
    
}
