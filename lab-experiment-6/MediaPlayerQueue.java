import java.util.*;

class Song {

    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return title + " - " + artist;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Song)) {
            return false;
        }

        Song other = (Song) obj;

        return title.equalsIgnoreCase(other.title)
                && artist.equalsIgnoreCase(other.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                title.toLowerCase(),
                artist.toLowerCase()
        );
    }
}


public class MediaPlayerQueue {

    private LinkedList<Song> playlist;

    private LinkedList<Song> history;

    private static final int MAX_HISTORY = 5;


    public MediaPlayerQueue() {
        playlist = new LinkedList<>();
        history = new LinkedList<>();
    }

    public void addSong(Song song) {

        if (playlist.contains(song)) {
            System.out.println(
                    "Duplicate song ignored: " + song
            );
            return;
        }

        playlist.addLast(song);

        System.out.println(
                "Song added: " + song
        );
    }

    public void addToFront(Song song) {

        if (playlist.contains(song)) {
            System.out.println(
                    "Duplicate song ignored: " + song
            );
            return;
        }

        playlist.addFirst(song);

        System.out.println(
                "Priority song added: " + song
        );
    }

    public void addAtPosition(Song song, int position) {

        if (playlist.contains(song)) {
            System.out.println(
                    "Duplicate song ignored: " + song
            );
            return;
        }

        if (position < 0 || position > playlist.size()) {
            System.out.println("Invalid position.");
            return;
        }

        playlist.add(position, song);

        System.out.println(
                "Song added at position " +
                position + ": " + song
        );
    }

    public void removeSong(Song song) {

        if (playlist.remove(song)) {

            System.out.println(
                    "Removed: " + song
            );

        } else {

            System.out.println(
                    "Song not found: " + song
            );
        }
    }

    public void removeDuplicates() {

        HashSet<Song> uniqueSongs = new HashSet<>();

        Iterator<Song> iterator = playlist.iterator();

        while (iterator.hasNext()) {

            Song song = iterator.next();

            if (!uniqueSongs.add(song)) {
                iterator.remove();
            }
        }

        System.out.println(
                "Duplicate songs removed."
        );
    }


    public void playSong(Song song) {

        if (!playlist.contains(song)) {

            System.out.println(
                    "Song is not present in playlist."
            );

            return;
        }

        System.out.println(
                "\nNow Playing: " + song
        );

        history.remove(song);
        history.addFirst(song);

        if (history.size() > MAX_HISTORY) {
            history.removeLast();
        }
    }


    public void displayForward() {

        ListIterator<Song> iterator =
                playlist.listIterator();

        while (iterator.hasNext()) {

            Song song = iterator.next();

            System.out.println(song);
        }
    }


    public void displayBackward() {


        ListIterator<Song> iterator =
                playlist.listIterator(playlist.size());

        while (iterator.hasPrevious()) {

            Song song = iterator.previous();

            System.out.println(song);
        }
    }

    public void displayHistory() {


        if (history.isEmpty()) {

            System.out.println(
                    "No songs played yet."
            );

            return;
        }

        for (Song song : history) {

            System.out.println(song);
        }
    }

    public static void main(String[] args) {

        MediaPlayerQueue player =
                new MediaPlayerQueue();


        Song s1 = new Song(
                "Blinding Lights",
                "The Weeknd"
        );

        Song s2 = new Song(
                "Believer",
                "Imagine Dragons"
        );

        Song s3 = new Song(
                "Perfect",
                "Ed Sheeran"
        );

        Song s4 = new Song(
                "Shape of You",
                "Ed Sheeran"
        );


        player.addSong(s1);
        player.addSong(s2);
        player.addSong(s3);



        player.addToFront(s4);


        Song s5 = new Song(
                "Faded",
                "Alan Walker"
        );

        player.addAtPosition(s5, 2);


        Song duplicate = new Song(
                "Believer",
                "Imagine Dragons"
        );

        player.addSong(duplicate);

        player.displayForward();


        player.displayBackward();


        player.playSong(s1);
        player.playSong(s3);
        player.playSong(s4);
        player.playSong(s5);

        player.displayHistory();

        player.removeSong(s2);

        player.displayForward();
    }
}
