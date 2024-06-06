package alessiovulpinari.dao;

import alessiovulpinari.entities.Person;
import alessiovulpinari.expetions.NotFoundExp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonDao {
    private final EntityManager entityManager;

    public PersonDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Person person) {
        // Aprire la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // Iniziare la transazione
        transaction.begin();

        // Aggiungere al persist Context
        entityManager.persist(person);

        // Chiudere la transazione, salvando nel db
        transaction.commit();
        System.out.println("Persona: " + person.getSurname() + " è stata aggiunto correttamente al db!");
    }

    public Person getEventById(UUID personId) {
        Person person = entityManager.find(Person.class, personId);

        if (person == null) throw new NotFoundExp(personId);

        return person;
    }

    public void deleteEventById(UUID personId) {
        // Cerchiamo l'evento
        Person foundPerson = getEventById(personId);

        // Creo la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // Inizializzo la transazione
        transaction.begin();

        // Rimuovo l'evento
        entityManager.remove(foundPerson);

        // Chiudo la transazione e salvo il cambiamento
        transaction.commit();

        System.out.println("Persona: " + foundPerson.getSurname() + " è stato eliminato correttamente al db!");
    }
}
