// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;

// Referenced classes of package com.a.b:
//            n

final class r extends BroadcastReceiver
{

    final n a;
    private final ConnectivityManager b;

    r(n n1, Context context)
    {
        a = n1;
        super();
        b = (ConnectivityManager)context.getSystemService("connectivity");
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (intent != null)
        {
            context = intent.getAction();
            intent = intent.getExtras();
            if ("android.intent.action.AIRPLANE_MODE".equals(context))
            {
                context = a;
                boolean flag = intent.getBoolean("state", false);
                intent = ((n) (context)).f;
                context = ((n) (context)).f;
                int i;
                if (flag)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                intent.sendMessage(context.obtainMessage(10, i, 0));
                return;
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(context))
            {
                context = a;
                intent = b.getActiveNetworkInfo();
                ((n) (context)).f.sendMessage(((n) (context)).f.obtainMessage(9, intent));
                return;
            }
        }
    }
}
