// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class ConnectionUtils
{

    private ConnectionUtils()
    {
    }

    public static NetworkInfo getNetworkInfo(Context context)
    {
        Object obj = null;
        ConnectivityManager connectivitymanager;
        try
        {
            connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        context = obj;
        if (connectivitymanager == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        context = connectivitymanager.getActiveNetworkInfo();
        return context;
    }

    private static transient NetworkInfo getNetworkInfo(Context context, int ai[])
    {
        context = getNetworkInfo(context);
        if (context != null)
        {
            int j = context.getType();
            int k = ai.length;
            for (int i = 0; i < k; i++)
            {
                if (ai[i] == j)
                {
                    return context;
                }
            }

        }
        return null;
    }

    public static transient boolean isConnected(Context context, boolean flag, int ai[])
    {
        boolean flag1;
label0:
        {
            boolean flag2 = false;
            context = getNetworkInfo(context, ai);
            flag1 = flag2;
            if (context == null)
            {
                break label0;
            }
            flag1 = flag2;
            if (!context.isConnected())
            {
                break label0;
            }
            if (!flag)
            {
                flag1 = flag2;
                if (context.isRoaming())
                {
                    break label0;
                }
            }
            flag1 = true;
        }
        return flag1;
    }

    public static boolean isWifi(Context context)
    {
        context = getNetworkInfo(context);
        if (context == null) goto _L2; else goto _L1
_L1:
        context.getType();
        JVM INSTR lookupswitch 2: default 40
    //                   1: 42
    //                   6: 42;
           goto _L2 _L3 _L3
_L2:
        return false;
_L3:
        return true;
    }
}
