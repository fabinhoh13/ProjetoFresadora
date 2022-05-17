package aluno.fabio.projetofresadora;


import android.bluetooth.BluetoothSocket;


import java.io.IOException;
import java.io.OutputStream;

class ConnectedThread extends Thread {
    private final BluetoothSocket mmSocket;
    private final OutputStream mmOutStream;

    public ConnectedThread(BluetoothSocket socket) {
        mmSocket = socket;
        OutputStream tmpOut = null;


        try {
            tmpOut = socket.getOutputStream();
        } catch (IOException e) { }

        mmOutStream = tmpOut;
    }




    public void write(String enviadados) {
        byte[] msgbuffer = enviadados.getBytes();
        try {
            mmOutStream.write(msgbuffer);
        } catch (IOException e) { }
    }

}