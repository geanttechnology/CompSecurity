// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class b
{

    private static b sInstance;
    private ConnectivityManager mConnectivityManager;

    private b(Context context)
    {
        mConnectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        context = mConnectivityManager.getActiveNetworkInfo();
        if (context != null)
        {
            if (!context.isConnectedOrConnecting());
        }
    }

    public static b a()
    {
        if (sInstance == null)
        {
            throw new IllegalStateException("No instance of Connectivity found.  Have you called Connectivity.init()?");
        } else
        {
            return sInstance;
        }
    }

    public static void a(Context context)
    {
        sInstance = new b(context);
    }

    public boolean b()
    {
        NetworkInfo networkinfo = mConnectivityManager.getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnectedOrConnecting();
    }
}
