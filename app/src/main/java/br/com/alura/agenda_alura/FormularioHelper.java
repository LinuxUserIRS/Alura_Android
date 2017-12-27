package br.com.alura.agenda_alura;

import android.media.Rating;
import android.util.Log;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.alura.agenda_alura.modelo.Aluno;

/**
 * Created by italo on 20/12/17.
 */

public class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefone;
    private final EditText campoEmail;
    private final EditText campoLoginGithub;
    private final Spinner genero;
    private final RatingBar rating;

    private Aluno aluno;

    public FormularioHelper(FormActivity atividadeFormulario){
        campoNome = (EditText) atividadeFormulario.findViewById(R.id.campoNome);
        campoEndereco = (EditText) atividadeFormulario.findViewById(R.id.campoEndereco);
        campoTelefone = (EditText) atividadeFormulario.findViewById(R.id.campoTelefone);
        campoEmail = (EditText) atividadeFormulario.findViewById(R.id.campoEmail);
        campoLoginGithub = (EditText) atividadeFormulario.findViewById(R.id.campoLoginGithub);
        genero = (Spinner) atividadeFormulario.findViewById(R.id.spinnerGenero);
        rating = (RatingBar) atividadeFormulario.findViewById(R.id.ratingBar);

        aluno = new Aluno();
    }

    public Aluno getAluno() {
        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setEmail(campoEmail.getText().toString());
        aluno.setLoginGithub(campoLoginGithub.getText().toString());
        aluno.setGenero(genero.getSelectedItem().toString());
        aluno.setNota(Double.valueOf(rating.getProgress()));

        return aluno;
    }

    public void preencheForm(Aluno aluno) {
        campoNome.setText(aluno.getNome());
        campoEndereco.setText(aluno.getEndereco());
        campoTelefone.setText(aluno.getTelefone());
        campoEmail.setText(aluno.getEmail());
        campoLoginGithub.setText(aluno.getLoginGithub());

        if(aluno.getGenero().equals("Masculino")){
            //Em tese, a linha abaixo deveria funcionar
            //genero.setSelection(0);
            //Mas só consegui o efeito desejado, de setar o spinner com essa função abaixo
            genero.post(new Runnable() {
                public void run() {
                    genero.setSelection(0);
                }
            });

        }else if(aluno.getGenero().equals("Feminino")){
            genero.post(new Runnable() {
                public void run() {
                    genero.setSelection(1);
                }
            });

        }else{
            genero.post(new Runnable() {
                public void run() {
                    genero.setSelection(2);
                }
            });


        }

        rating.setProgress(aluno.getNota().intValue());
        this.aluno = aluno;
    }
}
