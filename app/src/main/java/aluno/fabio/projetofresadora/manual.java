package aluno.fabio.projetofresadora;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;




public class manual extends AppCompatActivity {


   ConnectedThread conectar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);


        Button xmais =(Button) findViewById(R.id.maisx);
        Button xmenos =(Button) findViewById(R.id.menosx);
        Button ymais =(Button) findViewById(R.id.maisy);
        Button ymenos =(Button) findViewById(R.id.menosy);
        Button zmais =(Button) findViewById(R.id.maisz);
        Button zmenos =(Button) findViewById(R.id.menosz);
        Button pausar = (Button) findViewById(R.id.pause);
        Button voltar = (Button) findViewById(R.id.retorno);
        Button zeramento = (Button) findViewById(R.id.zero);
        Button origemm = (Button) findViewById(R.id.origem);




        xmais.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            String andaxmais = "M" + " " + "X" + " " + "U" + " " + ";";

               conectar.write(andaxmais);

            }
    });
        xmenos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String andaxmenos = "M" + " " + "X" + " " + "D" + " " + ";";
                conectar.write(andaxmenos);

            }



        });
        ymais.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String andaymais = "M" + " " + "Y" + " " + "U" + " " + ";";
                conectar.write(andaymais);

            }



        });
        ymenos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String andaymenos = "M" + " " + "Y" + " " + "D" + " " + ";";
                conectar.write(andaymenos);

            }



        });
        zmais.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String andazmais = "M" + " " + "Z" + " " + "U" + " " + ";";
                conectar.write(andazmais);

            }



        });
        zmenos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String andazmenos = "M" + " " + "Z" + " " + "D" + " " + ";";
                conectar.write(andazmenos);

            }



        });
        pausar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String paus = "p" + " " + ";";
                conectar.write(paus);

            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String volt = "c" + " " + ";";
                conectar.write(volt);

            }
        });
        origemm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String ori = "O" + " " + ";";
                conectar.write(ori);

            }
        });
        zeramento.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String zer = "Z" + " " + ";";
                conectar.write(zer);


            }
        });
    }
}
