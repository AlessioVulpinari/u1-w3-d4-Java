package alessiovulpinari.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Invite")
public class Invite {

    @Id
    @GeneratedValue
    private UUID inviteId;

    @Column
    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Invite() {
    }

    public Invite(State state, Event event, Person person) {
        this.state = state;
        this.event = event;
        this.person = person;
    }

    public UUID getInviteId() {
        return inviteId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Invite{" +
                "event=" + event +
                ", inviteId=" + inviteId +
                ", state=" + state +
                ", person=" + person +
                '}';
    }
}
