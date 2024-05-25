package ch.zhaw.iwi.devops.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/buecher") // Ändere den Basispfad
public class BuchController {

    private Map<Integer, Buch> buecher = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        buecher.put(1, new Buch(1, "Der Herr der Ringe", "J.R.R. Tolkien"));
        buecher.put(2, new Buch(2, "Harry Potter", "J.K. Rowling"));
        buecher.put(3, new Buch(3, "Die Verwandlung", "Franz Kafka"));
        System.out.println("Init Daten für Bücher geladen");
    }

    @GetMapping("/{id}")
    public Buch getBuch(@PathVariable Integer id) {
        Buch buch = buecher.get(id);
        if (buch == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Buch mit ID " + id + " nicht gefunden");
        }
        return buch;
    }

    @GetMapping("/")
    public Collection<Buch> getAllBuecher() {
    return buecher.values();
    }

    @PostMapping("/")
    public Buch addBuch(@RequestBody Buch buch) {
        int newId = buecher.keySet().stream().max(Integer::compare).orElse(0) + 1;
        buch.setId(newId);
        buecher.put(newId, buch);
        return buch;
    }

    @DeleteMapping("/{id}")
    public Buch deleteBuch(@PathVariable Integer id) {
        Buch removedBuch = buecher.remove(id);
        if (removedBuch == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Buch mit ID " + id + " nicht gefunden");
        }
        return removedBuch;
    }

    @PutMapping("/{id}")
    public Buch updateBuch(@PathVariable int id, @RequestBody Buch buch) {
        if (!buecher.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Buch mit ID " + id + " nicht gefunden");
        }
        buch.setId(id);  // Stelle sicher, dass die ID nicht geändert wird.
        buecher.put(id, buch);  // Aktualisiere das Buch in der Map.
        return buch;  // Gib das aktualisierte Buch zurück.
    }
}
