package alessiovulpinari.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue
    private UUID location_id;

    @Column(name = "Name")
    private String name;

    @Column(name = "City")
    private String city;

    @OneToMany(mappedBy = "location")
    private List<Event> eventList;

    public Location() {
    }

    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public UUID getLocation_id() {
        return location_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", location_id=" + location_id +
                '}';
    }
}
