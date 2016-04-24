package Helper;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import Modelo.Cliente;
import br.com.wesley.cadastroclientes.CadastroActivity;
import br.com.wesley.cadastroclientes.R;

/**
 * Created by Wesley on 23-Apr-16.
 */
public class CadClienteHelper {
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoCpf;
    private DatePicker campoDtNasc;
    private Spinner campoGenero;
    private Cliente cliente;

    public CadClienteHelper(CadastroActivity activity) {
        this.cliente = new Cliente();
        this.campoNome = (EditText) activity.findViewById(R.id.cadastro_nome);
        this.campoTelefone = (EditText) activity.findViewById(R.id.cadastro_telefone);
        this.campoCpf = (EditText) activity.findViewById(R.id.cadastro_cpf);
        this.campoDtNasc = (DatePicker) activity.findViewById(R.id.cadastro_DtNasc);
        this.campoGenero = (Spinner) activity.findViewById(R.id.cadastro_genero);
    }

    public Cliente pegarCliente() {
        cliente.setNome(campoNome.getText().toString());
        cliente.setTelefone(campoTelefone.getText().toString());
        cliente.setCPF(campoCpf.getText().toString());

        cliente.setDtNasc(retornarData());
        cliente.setGenero(campoGenero.getSelectedItem().toString());
        return cliente;
    }

    private Date retornarData() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        int dia = campoDtNasc.getDayOfMonth();
        int ano = campoDtNasc.getYear();
        int mes = campoDtNasc.getMonth() + 1;

        Calendar calendar = Calendar.getInstance();

        TimeZone teste = calendar.getTimeZone();

        calendar.set(ano, mes, dia);

        return calendar.getTime();
    }
}
