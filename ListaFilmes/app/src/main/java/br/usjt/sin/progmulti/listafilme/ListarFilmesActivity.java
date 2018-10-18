package br.usjt.sin.progmulti.listafilme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
/*
 *  Thais Fernandes   RA: 201310430 */

public class ListarFilmesActivity extends Activity {

    public static final String DESCRICAO = "br.usjt.sin.progmulti.listafilme.descricao";
    ArrayList<String> lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_filmes);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = buscaChamados(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                                                        // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheFilmeActivity.class);
                intent.putExtra(DESCRICAO, lista.get(position));
                startActivity(intent);
                }
        });
    }
    public ArrayList<String> buscaChamados(String chave){
        ArrayList<String> lista = geraListaFilmes();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> subLista = new ArrayList<>();
            for(String nome:lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }
    public ArrayList<String> geraListaFilmes(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Harry Potter e a PedraFilosofal - Ano de lançamento: 2001");
        lista.add("Harry Potter e a Câmara Secreta - Ano de lançamento: 2002");
        lista.add("Harry Potter e o Prisioneiro de Azkaban - Ano de lançamento: 2004");
        lista.add("Harry Potter e o Cálice de Fogo - Ano de lançamento: 2005");
        lista.add("Harry Potter e a Ordem da Fênix - Ano de lançamento: 2007");
        lista.add("Harry Potter e o Enigma do Príncipe - Ano de lançamento: 2009");
        lista.add("Harry Potter e as Relíquias da Morte: Parte 1 - Ano de lançamento: 2010");
        lista.add("Harry Potter e as Relíquias da Morte: Parte 2 - Ano de lançamento: 2011");
        lista.add("Animais Fantásticos e Onde Habitam - Ano de lançamento: 2016");
        lista.add("Animais Fantásticos: Os crimes de grindelwald - Ano de lançamento: 2018");
        return lista;
    }
}
