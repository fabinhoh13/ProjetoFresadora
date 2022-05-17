package aluno.fabio.projetofresadora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Movimentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimentos);
        Button Circulo = (Button) findViewById(R.id.circulo);
        Button Quadrado = (Button) findViewById(R.id.quadrado);
        Button Reta = (Button) findViewById(R.id.reta);
        Button Retangulo = (Button) findViewById(R.id.retangulo);


        Circulo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Movimentos.this, Circulo.class);
                startActivity(it);
            }
        });

        Quadrado.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Movimentos.this, Quadrado.class);
                startActivity(it);
            }
        });

        Reta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Movimentos.this, Reta.class);
                startActivity(it);
            }
        });

        Retangulo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent it = new Intent(Movimentos.this, Retangulo.class);
                startActivity(it);

            }

        });
    }
}
