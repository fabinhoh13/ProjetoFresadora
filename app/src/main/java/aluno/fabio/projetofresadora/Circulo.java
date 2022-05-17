package aluno.fabio.projetofresadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Circulo extends AppCompatActivity {
    EditText raio, posx, posy;
    String msgc;
    Button envia;

    ConnectedThread Conectando;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);
        raio = (EditText) findViewById(R.id.raiocirculo);
        posx = (EditText) findViewById(R.id.posxc);
        posy = (EditText) findViewById(R.id.posyc);
        envia = (Button) findViewById(R.id.enviaraio);


        envia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String raioo = raio.getText().toString();
                String emxc = posx.getText().toString();
                String emyc = posy.getText().toString();


                msgc = "C" + " " + raioo + " " + emxc + " " + emyc + " " + ";";

                Conectando.write(msgc);
            }


        });
    }
}
