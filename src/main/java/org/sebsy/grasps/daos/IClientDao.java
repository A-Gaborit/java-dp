package org.sebsy.grasps.daos;

import org.sebsy.grasps.beans.Client;

public interface IClientDao {
    /**
     * Extrait un client de la base de données par son identifiant
     *
     * @param id l'identifiant du client
     * @return le client trouvé, ou null s'il n'existe pas
     */
    Client extraireClient(String id);
}
