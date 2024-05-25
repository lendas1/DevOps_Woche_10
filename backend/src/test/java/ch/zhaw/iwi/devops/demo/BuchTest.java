package ch.zhaw.iwi.devops.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BuchTest {
    @Test
    void testSetTitel() {
        // Testet den Setter für den Titel.
        Buch buch = new Buch();
        buch.setTitel("1984");
        assertEquals("1984", buch.getTitel());
    }

    @Test
    void testSetAutor() {
        Buch buch = new Buch();
        buch.setAutor("George Orwell");
        assertEquals("George Orwell", buch.getAutor());
    }

    @Test
    void testGetId() {
        Buch buch = new Buch();
        buch.setId(1);
        assertEquals(1, buch.getId());
    }

    @Test
    void testGetTitel() {
        Buch buch = new Buch();
        buch.setTitel("1984");
        assertEquals("1984", buch.getTitel());
    }

    @Test
    void testGetAutor() {
        Buch buch = new Buch();
        buch.setAutor("George Orwell");
        assertEquals("George Orwell", buch.getAutor());
    }

    @Test
    void testDefaultConstructor() {
        Buch buch = new Buch();
        assertNotNull(buch);
    }

    @Test
    void testParameterizedConstructor() {
        Buch buch = new Buch(1, "1984", "George Orwell");
        assertEquals(1, buch.getId());
        assertEquals("1984", buch.getTitel());
        assertEquals("George Orwell", buch.getAutor());
    }

    @Test
    void testSetId() {
        Buch buch = new Buch();
        buch.setId(1);
        assertEquals(1, buch.getId());
    }

}