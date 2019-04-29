package pt.ipg.myapplication.dominio.repositorio;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import pt.ipg.myapplication.dominio.entidade.Clientes;

public class cliente2 {

    private SQLiteDatabase conexao;

    public void inserir(Clientes cliente){

        ContentValues contentValues =new ContentValues();
        contentValues.put("NOME",cliente.nome);
        contentValues.put("E-MAIL",cliente.email);
        contentValues.put("JOGOS",cliente.jogos);


    }

    public void excluir(int codigo){

    }

    public void alterar(Clientes cliente){

    }

    public List<Clientes> procurar(){

        return null;

    }

    public Clientes procurarcliente(int codigo){
        return null;
    }
}
