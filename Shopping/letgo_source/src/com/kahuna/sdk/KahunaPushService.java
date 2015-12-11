// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

// Referenced classes of package com.kahuna.sdk:
//            f, m, k, i, 
//            w, h

public class KahunaPushService extends f
{

    public KahunaPushService()
    {
        super(new String[] {
            m.c
        });
    }

    protected void a(Context context, Intent intent)
    {
        if (m.a)
        {
            Log.d("Kahuna", "onMessage recieved a push event.");
        }
        if (!k.i().g())
        {
            Log.d("Kahuna", "Received Kahuna push, but Push is not enabled. Aborting the notification!");
            return;
        } else
        {
            w.a(context, intent.getExtras());
            return;
        }
    }

    protected void a(Context context, String s)
    {
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("onError recieved errorId: ").append(s).toString());
        }
    }

    protected void b(Context context, String s)
    {
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("onRegistered recieved Push Token: ").append(s).toString());
        }
        h.b(s);
    }

    protected void c(Context context, String s)
    {
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("onUnregistered recieved to remove Push Token: ").append(s).toString());
        }
        h.d();
    }
}
