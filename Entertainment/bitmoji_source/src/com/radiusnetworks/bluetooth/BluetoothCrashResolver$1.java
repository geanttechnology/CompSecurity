// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.Date;

// Referenced classes of package com.radiusnetworks.bluetooth:
//            BluetoothCrashResolver

class this._cls0 extends BroadcastReceiver
{

    final BluetoothCrashResolver this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        if (!context.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) goto _L2; else goto _L1
_L1:
        if (!BluetoothCrashResolver.access$100(BluetoothCrashResolver.this)) goto _L4; else goto _L3
_L3:
        if (BluetoothCrashResolver.access$200(BluetoothCrashResolver.this))
        {
            Log.d("BluetoothCrashResolver", "Bluetooth discovery finished");
        }
        BluetoothCrashResolver.access$300(BluetoothCrashResolver.this);
_L2:
        if (context.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED"))
        {
            if (BluetoothCrashResolver.access$100(BluetoothCrashResolver.this))
            {
                BluetoothCrashResolver.access$402(BluetoothCrashResolver.this, true);
                if (BluetoothCrashResolver.access$200(BluetoothCrashResolver.this))
                {
                    Log.d("BluetoothCrashResolver", "Bluetooth discovery started");
                }
            } else
            if (BluetoothCrashResolver.access$200(BluetoothCrashResolver.this))
            {
                Log.d("BluetoothCrashResolver", "Bluetooth discovery started (external)");
            }
        }
        if (!context.equals("android.bluetooth.adapter.action.STATE_CHANGED")) goto _L6; else goto _L5
_L5:
        intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0x80000000);
        JVM INSTR lookupswitch 5: default 164
    //                   -2147483648: 207
    //                   10: 226
    //                   11: 365
    //                   12: 263
    //                   13: 164;
           goto _L6 _L7 _L8 _L9 _L10 _L6
_L6:
        return;
_L4:
        if (BluetoothCrashResolver.access$200(BluetoothCrashResolver.this))
        {
            Log.d("BluetoothCrashResolver", "Bluetooth discovery finished (external)");
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (BluetoothCrashResolver.access$200(BluetoothCrashResolver.this))
        {
            Log.d("BluetoothCrashResolver", "Bluetooth state is ERROR");
            return;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L8:
        if (BluetoothCrashResolver.access$200(BluetoothCrashResolver.this))
        {
            Log.d("BluetoothCrashResolver", "Bluetooth state is OFF");
        }
        BluetoothCrashResolver.access$502(BluetoothCrashResolver.this, (new Date()).getTime());
        return;
_L10:
        if (BluetoothCrashResolver.access$200(BluetoothCrashResolver.this))
        {
            Log.d("BluetoothCrashResolver", "Bluetooth state is ON");
        }
        if (BluetoothCrashResolver.access$200(BluetoothCrashResolver.this))
        {
            Log.d("BluetoothCrashResolver", (new StringBuilder()).append("Bluetooth was turned off for ").append(BluetoothCrashResolver.access$600(BluetoothCrashResolver.this) - BluetoothCrashResolver.access$500(BluetoothCrashResolver.this)).append(" milliseconds").toString());
        }
        if (BluetoothCrashResolver.access$600(BluetoothCrashResolver.this) - BluetoothCrashResolver.access$500(BluetoothCrashResolver.this) < 600L)
        {
            crashDetected();
            return;
        }
        if (true) goto _L6; else goto _L9
_L9:
        BluetoothCrashResolver.access$602(BluetoothCrashResolver.this, (new Date()).getTime());
        if (!BluetoothCrashResolver.access$200(BluetoothCrashResolver.this)) goto _L6; else goto _L11
_L11:
        Log.d("BluetoothCrashResolver", "Bluetooth state is TURNING_ON");
        return;
        if (true) goto _L2; else goto _L12
_L12:
    }

    ()
    {
        this$0 = BluetoothCrashResolver.this;
        super();
    }
}
