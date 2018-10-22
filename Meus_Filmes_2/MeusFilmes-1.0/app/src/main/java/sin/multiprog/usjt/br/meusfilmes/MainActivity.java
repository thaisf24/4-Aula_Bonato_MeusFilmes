package sin.multiprog.usjt.br.meusfilmes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
    private EditText editText;
    public static final String BUSCA = "sin.multiprog.usjt.br.meusfilmes.busca";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.txt_busca);
    }

    public void buscarFilmes(View view) {
        String texto = editText.getText().toString();
        Intent intent = new Intent(this, ListaFilmesActivity.class);
        intent.putExtra(BUSCA, texto);
        startActivity(intent);
    }
}









