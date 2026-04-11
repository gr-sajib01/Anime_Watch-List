package Entity;

public class Anime extends Media {
    private String title;
    private String genre;
    private int episodes;
    private String status;
    private double rating;



    public Anime(String title, String genre, int episodes, String status , double rating) {
        setTitle(title);
        setGenre(genre);
        setepisodes(episodes);
        this.status = status;
        setRating(rating);
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    
    public void setGenre(String genre) {  
            this.genre = genre; 
    }
    public String getGenre() {
        return genre;
    }

    public void setepisodes(int episodes) {
        if (episodes > 0) {
            this.episodes = episodes;
        } else {
            throw new IllegalArgumentException("Number of episodes must be greater than 0");
        }
    }
    public int getEpisodes() {
        return episodes;
    }



    public void setStatus(String status) {
        
            this.status = status;
       
    }
    
    public String getStatus() {
        return status;
    }

    public void setRating (double rating) {
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        }
    }

    public double getRating() {
        return rating;
    }

    @Override
    public void showDetails() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Episodes: " + episodes);
        System.out.println("Status: " + status);
        System.out.println("Rating: " + rating);
    }

    public String getAnime(){
        return "Title: " + title + "\n" +
               "Genre: " + genre + "\n" +
               "Episodes: " + episodes + "\n" +
               "Status: " + status + "\n" +
               "Rating: " + rating;
    }

    
}
