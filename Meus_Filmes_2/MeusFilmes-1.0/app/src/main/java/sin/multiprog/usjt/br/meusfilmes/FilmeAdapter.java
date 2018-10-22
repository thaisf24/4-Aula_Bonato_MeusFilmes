package sin.multiprog.usjt.br.meusfilmes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class FilmeAdapter extends BaseAdapter {
    private Filme[] filmes;
    private Context context;

       public FilmeAdapter(Filme[] filmes, Context context) {
        this.filmes = filmes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return filmes.length;
    }

    @Override
    public Object getItem(int i) {
        return filmes[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View linha = view;
        if(linha == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            linha = inflater.inflate(R.layout.linha_filme, viewGroup, false);
            ImageView foto = linha.findViewById(R.id.foto_filme);
            TextView linha_nome = linha.findViewById(R.id.linha_nome);
            TextView linha_detalhe = linha.findViewById(R.id.linha_detalhe);
            ViewHolder holder = new ViewHolder(foto, linha_nome, linha_detalhe,linha_detalhe,linha_detalhe);
            linha.setTag(holder);
        }
        Filme filme = filmes[i];
        ViewHolder holder = (ViewHolder)linha.getTag();

        holder.getLinha1().setText(filme.getNome());
        holder.getLinha2().setText(filme.getDirecao());
         holder.getLinha3().setText(filme.getLancamento()+ " - " + filme.getDescricao());
         holder.getLinha4().setText(filme.getPopularidade());

         Log.i("poster", filme.getPoster());
        Drawable figura = Util.getImagem(context, filme.getPoster().replaceAll(".jpg", ""));

        holder.getImagem().setImageDrawable(figura);

        return linha;
    }
}
