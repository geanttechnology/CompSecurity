// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.IoError;

public class NetworkUtil
{

    private static volatile boolean _fallBackToHttpClient;

    public NetworkUtil()
    {
    }

    public static NetworkInfo getConnectedNetworkInfo(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager == null)
        {
            context = null;
        } else
        {
            NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
            context = networkinfo;
            if (networkinfo == null)
            {
                context = connectivitymanager.getAllNetworkInfo();
                if (context != null && context.length > 0)
                {
                    int j = context.length;
                    for (int i = 0; i < j; i++)
                    {
                        NetworkInfo networkinfo1 = context[i];
                        android.net.NetworkInfo.State state = networkinfo1.getState();
                        if (state == android.net.NetworkInfo.State.CONNECTED || state == android.net.NetworkInfo.State.CONNECTING)
                        {
                            return networkinfo1;
                        }
                    }

                }
                return null;
            }
        }
        return context;
    }

    public static boolean hasConnectedNetwork(Context context)
    {
        return getConnectedNetworkInfo(context) != null;
    }

    public static boolean isConnectionError(ResultStatus resultstatus)
    {
        return IoError.hasAnyIoError(resultstatus) && !com.ebay.nautilus.kernel.net.Connector.ClientErrorException.isClientError(resultstatus);
    }

    public static boolean isHttpClass1xx(int i)
    {
        return i / 100 == 1;
    }

    public static boolean isHttpClass2xx(int i)
    {
        return i / 100 == 2;
    }

    public static boolean isHttpClass3xx(int i)
    {
        return i / 100 == 3;
    }

    public static boolean isHttpClass4xx(int i)
    {
        return i / 100 == 4;
    }

    public static boolean isHttpClass5xx(int i)
    {
        return i / 100 == 5;
    }

    public static void useHttpClient(boolean flag)
    {
        _fallBackToHttpClient = flag;
    }

    public static boolean useHttpClient()
    {
        return _fallBackToHttpClient;
    }
}
