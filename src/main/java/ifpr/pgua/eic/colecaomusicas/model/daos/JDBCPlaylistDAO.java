package ifpr.pgua.eic.colecaomusicas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;

public class JDBCPlaylistDAO implements PlaylistDAO {
    private Connection conexao;

    // Construtor que recebe a conexão com o banco

    @Override
    public void criar(Playlist playlist) {
        try {
            // 1. Faça o insert da playlist na tabela de playlists
            String sqlPlaylist = "INSERT INTO Playlist (nome) VALUES (?)";
            PreparedStatement stmtPlaylist = conexao.prepareStatement(sqlPlaylist, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtPlaylist.setString(1, playlist.getNome());
            stmtPlaylist.executeUpdate();

            // 2. Pegue a chave da playlist que acabou de ser criada
            ResultSet generatedKeys = stmtPlaylist.getGeneratedKeys();
            if (generatedKeys.next()) {
                playlist.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Falha ao criar a playlist, não foi possível obter o ID gerado.");
            }

            // 3. Para cada música na lista de músicas da playlist, insira na tabela playlistsmusicas
            String sqlPlaylistMusica = "INSERT INTO PlaylistMusica (playlist_id, musica_id) VALUES (?, ?)";
            PreparedStatement stmtPlaylistMusica = conexao.prepareStatement(sqlPlaylistMusica);
            for (Musica musica : playlist.getMusicas()) {
                stmtPlaylistMusica.setInt(1, playlist.getId());
                stmtPlaylistMusica.setInt(2, musica.getId());
                stmtPlaylistMusica.executeUpdate();
            }
        } catch (SQLException e) {
            // Trate exceções aqui
        }
    }

    @Override
    public List<Playlist> listar() {
        List<Playlist> playlists = new ArrayList<>();
        try {
            // Implemente a busca das playlists no banco de dados
        } catch (SQLException e) {
            // Trate exceções aqui
        }
        return playlists;
    }
}
