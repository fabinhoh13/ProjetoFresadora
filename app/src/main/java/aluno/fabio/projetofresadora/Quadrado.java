package aluno.fabio.projetofresadora;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Quadrado extends AppCompatActivity {

    EditText ladoquad, posx, posy;
    String msg;
    Button envia;

    ConnectedThread Conectando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadrado);


        ladoquad = (EditText) findViewById(R.id.ladoquadrado);
        posx = (EditText) findViewById(R.id.posxq);
        posy = (EditText) findViewById(R.id.posyq);
        envia = (Button) findViewById(R.id.enviaquadrado);


        envia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String lado = ladoquad.getText().toString();
                String emxq = posx.getText().toString();
                String emyq = posy.getText().toString();



                msg = "Q" + " " + lado + " " + emxq + " " + emyq + " " + ";";

                Conectando.write(msg);

            }


        });
    }

}
