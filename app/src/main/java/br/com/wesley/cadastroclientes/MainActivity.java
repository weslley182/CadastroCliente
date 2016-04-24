package br.com.wesley.cadastroclientes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import DAO.ClienteDAO;
import Modelo.Cliente;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Button sair = (Button) findViewById(R.id.main_sair);
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button cadastro = (Button) findViewById(R.id.main_cadastrar);
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaCadActivity.class);
                startActivity(intent);
            }
        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.main_sair:
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_SHORT).show();
                finish();
                break;

            case R.id.main_cadastrar:
                Intent intent = new Intent(MainActivity.this, ListaCadActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
