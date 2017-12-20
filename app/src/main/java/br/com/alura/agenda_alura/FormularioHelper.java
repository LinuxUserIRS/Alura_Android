package br.com.alura.agenda_alura;

import android.media.Rating;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

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

    public FormularioHelper(FormActivity atividadeFormulario){
        campoNome = (EditText) atividadeFormulario.findViewById(R.id.campoNome);
        campoEndereco = (EditText) atividadeFormulario.findViewById(R.id.campoEndereco);
        campoTelefone = (EditText) atividadeFormulario.findViewById(R.id.campoTelefone);
        campoEmail = (EditText) atividadeFormulario.findViewById(R.id.campoEmail);
        campoLoginGithub = (EditText) atividadeFormulario.findViewById(R.id.campoLoginGithub);
        genero = (Spinner) atividadeFormulario.findViewById(R.id.spinnerGenero);
        rating = (RatingBar) atividadeFormulario.findViewById(R.id.ratingBar);
    }

    public Aluno getAluno() {
        Aluno alunoRetornado = new Aluno();
        alunoRetornado.setNome(campoNome.getText().toString());
        alunoRetornado.setEndereco(campoEndereco.getText().toString());
        alunoRetornado.setTelefone(campoTelefone.getText().toString());
        alunoRetornado.setEmail(campoEmail.getText().toString());
        alunoRetornado.setLoginGithub(campoLoginGithub.getText().toString());
        alunoRetornado.setGenero(genero.getSelectedItem().toString());
        alunoRetornado.setNota(Double.valueOf(rating.getProgress()));

        return alunoRetornado;
    }
}
