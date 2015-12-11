// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.gimbal.internal.c.c;
import com.gimbal.internal.persistance.b;
import com.gimbal.internal.persistance.e;
import com.gimbal.internal.persistance.f;

public abstract class a extends BroadcastReceiver
    implements e
{

    private static final com.gimbal.a.a b = com.gimbal.internal.c.c.e(com/gimbal/internal/e/a.getName());
    public b a;
    private Context c;
    private IntentFilter d[];

    public transient a(b b1, Context context, IntentFilter aintentfilter[])
    {
        a = b1;
        c = context;
        d = aintentfilter;
    }

    public final void a(String s, Object obj)
    {
        int k = 0;
        int i = 0;
        try
        {
            c.unregisterReceiver(this);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        s = a.a.a("Broadcast_Receiver_Security_Permission", null);
        if (s != null)
        {
            obj = d;
            for (k = obj.length; i < k; i++)
            {
                IntentFilter intentfilter = obj[i];
                c.registerReceiver(this, intentfilter, s, null);
            }

        } else
        {
            s = d;
            int l = s.length;
            for (int j = k; j < l; j++)
            {
                obj = s[j];
                c.registerReceiver(this, ((IntentFilter) (obj)));
            }

        }
    }

}
