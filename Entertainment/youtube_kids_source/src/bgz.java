// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;

final class bgz extends bmr
{

    private bgv a;

    bgz(bgv bgv1)
    {
        a = bgv1;
        super();
    }

    public final Object a()
    {
        bgv bgv1 = a;
        return new bjw((ConnectivityManager)bgv1.b.getSystemService("connectivity"), (WifiManager)bgv1.b.getSystemService("wifi"), bjw.a);
    }
}
