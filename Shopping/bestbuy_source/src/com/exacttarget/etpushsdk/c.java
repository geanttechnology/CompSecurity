// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.exacttarget.etpushsdk.util.m;
import com.radiusnetworks.ibeacon.IBeaconManager;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETLocationManager

class c extends BroadcastReceiver
{

    final ETLocationManager a;

    c(ETLocationManager etlocationmanager)
    {
        a = etlocationmanager;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction()))
        {
            if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1) == 10)
            {
                m.a("~!ETLocationManager", "Bluetooth OFF");
                if (a.e())
                {
                    a.d(false);
                }
            } else
            if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1) == 12)
            {
                m.a("~!ETLocationManager", "Bluetooth ON");
                if (a.e())
                {
                    if (!ETLocationManager.b(a).isBound(ETLocationManager.a(a)))
                    {
                        a.h(true);
                        ETLocationManager.b(a).bind(ETLocationManager.a(a));
                        return;
                    } else
                    {
                        a.b(false);
                        return;
                    }
                }
            }
        }
    }
}
