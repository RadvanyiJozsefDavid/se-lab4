package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test 
    void is_Empty(){
        TorpedoStore storeEmpty = new TorpedoStore(0);
        TorpedoStore store = new TorpedoStore(1);

        assertEquals(true, storeEmpty.isEmpty());
        assertEquals(false, store.isEmpty());
    }

    @Test 
    void get_Torpedo_Count(){
        int numOfTorpedoes = 5;
        TorpedoStore store = new TorpedoStore(numOfTorpedoes);

        assertEquals(numOfTorpedoes, store.getTorpedoCount());
    }

    @Test 
    void fire_Faliure(){
        TorpedoStore store = new TorpedoStore(5, 1);

        boolean result = store.fire(1);

        assertEquals(false, result);
    }
    @Test 
    void fire_Zero(){
        TorpedoStore store = new TorpedoStore(5);
        
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(0);
        });
    }

    @Test
    void fire_More(){
        TorpedoStore store = new TorpedoStore(5);
        
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(10);
        });
    }
}
