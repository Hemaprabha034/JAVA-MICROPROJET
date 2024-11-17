import java.util.ArrayList;
import java.util.Scanner;

// Interface for Playlist operations
interface PlaylistOperations {
    void addSong(String title, String artist);   // Method to add a song by title and artist
    void addSong(Song song);                     // Method to add a song object directly
    void removeSong(String title);                // Method to remove a song by title
    void displayPlaylist();                       // Method to display the playlist
}

// Base class - Song
class Song {
    private String title;
    private String artist;

    // Constructor to create a new song
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getters for title and artist
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    // Override toString() to display song details
    @Override
    public String toString() {
        return "Song: " + title + " by " + artist;
    }
}

// Playlist class implements PlaylistOperations interface
class Playlist implements PlaylistOperations {
    private ArrayList<Song> songs; // Using ArrayList to store the playlist

    // Constructor initializes the playlist
    public Playlist() {
        songs = new ArrayList<>();
    }

    // Add a song to the playlist (Method Overloading)
    @Override
    public void addSong(String title, String artist) {
        songs.add(new Song(title, artist));
    }

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }

    // Remove a song from the playlist
    @Override
    public void removeSong(String title) {
        songs.removeIf(song -> song.getTitle().equalsIgnoreCase(title));
    }

    // Display all songs in the playlist
    @Override
    public void displayPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("\n--- Playlist ---");
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();

        while (true) {
            // Display menu options
            System.out.println("\n--- Music Playlist Menu ---");
            System.out.println("1. Add Song (by Title & Artist)");
            System.out.println("2. Add Song (by Song Object)");
            System.out.println("3. Remove Song");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");

            // Get user input
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Add song to playlist by title and artist
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter song artist: ");
                    String artist = scanner.nextLine();
                    playlist.addSong(title, artist); // Using method overloading
                    System.out.println("Song added to the playlist!");
                    break;

                case 2:
                    // Add song to playlist by song object
                    System.out.print("Enter song title: ");
                    String titleObj = scanner.nextLine();
                    System.out.print("Enter song artist: ");
                    String artistObj = scanner.nextLine();
                    Song newSong = new Song(titleObj, artistObj);
                    playlist.addSong(newSong); // Using method overloading
                    System.out.println("Song added to the playlist!");
                    break;

                case 3:
                    // Remove song from playlist
                    System.out.print("Enter the title of the song to remove: ");
                    String removeTitle = scanner.nextLine();
                    playlist.removeSong(removeTitle);
                    System.out.println("Song removed from the playlist (if it existed).");
                    break;

                case 4:
                    // Display current playlist
                    playlist.displayPlaylist();
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting the playlist application...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
