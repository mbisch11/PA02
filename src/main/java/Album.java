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

    public int addSong(){
        numSongs++;
        return numSongs;
    }

    public int removeSong(){
        numSongs--;
        return removeSong();
    }

    public void addArtist(String artist){
        artists.add(artist);
    }

    public String removeArtistAtIndex(int index){
        String artist = artists.get(index);
        artists.remove(index);
        return artist;
    }

    @Override
    public String toString(){
        String returnString = idNum + ":" + numSongs + " -- " + artists;
        return returnString;
    }

    @Override
    public int compareTo(Object o) {
        Album comparator = (Album) o;
        if(this.numSongs > comparator.numSongs){
            return 1;
        } else if (this.numSongs < comparator.numSongs) {
            return -1;
        } else {
            return 0;
        }
    }
}
