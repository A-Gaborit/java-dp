package org.sebsy.grasps.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    private Long id;

    private LocalDateTime date;

    private int nbPlaces;

    private double total;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    public Reservation() {

    }

    public Reservation(LocalDateTime date) {
        super();
        this.date = date;
    }

    /**
     *
     * @param date la date de la réservation
     * @param nbPlaces le nombre de places
     */
    public Reservation(LocalDateTime date, int nbPlaces) {
        super();
        this.date = date;
        this.nbPlaces = nbPlaces;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Setter
     *
     * @param date the date to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Getter
     *
     * @return the nbPlaces
     */
    public int getNbPlaces() {
        return nbPlaces;
    }

    /**
     * Setter
     *
     * @param nbPlaces the nbPlaces to set
     */
    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    /**
     * Getter
     *
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * Setter
     *
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Getter
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Setter
     *
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Calcule et applique le montant total de la réservation selon le type et le statut du client
     *
     * @param type le type de réservation contenant le montant et la réduction
     */
    public void calculerTotal(TypeReservation type) {
        double total = type.getMontant() * nbPlaces;
        if (client.isPremium()) {
            this.setTotal(total * (1 - type.getReductionPourcent() / 100.0));
        } else {
            this.setTotal(total);
        }
    }
}
