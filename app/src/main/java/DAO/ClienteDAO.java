package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Modelo.Cliente;

/**
 * Created by Wesley on 23-Apr-16.
 */
public class ClienteDAO extends SQLiteOpenHelper{

    public ClienteDAO(Context context) {
        super(context, "CADASTRO_CLIENTE", null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sSql = "CREATE TABLE Clientes(id INTEGER PRIMARY KEY, "+
                "nome TEXT NOT NULL, telefone TEXT, cpf TEXT, DtNasc TEXT, genero TEXT);";
        db.execSQL(sSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sSql = "DROP TABLE IF EXISTS Clientes";
        db.execSQL(sSql);
        onCreate(db);
    }

    public List<Cliente> buscarClientes() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Clientes;", null);
        List<Cliente> clientes = new ArrayList<Cliente>();
        while (c.moveToNext()){
            Cliente cliente = new Cliente();
            cliente.setId(c.getLong(c.getColumnIndex("id")));
            cliente.setNome(c.getString(c.getColumnIndex("nome")));
            cliente.setTelefone(c.getString(c.getColumnIndex("telefone")));
            cliente.setCPF(c.getString(c.getColumnIndex("cpf")));

            Float teste = c.getFloat(c.getColumnIndex("DtNasc"));
            Double teste2 = c.getDouble(c.getColumnIndex("DtNasc"));
            Long teste3 = c.getLong(c.getColumnIndex("DtNasc"));

            String data = c.getString(c.getColumnIndex("DtNasc"));
            cliente.setDtNasc(retornarDataNasc(data));

            cliente.setGenero(c.getString(c.getColumnIndex("genero")));

            clientes.add(cliente);
        }
        c.close();
        return clientes;
    }

    public Date retornarDataNasc(String data){
        if(data == null){
            return null;
        }
        SimpleDateFormat formato =  new SimpleDateFormat("dd/MM/yyyy");
        Date dataObj = null;
        try {
            dataObj = (Date) formato.parse(data);
        } catch (ParseException e) {
            return null;
        }

        return dataObj;
    }

    public void inserir(Cliente cliente){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegarDadosDoCliente(cliente);
        db.insert("Clientes", null, dados);
    }

    public ContentValues pegarDadosDoCliente(Cliente cliente){
        ContentValues dados = new ContentValues();
        dados.put("nome", cliente.getNome());
        dados.put("telefone", cliente.getTelefone());
        dados.put("cpf", cliente.getCPF());
        dados.put("DtNasc", cliente.getDtNasc().toString());
        dados.put("genero", cliente.getGenero());
        return dados;
    }
}
