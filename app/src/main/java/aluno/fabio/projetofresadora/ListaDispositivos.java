package aluno.fabio.projetofresadora;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;


public class ListaDispositivos extends ListActivity {

    private BluetoothAdapter myBluetoothAdapter = null;

    static String MAC_ADRESS = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> ArrayBluetooth = new ArrayAdapter <String> (this,android.R.layout.simple_list_item_1);
        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = myBluetoothAdapter.getBondedDevices();
        if (pairedDevices.size()>0)
        {
            for(BluetoothDevice bt : pairedDevices)
            {
                String nomebt = bt.getName();
                String macadressdev = bt.getAddress();
                ArrayBluetooth.add(nomebt + "\n" + macadressdev);
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Sem Dispositivos Pareados", Toast.LENGTH_LONG).show();
        }
        setListAdapter(ArrayBluetooth);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String infoall = ((TextView) v).getText().toString();
        String onlymac = infoall.substring(infoall.length() - 17);
        Intent rt = new Intent();
        rt.putExtra(MAC_ADRESS, onlymac);
        setResult(RESULT_OK, rt);
        finish();
    }
}
