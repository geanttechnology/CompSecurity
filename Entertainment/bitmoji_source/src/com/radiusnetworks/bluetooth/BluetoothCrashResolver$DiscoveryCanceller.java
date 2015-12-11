// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.os.AsyncTask;
import android.util.Log;

// Referenced classes of package com.radiusnetworks.bluetooth:
//            BluetoothCrashResolver

private class <init> extends AsyncTask
{

    final BluetoothCrashResolver this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
label0:
        {
            Thread.sleep(5000L);
            if (!BluetoothCrashResolver.access$400(BluetoothCrashResolver.this))
            {
                Log.w("BluetoothCrashResolver", "BluetoothAdapter.ACTION_DISCOVERY_STARTED never received.  Recovery may fail.");
            }
            avoid = BluetoothAdapter.getDefaultAdapter();
            if (avoid.isDiscovering())
            {
                if (BluetoothCrashResolver.access$200(BluetoothCrashResolver.this))
                {
                    Log.d("BluetoothCrashResolver", "Cancelling discovery");
                }
                avoid.cancelDiscovery();
                break label0;
            }
            try
            {
                if (BluetoothCrashResolver.access$200(BluetoothCrashResolver.this))
                {
                    Log.d("BluetoothCrashResolver", "Discovery not running.  Won't cancel it");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                if (BluetoothCrashResolver.access$200(BluetoothCrashResolver.this))
                {
                    Log.d("BluetoothCrashResolver", "DiscoveryCanceller sleep interrupted.");
                }
            }
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
    }

    protected void onPreExecute()
    {
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Void[])aobj);
    }

    protected transient void onProgressUpdate(Void avoid[])
    {
    }

    private ()
    {
        this$0 = BluetoothCrashResolver.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
