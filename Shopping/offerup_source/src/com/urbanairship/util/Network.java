// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;

public class Network
{

    public Network()
    {
    }

    public static boolean isConnected()
    {
        Object obj = (ConnectivityManager)UAirship.getApplicationContext().getSystemService("connectivity");
        if (obj != null)
        {
            obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
            return obj != null && ((NetworkInfo) (obj)).isConnected();
        } else
        {
            Logger.error("Error fetching network info.");
            return false;
        }
    }
}
