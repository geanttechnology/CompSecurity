// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;

public final class h
{

    private static h b;
    private SharedPreferences a;

    private h(Context context)
    {
        a = context.getSharedPreferences("PAYMENTS_PREFS", 0);
    }

    public static h a(Context context)
    {
        com/b/a/a/h;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new h(context);
        }
        context = b;
        com/b/a/a/h;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private void a(int i)
    {
        a.edit().putInt("PaySellerToolTipCount", i).apply();
    }

    public final void a()
    {
        a(3);
    }

    public final boolean b()
    {
        boolean flag = false;
        int i = a.getInt("PaySellerToolTipCount", 0);
        if (i < 3)
        {
            a(i + 1);
            flag = true;
        }
        return flag;
    }

    public final void c()
    {
        a(0);
    }
}
