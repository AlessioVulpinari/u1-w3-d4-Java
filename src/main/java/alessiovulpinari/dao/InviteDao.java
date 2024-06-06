package alessiovulpinari.dao;

import alessiovulpinari.entities.Invite;
import alessiovulpinari.expetions.NotFoundExp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class InviteDao {

    private final EntityManager entityManager;

    public InviteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Invite invite) {
        // Aprire la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // Iniziare la transazione
        transaction.begin();

        // Aggiungere al persist Context
        entityManager.persist(invite);

        // Chiudere la transazione, salvando nel db
        transaction.commit();
        System.out.println("Invito: " + invite.getInviteId() + " è stato aggiunto correttamente al db!");
    }

    public Invite getEventById(UUID inviteId) {
        Invite invite = entityManager.find(Invite.class, inviteId);

        if (invite == null) throw new NotFoundExp(inviteId);

        return invite;
    }

    public void deleteEventById(UUID inviteId) {
        // Cerchiamo l'evento
        Invite foundInvite = getEventById(inviteId);

        // Creo la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // Inizializzo la transazione
        transaction.begin();

        // Rimuovo l'evento
        entityManager.remove(foundInvite);

        // Chiudo la transazione e salvo il cambiamento
        transaction.commit();

        System.out.println("Invito: " + foundInvite.getInviteId() + " è stato eliminato correttamente al db!");
    }
}
