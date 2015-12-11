// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.kahuna.sdk.m;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            ahh, ahg

class a
    implements android.bluetooth.othAdapter.LeScanCallback
{

    final ahh a;

    public void onLeScan(BluetoothDevice bluetoothdevice, int i, byte abyte0[])
    {
        abyte0 = ahh.a(a, abyte0);
        if (abyte0 == null)
        {
            return;
        }
        abyte0.b(bluetoothdevice.getName());
        abyte0.c(bluetoothdevice.getAddress());
        abyte0.c(i);
        abyte0.b((int)ahh.a(a, abyte0.e(), i));
        if (m.s())
        {
            Log.d("Kahuna", (new StringBuilder()).append("Beacon scanned ").append(bluetoothdevice.getName()).append(" ").append(abyte0.b()).append(" ").append(bluetoothdevice.getAddress()).toString());
        }
        synchronized (ahh.c(ahh.f()))
        {
            if (ahh.a(ahh.e(ahh.f()), abyte0) && !ahh.a(ahh.d(a), abyte0))
            {
                if (m.s())
                {
                    Log.d("Kahuna", (new StringBuilder()).append("Tracking iBeacon enter for UUID: ").append(abyte0.b()).toString());
                }
                ahh.f(ahh.f()).a(abyte0, "enter");
            }
        }
        ahh.a(a).add(abyte0);
        return;
        abyte0;
        bluetoothdevice;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    thDevice(ahh ahh1)
    {
        a = ahh1;
        super();
    }
}
