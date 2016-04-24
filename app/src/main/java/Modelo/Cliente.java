package Modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Wesley on 23-Apr-16.
 */
public class Cliente implements Serializable {
    private Long id;
    private String nome;
    private String Telefone;
    private String CPF;
    private Date DtNasc;
    private String Genero;

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDtNasc() {
        return DtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        DtNasc = dtNasc;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        GregorianCalendar hj = new GregorianCalendar();

        int anoHj = hj.get(Calendar.YEAR);
        int anoNascimento = getDtNasc().getYear();
        int idade = new Integer(anoHj - anoNascimento);
        return String.valueOf(idade);
    }

    @Override
    public String toString() {
        return getNome();
        //return getNome()+" - Idade: "+ getIdade();
    }
}
