// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.ConnectivityManager;

public final class cn
{

    private static final cp a;

    public static boolean a(ConnectivityManager connectivitymanager)
    {
        return a.a(connectivitymanager);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new cs();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            a = new cr();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            a = new cq();
        } else
        {
            a = new co();
        }
    }
}
