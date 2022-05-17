package aluno.fabio.projetofresadora;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import aluno.fabio.projetofresadora.ListaDispositivos;

import static aluno.fabio.projetofresadora.ListaDispositivos.MAC_ADRESS;

public class MainActivity extends AppCompatActivity  {

    private BluetoothAdapter myBluetooth = null;
    private Set<BluetoothDevice> pairedDevices;
    public static String EXTRA_ADDRESS = null;
    private static final int REQUEST_CODE=1;
    Set<BluetoothDevice> paired_devices;
    String lists[];
    boolean conexao = false;
    private static final int REQUEST_CONEXAO = 2;

    BluetoothDevice myDevice = null;
    BluetoothSocket mySocket = null;
    Button btnPaired;

    ListView devicelist;

    ConnectedThread Conectarei;

    UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Movimentos = (Button) findViewById(R.id.movimentabotao);
        Button Sobre = (Button) findViewById(R.id.sobrebotao);
        Button Manual = (Button) findViewById(R.id.manualbotao);
        btnPaired = (Button) findViewById(R.id.conexao);
        devicelist = (ListView)findViewById(R.id.listView);

        myBluetooth = BluetoothAdapter.getDefaultAdapter();

        if(myBluetooth == null)
        {

            Toast.makeText(getApplicationContext(), "Bluetooth Não Disponínel", Toast.LENGTH_LONG).show();


            finish();
        }
        else if(!myBluetooth.isEnabled())
        {

            Intent turnBTon = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnBTon,1);
        }


        Movimentos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Movimentos.class);
                startActivity(it);
            }
        });
        Sobre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Sobre.class);
                startActivity(it);
            }
        });

        Manual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, manual.class);
                startActivity(it);
            }
        });
    btnPaired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(conexao){
                    //desconectar
                    try{
                        mySocket.close();
                        conexao = false;
                        Toast.makeText(getApplicationContext(), "Conexão finalizada", Toast.LENGTH_LONG).show();
                        btnPaired.setText("Conectar");

                    }catch(IOException erro){
                        Toast.makeText(getApplicationContext(), "Ocorreu um erro " + erro, Toast.LENGTH_LONG).show();

                    }
                }else{
                    //conectar
                    Intent abreLista = new Intent(MainActivity.this, ListaDispositivos.class);
                    startActivityForResult(abreLista, REQUEST_CONEXAO);
                }

            }
        });

    }
    public void onActivityResult(int requestcode, int resultcode, Intent data){
        switch (requestcode){
            case REQUEST_CODE:
                if (resultcode == Activity.RESULT_OK){
                    Toast.makeText(getApplicationContext(), "Bluetooth Ativado", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Bluetooth Não Ativado", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
            case REQUEST_CONEXAO:
                if(resultcode == Activity.RESULT_OK){
                    EXTRA_ADDRESS = data.getExtras().getString(ListaDispositivos.MAC_ADRESS);
                    myDevice = myBluetooth.getRemoteDevice(EXTRA_ADDRESS);

                    try{
                        mySocket = myDevice.createRfcommSocketToServiceRecord(MY_UUID);
                        mySocket.connect();
                        conexao = true;
                        Conectarei = new ConnectedThread(mySocket);
                        Conectarei.start();
                        btnPaired.setText("Desconectar");
                        Toast.makeText(getApplicationContext(), "Conectado no Dispositivo " + MAC_ADRESS, Toast.LENGTH_LONG).show();
                    }catch (IOException erro) {
                        Toast.makeText(getApplicationContext(),"Ocorreu um erro" + erro, Toast.LENGTH_LONG).show();
                        conexao = false;
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Falha ao obter MAC ADRESS", Toast.LENGTH_LONG).show();
                }

        }









    }
}

