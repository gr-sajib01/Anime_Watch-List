package Entity;
public class Watchlist {
    private final int maxSize = 100;
    private Anime[] list = new Anime[maxSize];
    
    

    public void addAnime(Anime anime) {
    int firstNullIndex = -1;
    
    
    for (int i = 0; i < list.length; i++) {
        if (list[i] != null) {
            
            if (list[i].getTitle().equals(anime.getTitle())) {
                System.out.println("Anime already exists in watchlist.");
                return;
            }
        } else if (firstNullIndex == -1) {
            
            firstNullIndex = i;
        }
    }
    
    
    if (firstNullIndex != -1) {
        list[firstNullIndex] = anime;
        System.out.println("Anime added to watchlist.");
    } else {
        System.out.println("Watchlist is full. Cannot add more anime.");
    }
}

    public void removeAnime(String title) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getTitle().equals(title)) {
                
                list[i] = null;
                
                System.out.println("Anime removed from watchlist.");
                break;
            }

            else {
                System.out.println("Anime not found in watchlist.");
            }
        }
        
    }

    public  void updateAnime(String title, String genre, int episodes, String status, double rating) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getTitle().equals(title)) {
                list[i].setGenre(genre);
                list[i].setepisodes(episodes);
                list[i].setStatus(status);
                list[i].setRating(rating);
                System.out.println("Anime updated in watchlist.");
                return;
            }
        }
    }

    public void showWatchlist() {
        System.out.println("Your watchlist:");
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                System.out.println("Title: " + list[i].getTitle());
                System.out.println("Genre: " + list[i].getGenre());
                System.out.println("Episodes: " + list[i].getEpisodes());
                System.out.println("Status: " + list[i].getStatus());
                System.out.println("Rating: " + list[i].getRating());
            }
        }
    }

    public String getWatchlist () {
        StringBuilder watchlist = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                watchlist.append("Title: ").append(list[i].getTitle()).append("\n");
                watchlist.append("Genre: ").append(list[i].getGenre()).append("\n");
                watchlist.append("Episodes: ").append(list[i].getEpisodes()).append("\n");
                watchlist.append("Status: ").append(list[i].getStatus()).append("\n");
                watchlist.append("Rating: ").append(list[i].getRating()).append("\n").append("------------------\n");
            }
        }
        return watchlist.toString();
    }

    public Anime[] getList() {
        return list;
    }

    public Anime getAnime(String title) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].getTitle().equals(title)) {
                return list[i];
            }
        }
        return null;
    }


    
}
