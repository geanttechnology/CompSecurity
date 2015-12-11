// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247.ApplicationStatusModel;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils
{

    public Utils()
    {
    }

    public static boolean isOnline(Activity activity)
    {
        activity = (ConnectivityManager)activity.getSystemService("connectivity");
        return activity.getActiveNetworkInfo() != null && activity.getActiveNetworkInfo().isAvailable() && activity.getActiveNetworkInfo().isConnected();
    }
}
