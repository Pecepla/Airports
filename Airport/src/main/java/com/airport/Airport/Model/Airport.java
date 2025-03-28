package com.airport.Airport.Model;


import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;


    @Entity
    public class Airport {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String code;
        private String city;
        private String country;

        @OneToMany(mappedBy = "departureAirport", cascade = CascadeType.ALL)
        private List<Flight> departingFlights;

        @OneToMany(mappedBy = "arrivalAirport", cascade = CascadeType.ALL)
        private List<Flight> arrivingFlights;

        public Airport() {
        }


        public Airport(Long id, String name, String code, String city, String country, List<Flight> departingFlights, List<Flight> arrivingFlights) {
            this.id = id;
            this.name = name;
            this.code = code;
            this.city = city;
            this.country = country;
            this.departingFlights = departingFlights;
            this.arrivingFlights = arrivingFlights;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public List<Flight> getDepartingFlights() {
            return departingFlights;
        }

        public void setDepartingFlights(List<Flight> departingFlights) {
            this.departingFlights = departingFlights;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Airport airport = (Airport) o;
            return Objects.equals(id, airport.id) && Objects.equals(name, airport.name) && Objects.equals(code, airport.code) && Objects.equals(city, airport.city) && Objects.equals(country, airport.country) && Objects.equals(departingFlights, airport.departingFlights) && Objects.equals(arrivingFlights, airport.arrivingFlights);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, code, city, country, departingFlights, arrivingFlights);
        }

        @Override
        public String toString() {
            return "Airport{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    ", city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    ", departingFlights=" + departingFlights +
                    ", arrivingFlights=" + arrivingFlights +
                    '}';
        }
    }



