package org.sebsy.grasps.services;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.*;
import org.sebsy.grasps.Params;
import org.sebsy.grasps.utils.DateUtils;
import java.time.LocalDateTime;

/**
 * Service métier pour la gestion des réservations
 */
public class ReservationService implements IReservationService {

    /**
     * DAO permettant d'accéder à la table des clients
     */
    private IClientDao clientDao = new ClientDao();

    private ITypeReservationDao typeReservationDao = new TypeReservationDao();

    private IReservationDao reservationDao = new ReservationDao();

    /**
     * Crée une réservation en orchestrant les entités
     *
     * @param params contient toutes les infos permettant de créer une réservation
     * @return la réservation créée
     */
    @Override
    public Reservation creerReservation(Params params) {
        LocalDateTime dateReservation = DateUtils.toDate(params.getDateReservation());
        Client client = clientDao.extraireClient(params.getIdentifiantClient());
        TypeReservation type = typeReservationDao.extraireTypeReservation(params.getTypeReservation());
        Reservation reservation = new Reservation(dateReservation, params.getNbPlaces());   
        
        reservation.setClient(client);
        calculerTotal(type, client, reservation);

        return reservationDao.sauvegarderReservation(reservation);
    }

    @Override
    public void calculerTotal(TypeReservation typeReservation, Client client, Reservation reservation) {
        double totalBase = typeReservation.getMontant() * reservation.getNbPlaces();
        if (client.isPremium()) {
            reservation.setTotal(totalBase * (1 - typeReservation.getReductionPourcent() / 100.0));
        } else {
            reservation.setTotal(totalBase);
        }
    }
}
