package br.com.wesley.cadastroclientes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import DAO.ClienteDAO;
import Helper.CadClienteHelper;
import Modelo.Cliente;

public class CadastroActivity extends AppCompatActivity {
    private CadClienteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.helper = new CadClienteHelper(this);
        Spinner generos = (Spinner) findViewById(R.id.cadastro_genero);
        List<String> list = new ArrayList<String>();
        list.add("MASCULINO");
        list.add("FEMININO");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        generos.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.cadastro_ok:
                Cliente cliente = helper.pegarCliente();
                ClienteDAO dao = new ClienteDAO(this);

                dao.inserir(cliente);
                dao.close();
                Toast.makeText(CadastroActivity.this, "Cliente "+ cliente.getNome() + " Salvo!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadastro, menu);
        return true;
    }
}
