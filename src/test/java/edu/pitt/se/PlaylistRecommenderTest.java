package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class PlaylistRecommenderTest {
    
    @Test
    public void testClassifyEnergy_High() {
        List<Integer> bpms = Arrays.asList(150, 160, 140);
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(bpms));
    }
    
    @Test
    public void testClassifyEnergy_Medium() {
        List<Integer> bpms = Arrays.asList(100, 120, 130);
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(bpms));
    }
    
    @Test
    public void testClassifyEnergy_NullList() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlaylistRecommender.classifyEnergy(null);
        });
    }
    
    @Test
    public void testIsValidTrackTitle_Valid() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Bohemian Rhapsody"));
    }
    
    @Test
    public void testIsValidTrackTitle_InvalidNull() {
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
    }
    
    @Test
    public void testIsValidTrackTitle_InvalidSpecialChars() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("Track123!"));
    }
    
    
    @Test
    public void testNormalizeVolume_WithinRange() {
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
    }
    
    @Test
    public void testNormalizeVolume_AboveMax() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(120));
    }
    
    @Test
    public void testNormalizeVolume_BelowMin() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-10));
    }
}
