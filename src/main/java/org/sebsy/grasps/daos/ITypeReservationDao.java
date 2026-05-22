package org.sebsy.grasps.daos;

import org.sebsy.grasps.beans.TypeReservation;

public interface ITypeReservationDao {

    /**
     * Extrait un type de réservation de la base de données par son type
     *
     * @param type le type de réservation à rechercher
     * @return le type de réservation trouvé, ou null s'il n'existe pas
     */
    TypeReservation extraireTypeReservation(String type);
}
