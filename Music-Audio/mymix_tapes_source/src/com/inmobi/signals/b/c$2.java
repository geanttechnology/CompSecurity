// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

// Referenced classes of package com.inmobi.signals.b:
//            c, b

static final class ger extends BroadcastReceiver
{

    public void onReceive(Context context, Intent intent)
    {
        context = c.b();
        intent = (WifiManager)c.d().getSystemService("wifi");
        c.c();
        if (context != null)
        {
            c.a(b.a(intent.getScanResults()));
            context.a(c.e());
        }
    }

    ger()
    {
    }
}
