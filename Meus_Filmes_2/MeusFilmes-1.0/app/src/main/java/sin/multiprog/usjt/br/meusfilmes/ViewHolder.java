package sin.multiprog.usjt.br.meusfilmes;

import android.widget.ImageView;
import android.widget.TextView;


public class ViewHolder {
    private ImageView imagem;
    private TextView linha1, linha2,linha3,linha4;
        public ViewHolder(ImageView imagem, TextView linha1, TextView linha2, TextView linha3, TextView linha4) {
        this.imagem = imagem;
        this.linha1 = linha1;
        this.linha2 = linha2;
        this.linha3 = linha3;
        this.linha4 = linha4;
    }

    public ImageView getImagem() {
        return imagem;
    }

    public void setImagem(ImageView imagem) {
        this.imagem = imagem;
    }

    public TextView getLinha1() {
        return linha1;
    }

    public void setLinha1(TextView linha1) {
        this.linha1 = linha1;
    }

    public TextView getLinha2() {
        return linha2;
    }

    public void setLinha2(TextView linha2) {
        this.linha2 = linha2;
    }

    public TextView getLinha3() {
        return linha3;
    }

    public void setLinha3(TextView linha3) {
        this.linha3 = linha3;
    }

    public TextView getLinha4() {
        return linha4;
    }

    public void setLinha4(TextView linha4) {
        this.linha4 = linha4;
    }
}
