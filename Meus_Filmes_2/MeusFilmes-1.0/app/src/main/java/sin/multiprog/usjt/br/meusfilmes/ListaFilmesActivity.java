package sin.multiprog.usjt.br.meusfilmes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;


public class ListaFilmesActivity extends Activity {
    Activity activity;
    Filme[] filmes;
    public static final String FILME = "br.usjt.sin.progmulti.meusfilmes.filme";


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);
        activity = this;
        final Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.BUSCA);
        ListView listView = findViewById(R.id.lista_filmes);
        filmes = this.busca(chave);
        FilmeAdapter adapter = new FilmeAdapter(filmes, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(activity, DetalheFilmeActivity.class);
                intent1.putExtra(FILME, filmes[i]);
                startActivity(intent1);
            }
        });

    }
    private Filme[] busca(String chave){
        Filme[] filmes = FilmeDAO.getFilmes();

        if(chave == null || chave.length()==0){
            return filmes;
        } else {
            ArrayList<Filme> lista = new ArrayList<>();
            for(Filme filme : filmes){
                if(filme.getNome().toUpperCase().contains(chave.toUpperCase())){
                    lista.add(filme);
                }
            }
            return lista.toArray(new Filme[0]);
        }
    }


}












