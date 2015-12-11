// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package com.sessionm.core:
//            f

public class d
{

    private static final String bn = "com.sessionm.iap";
    private static final String bo = "SessionMIAPPrefsFile";
    private static final String bp = "amount_spent";
    private Context bg;
    private float bq;

    public d(Context context)
    {
        bg = context;
        if (context != null)
        {
            bq = context.getSharedPreferences("SessionMIAPPrefsFile", 0).getFloat("amount_spent", 0.0F);
        }
    }

    private void b(float f1)
    {
        bq = f1;
    }

    public static void t()
    {
        f.E().logAction("com.sessionm.iap", 1);
    }

    public void a(float f1)
    {
        b(u() + f1);
        android.content.SharedPreferences.Editor editor = bg.getSharedPreferences("SessionMIAPPrefsFile", 0).edit();
        editor.putFloat("amount_spent", u());
        editor.commit();
    }

    public void g(Context context)
    {
        b(0.0F);
        context = context.getSharedPreferences("SessionMIAPPrefsFile", 0).edit();
        context.putFloat("amount_spent", 0.0F);
        context.commit();
    }

    public float u()
    {
        this;
        JVM INSTR monitorenter ;
        float f1 = bq;
        this;
        JVM INSTR monitorexit ;
        return f1;
        Exception exception;
        exception;
        throw exception;
    }
}
