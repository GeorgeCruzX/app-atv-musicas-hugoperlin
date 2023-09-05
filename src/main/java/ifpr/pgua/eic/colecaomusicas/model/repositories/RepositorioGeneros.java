package ifpr.pgua.eic.colecaomusicas.model.repositories;

import java.util.ArrayList;
import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.daos.GeneroDAO;
import ifpr.pgua.eic.colecaomusicas.model.entities.Genero;

public class RepositorioGeneros {
    
    private GeneroDAO dao;

    public RepositorioGeneros(GeneroDAO dao){
        new ArrayList<>();
        this.dao = dao;
    }

    public String cadastrarGenero(String nome){
        Genero genero = new Genero(nome);
        Resultado resultado = dao.criar(genero);
        return resultado.getMsg();
    }

    public Resultado listarGeneros(){
        return dao.listar();
    }


}
