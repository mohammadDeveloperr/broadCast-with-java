package com.example.broadcast1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
if(checkNetwork(context)){
    Toast.makeText(context,"شبکه متصل است",Toast.LENGTH_LONG).show();
}
else {
    Toast.makeText(context,"شبکه متصل نیست",Toast.LENGTH_LONG).show();

}

Toast.makeText(context,"پیامک دریافت شد",Toast.LENGTH_LONG).show();
    }

    private boolean checkNetwork(Context mContext){
        try{
            ConnectivityManager conManager=(ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo=conManager.getActiveNetworkInfo();
            return  (nInfo !=null && nInfo.isConnected());
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }

    }
}
