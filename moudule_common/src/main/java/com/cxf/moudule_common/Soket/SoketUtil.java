package com.cxf.moudule_common.Soket;


import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SoketUtil {
    Socket socket;
    OutputStream outputStream;
    OutputStreamWriter outputStreamWriter;
    InputStream inputStream;
    InputStreamReader inputStreamReader;


    public SoketUtil(String ip,int port) {
        try {
            this.socket = new Socket();
            SocketAddress address = new InetSocketAddress(InetAddress.getByName(ip), port);
            socket.connect(address,60000);
            if(socket.isConnected()){
                Log.w("TAG","------------socket connected-----------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }





}
