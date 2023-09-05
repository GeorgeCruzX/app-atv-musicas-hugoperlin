package ifpr.pgua.eic.colecaomusicas.model.daos;

import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;

public interface Playlist {

    void setId(int int1);

    Musica[] getMusicas();

}
