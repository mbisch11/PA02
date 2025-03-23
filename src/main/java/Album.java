import java.util.ArrayList;

public class Album implements Comparable{
    private int idNum;
    private ArrayList<String> artists;
    private String title;
    private int numSongs;

    public Album(int idNum, ArrayList<String> artists, String title, int numSongs){
        this.idNum = idNum;
        this.artists = artists;
        this.title = title;
        this.numSongs = numSongs;
    }

    public Album(int idNum, String title, int numSongs){
        this.idNum = idNum;
        this.artists = new ArrayList<>();
        this.title = title;
        this.numSongs = numSongs;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
