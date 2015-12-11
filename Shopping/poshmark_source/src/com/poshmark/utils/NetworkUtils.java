// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.poshmark.application.PMApplication;

public class NetworkUtils
{

    public NetworkUtils()
    {
    }

    public static boolean isOnline()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)PMApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnectedOrConnecting();
    }
}
