package sin.multiprog.usjt.br.meusfilmes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;





public class DetalheFilmeActivity extends Activity {
    private TextView  nome,direcao,descricao, popularidade, lancamento;
    private ImageView foto;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);
        nome = findViewById(R.id.detalhe_txt_nome);
        direcao = findViewById(R.id.detalhe_txt_direcao);
       descricao= findViewById(R.id.detalhe_txt_descricao);
        popularidade = findViewById(R.id.detalhe_txt_popularidade);
        lancamento = findViewById(R.id.detalhe_txt_lancamento);
        foto = findViewById(R.id.detalhe_foto_filme);

        Intent intent = getIntent();
        Filme filme = (Filme)intent.getSerializableExtra(ListaFilmesActivity.FILME);
        nome.setText(filme.getNome().toString());
        direcao.setText(filme.getDirecao().toString());
        descricao.setText(filme.getDescricao().toString());
        popularidade.setText(filme.getPopularidade().toString());
        lancamento.setText(filme.getLancamento().toString());
        foto.setImageDrawable(Util.getImagem(this, filme.getPoster().replaceAll(".jpg", "")));
    }
}