package alessiovulpinari;

import alessiovulpinari.dao.EventDao;
import alessiovulpinari.dao.InviteDao;
import alessiovulpinari.dao.LocationDao;
import alessiovulpinari.dao.PersonDao;
import alessiovulpinari.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u1-w3-d3-Java");

    public static void main(String[] args) {

        EntityManager em = entityManagerFactory.createEntityManager();
        PersonDao personDao = new PersonDao(em);
        LocationDao locationDao = new LocationDao(em);
        InviteDao inviteDao = new InviteDao(em);
        EventDao eventDao = new EventDao(em);

        Person davide = new Person(Gender.M, LocalDate.now(), "davideABBA@gmail.com,",
                "Abadessa", "Davide");

//        personDao.save(davide);
        Person davideFromDb = personDao.getEventById(UUID.fromString("29503afd-c3b0-4379-9e2f-d77399dd4b5a"));
        System.out.println(davideFromDb);

        Location arenaDiVerona = new Location("Arena di Verona", "Verona");
//        locationDao.save(arenaDiVerona);
        Location arenaDiVeronaDaDb = locationDao.getEventById(UUID.fromString("661595ef-5913-40a9-9fff-71bb04fd06a4"));
        System.out.println(arenaDiVeronaDaDb);

        Event luccaComixAndGames = new Event(arenaDiVeronaDaDb, "Lucca Comix and Games 2024", LocalDate.now(), "Bella fiera piena di belle persone in cosplay",
                EventTypes.PUBBLIC, 20000000);
//        eventDao.save(luccaComixAndGames);
        Event lucca = eventDao.getEventById(UUID.fromString("0148a7f3-8315-4a29-b990-094622adc674"));

        Invite invite = new Invite(State.CONFIRMED, lucca, davideFromDb);
//        inviteDao.save(invite);
        System.out.println(inviteDao.getEventById(UUID.fromString("7d347980-d3fc-4b9a-bdb8-b0cf4819f9b3")));
    }
}
