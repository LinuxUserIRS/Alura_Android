package br.com.alura.agenda_alura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.alura.agenda_alura.DAO.AlunoDAO;
import br.com.alura.agenda_alura.modelo.Aluno;

public class FormActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        helper = new FormularioHelper(this);
        Intent intentOrigem = getIntent();
        Aluno aluno = (Aluno) intentOrigem.getSerializableExtra("aluno");
        if(aluno != null){
            helper.preencheForm(aluno);
        }



        Spinner spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.arrayGenero, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenero.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_formulario_ok:
                Aluno newAluno = helper.getAluno();
                AlunoDAO DAO = new AlunoDAO(this);
                DAO.insert(newAluno);
                DAO.close();
                Toast.makeText(FormActivity.this, newAluno.getNome() + " salvo!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
