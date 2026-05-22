package org.sebsy.grasps.daos;

import org.sebsy.grasps.beans.Reservation;
import java.util.ArrayList;
import java.util.List;

public class ReservationDao implements IReservationDao {

    private static List<Reservation> reservations = new ArrayList<>();
    private static Long idCounter = 1L;

    @Override
    public Reservation sauvegarderReservation(Reservation reservation) {
        reservation.setId(idCounter++);
        reservations.add(reservation);
        return reservation;
    }
}   