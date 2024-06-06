package alessiovulpinari.dao;

import alessiovulpinari.entities.Event;
import alessiovulpinari.expetions.NotFoundExp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventDao {
    private final EntityManager entityManager;

    public EventDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Event event) {
        // Aprire la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // Iniziare la transazione
        transaction.begin();

        // Aggiungere al persist Context
        entityManager.persist(event);

        // Chiudere la transazione, salvando nel db
        transaction.commit();
        System.out.println("Evento: " + event.getDescription() + " è stato aggiunto correttamente al db!");
    }

    public Event getEventById(UUID eventId) {
        Event event = entityManager.find(Event.class, eventId);

        if (event == null) throw new NotFoundExp(eventId);

        return event;
    }

    public void deleteEventById(UUID eventId) {
        // Cerchiamo l'evento
        Event foundEvent = getEventById(eventId);

        // Creo la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // Inizializzo la transazione
        transaction.begin();

        // Rimuovo l'evento
        entityManager.remove(foundEvent);

        // Chiudo la transazione e salvo il cambiamento
        transaction.commit();

        System.out.println("Evento: " + foundEvent.getDescription() + " è stato eliminato correttamente al db!");
    }
}
