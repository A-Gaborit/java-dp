package org.sebsy.grasps.services;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.Params;
import org.sebsy.grasps.beans.TypeReservation;

public interface IReservationService {

    /**
     * Crée une réservation pour un client
     *
     * @param params les paramètres contenant les infos de la réservation
     * @return la réservation créée
     */
    Reservation creerReservation(Params params);

    /**
     * Calcule le total d'une réservation en fonction du type de réservation et du statut du client
      *
      * @param typeReservation le type de réservation choisi
      * @param client le client qui fait la réservation
      * @param reservation la réservation pour laquelle calculer le total
     */
    void calculerTotal(TypeReservation typeReservation, Client client, Reservation reservation);
}
