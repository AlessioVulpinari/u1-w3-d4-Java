package alessiovulpinari.expetions;

import java.util.UUID;

public class NotFoundExp extends RuntimeException {
    public NotFoundExp(UUID eventId) {
        System.out.println("Evento con id: " + eventId.toString() + " non trovato!");
    }
}
