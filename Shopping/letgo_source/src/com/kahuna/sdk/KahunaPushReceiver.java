// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.kahuna.sdk:
//            q, g, f

public class KahunaPushReceiver extends BroadcastReceiver
{

    private static boolean a = false;
    private final q b = new q((new StringBuilder()).append("[").append(getClass().getName()).append("]: ").toString());

    public KahunaPushReceiver()
    {
    }

    static final String b(Context context)
    {
        return "com.kahuna.sdk.KahunaPushService";
    }

    protected String a(Context context)
    {
        return b(context);
    }

    public final void onReceive(Context context, Intent intent)
    {
        b.a(2, "onReceive: %s", new Object[] {
            intent.getAction()
        });
        if (!a)
        {
            a = true;
            g.a(context, getClass().getName());
        }
        String s = a(context);
        b.a(2, "GCM IntentService class: %s", new Object[] {
            s
        });
        f.a(context, intent, s);
        setResult(-1, null, null);
    }

}
