package br.com.alura.agenda_alura.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda_alura.modelo.Aluno;

/**
 * Created by italo on 26/12/17.
 */

public class AlunoDAO extends SQLiteOpenHelper {
    private Aluno alunos;

    public AlunoDAO(Context context) {
        super(context, "Agenda DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = "CREATE TABLE alunos_tb(id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT NOT NULL, telefone TEXT NOT NULL, email TEXT NOT NULL, loginGitHub TEXT NOT NULL, genero TEXT NOT NULL, nota REAL);";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL = "DROP TABLE IF EXISTS alunos_tb;";
        db.execSQL(SQL);
        onCreate(db);
    }

    public void insert(Aluno newAluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("nome", newAluno.getNome());
        data.put("endereco", newAluno.getEndereco());
        data.put("telefone", newAluno.getTelefone());
        data.put("email", newAluno.getEmail());
        data.put("loginGitHub", newAluno.getLoginGithub());
        data.put("genero", newAluno.getGenero().toString());
        data.put("nota", newAluno.getNota());
        db.insert("alunos_tb", null, data);
    }

    public List<Aluno> getAlunos() {
        String SQL = "SELECT * FROM alunos_tb;";
        SQLiteDatabase db = getReadableDatabase();
        //db.execSQL não dá retorno. Por isso usamos o db.rawQuery
        //rawQuery retorna um cursor para uma linha em branco acima da primeira linha da tabela resultado
        Cursor c = db.rawQuery(SQL, null);
        List<Aluno> alunos = new ArrayList<Aluno>();
        while(c.moveToNext()){
            Aluno aluno = new Aluno();
            aluno.setId(c.getLong(c.getColumnIndex("id")));
            aluno.setNome(c.getString(c.getColumnIndex("nome")));
            aluno.setEndereco(c.getString(c.getColumnIndex("endereco")));
            aluno.setTelefone(c.getString(c.getColumnIndex("telefone")));
            aluno.setEmail(c.getString(c.getColumnIndex("email")));
            aluno.setLoginGithub(c.getString(c.getColumnIndex("loginGitHub")));
            aluno.setGenero(c.getString(c.getColumnIndex("genero")));
            aluno.setNota(c.getDouble(c.getColumnIndex("nota")));

            alunos.add(aluno);
        }
        c.close();
        return alunos;
    }

    public void delete(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        String[] parameters = {String.valueOf(aluno.getId())};
        db.delete("alunos_tb", "id = ?", parameters);
    }
}
