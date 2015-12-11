// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shazam.android.service.unsubmitted.l;
import com.shazam.i.b.am.a;

// Referenced classes of package com.shazam.android.receiver:
//            b

public class ConnectivityReceiver extends BroadcastReceiver
{

    private final b a;
    private final com.shazam.android.service.a b[];

    public ConnectivityReceiver()
    {
        this(com.shazam.i.b.am.a.a(), new com.shazam.android.service.a[] {
            new l()
        });
    }

    public transient ConnectivityReceiver(b b1, com.shazam.android.service.a aa[])
    {
        a = b1;
        b = aa;
    }

    public void onReceive(Context context, Intent intent)
    {
        int i = 0;
        boolean flag;
        if (!intent.getBooleanExtra("noConnectivity", false))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        (new StringBuilder("action: ")).append(intent.getAction()).append("  isConnected: ").append(flag);
        if (flag)
        {
            a.a(false);
            intent = b;
            for (int j = intent.length; i < j; i++)
            {
                intent[i].a(context);
            }

        }
    }
}
