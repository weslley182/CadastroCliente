package br.com.wesley.cadastroclientes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import DAO.ClienteDAO;
import Modelo.Cliente;

public class ListaCadActivity extends AppCompatActivity {

    private ListView listaClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cad);

        listaClientes = (ListView) findViewById(R.id.lista_clientes);

        Button novoCli = (Button) findViewById(R.id.lista_cad_novo_cliente);
        novoCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaCadActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

    }

    private void carregarLista(){
        ClienteDAO dao = new ClienteDAO(this);
        List<Cliente> clientes = dao.buscarClientes();
        dao.close();

        ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, clientes);
        listaClientes = (ListView) findViewById(R.id.lista_clientes);

        listaClientes.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }
}
