// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

// Referenced classes of package android.support.v7:
//            akn, alj

static class a extends BroadcastReceiver
{

    private final akn a;

    void a()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.AIRPLANE_MODE");
        if (a.o)
        {
            intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        a.b.registerReceiver(this, intentfilter);
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        s = intent.getAction();
        if (!"android.intent.action.AIRPLANE_MODE".equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!intent.hasExtra("state")) goto _L1; else goto _L3
_L3:
        a.a(intent.getBooleanExtra("state", false));
        return;
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(s)) goto _L1; else goto _L4
_L4:
        context = (ConnectivityManager)alj.a(context, "connectivity");
        a.a(context.getActiveNetworkInfo());
        return;
    }

    anager(akn akn1)
    {
        a = akn1;
    }
}
