package alessiovulpinari.dao;

import alessiovulpinari.entities.Location;
import alessiovulpinari.expetions.NotFoundExp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDao {


    private final EntityManager entityManager;

    public LocationDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location location) {
        // Aprire la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // Iniziare la transazione
        transaction.begin();

        // Aggiungere al persist Context
        entityManager.persist(location);

        // Chiudere la transazione, salvando nel db
        transaction.commit();
        System.out.println("Luogo: " + location.getName() + " è stato aggiunto correttamente al db!");
    }

    public Location getEventById(UUID locationId) {
        Location location = entityManager.find(Location.class, locationId);

        if (location == null) throw new NotFoundExp(locationId);

        return location;
    }

    public void deleteEventById(UUID locationId) {
        // Cerchiamo l'evento
        Location foundLocation = getEventById(locationId);

        // Creo la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // Inizializzo la transazione
        transaction.begin();

        // Rimuovo l'evento
        entityManager.remove(locationId);

        // Chiudo la transazione e salvo il cambiamento
        transaction.commit();

        System.out.println("Location: " + foundLocation.getName() + " è stato eliminata correttamente al db!");
    }
}
