package aluno.fabio.projetofresadora;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Retangulo extends AppCompatActivity {

    EditText paraox, paraoy, posicemx, posicemy;
    Button enviaroretan;
    String msgretan;
    ConnectedThread Conectando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_retangulo);

        paraox = (EditText) findViewById(R.id.ladox);
        paraoy = (EditText) findViewById(R.id.ladoy);
        posicemx = (EditText) findViewById(R.id.parax);
        posicemy = (EditText) findViewById(R.id.paray);
        enviaroretan = (Button) findViewById(R.id.enviaretangulo);



        enviaroretan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String ab = paraox.getText().toString();
                String bc = paraoy.getText().toString();
                String cd = posicemx.getText().toString();
                String de = posicemy.getText().toString();

                msgretan = "E" + " " + ab + " " + bc + " " + cd + " " + de + " " + ";";

                Conectando.write(msgretan);


            }
        });
    }


}
