package org.sebsy.grasps.daos;

import org.sebsy.grasps.beans.Reservation;

public interface IReservationDao {
    Reservation sauvegarderReservation(Reservation reservation);
}