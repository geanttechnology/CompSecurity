// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public final class bju extends BroadcastReceiver
{

    private final IntentFilter a = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    private final bje b;
    private boolean c;

    public bju(Context context, bje bje1)
    {
        c = false;
        b.a(context);
        b = (bje)b.a(bje1);
        context.registerReceiver(this, a);
    }

    public final void onReceive(Context context, Intent intent)
    {
        boolean flag = false;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()))
        {
            if (!intent.getBooleanExtra("noConnectivity", false))
            {
                flag = true;
            }
            c = flag;
            b.c(new bjv(c));
            return;
        } else
        {
            context = String.valueOf(intent);
            bmo.c((new StringBuilder(String.valueOf(context).length() + 72)).append("unexpected intent.  Received action does not match CONNECTIVITY_ACTION. ").append(context).toString());
            return;
        }
    }
}
