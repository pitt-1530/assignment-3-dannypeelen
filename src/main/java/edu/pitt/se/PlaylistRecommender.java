package edu.pitt.se;
import java.util.List;

public class PlaylistRecommender {
    
    public static String classifyEnergy(List<Integer> bpms) {
        // Reject null or empty lists
        if (bpms == null || bpms.isEmpty()) {
            throw new IllegalArgumentException("BPM list cannot be null or empty");
        }
        
        // Calculate average BPM
        double sum = 0;
        for (int bpm : bpms) {
            sum += bpm;
        }
        double avgBpm = sum / bpms.size();
        
        // Classify based on average
        if (avgBpm >= 140) {
            return "HIGH";
        } else if (avgBpm >= 100) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }
    
    public static boolean isValidTrackTitle(String title) {

        if (title == null) {
            return false;
        }
        
        // Check length (1-30 characters)
        if (title.length() < 1 || title.length() > 30) {
            return false;
        }
        
        // Check that it contains only alphabetic characters and spaces
        for (char c : title.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        
        return true;
    }
    
    public static int normalizeVolume(int volumeDb) {
        // Clamp volume to range 0-100
        if (volumeDb < 0) {
            return 0;
        } else if (volumeDb > 100) {
            return 100;
        } else {
            return volumeDb;
        }
    }
}
