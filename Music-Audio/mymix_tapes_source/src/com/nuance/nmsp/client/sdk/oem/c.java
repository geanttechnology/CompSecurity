// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import bk;
import bm;
import d;
import java.util.UUID;

public class c
    implements bk
{

    private static final bm a = d.a(com/nuance/nmsp/client/sdk/oem/c);
    private static bk b;
    private Context c;

    private c()
    {
        c = null;
    }

    public c(Context context)
    {
        c = null;
        c = context;
        context.getSystemService("phone");
    }

    public static bk e()
    {
        com/nuance/nmsp/client/sdk/oem/c;
        JVM INSTR monitorenter ;
        bk bk1;
        if (b == null)
        {
            b = new c();
        }
        bk1 = b;
        com/nuance/nmsp/client/sdk/oem/c;
        JVM INSTR monitorexit ;
        return bk1;
        Exception exception;
        exception;
        throw exception;
    }

    public final String a()
    {
        return Build.MODEL;
    }

    public final String b()
    {
        return Build.DEVICE;
    }

    public final String c()
    {
        return "Android";
    }

    public final String d()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    public final String f()
    {
        Object obj = c.getSharedPreferences("nuance_sdk_pref", 0);
        String s1 = ((SharedPreferences) (obj)).getString("NUANCE_NMSP_UID", "");
        String s = s1;
        if (s1.length() == 0)
        {
            s = UUID.randomUUID().toString();
            s1 = s;
            if (s != null)
            {
                s1 = s.replaceAll("-", "");
            }
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("NUANCE_NMSP_UID", s1);
            s = s1;
            if (!((android.content.SharedPreferences.Editor) (obj)).commit())
            {
                a.e("Storing nuance sdk uid has failed");
                s = s1;
            }
        }
        s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        return s1;
    }

}
