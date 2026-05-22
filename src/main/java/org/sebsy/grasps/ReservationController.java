package org.sebsy.grasps;

import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.services.IReservationService;
import org.sebsy.grasps.services.ReservationService;

/**
 * Controlleur qui prend en charge la gestion des réservations client
 */
public class ReservationController {
    private IReservationService reservationService = new ReservationService();

    /**
     * Méthode qui créée une réservation pour un client à partir des informations transmises
     *
     * @param params contient toutes les infos permettant de créer une réservation
     * @return Reservation
     */
    public Reservation creerReservation(Params params) {
        return reservationService.creerReservation(params);
    }
}
