package aluno.fabio.projetofresadora;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Reta extends AppCompatActivity {
    EditText iniposx, iniposy, fimposx, fimposy;
    Button Enviarreta;
    String msgrt;

    ConnectedThread Conectando;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_reta);

        iniposx = (EditText) findViewById(R.id.posxrin);
        iniposy = (EditText) findViewById(R.id.posyrin);
        fimposx = (EditText) findViewById(R.id.posxrfim);
        fimposy = (EditText) findViewById(R.id.posyrfim);
        Enviarreta = (Button) findViewById(R.id.enviareta);



        Enviarreta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String a = iniposx.getText().toString();
                String b = iniposy.getText().toString();
                String c = fimposx.getText().toString();
                String d = fimposy.getText().toString();

                msgrt = "R" + " " + a + " " + b + " " + c + " " + d + " " + ";";

                Conectando.write(msgrt);

            }
        });
    }
}
