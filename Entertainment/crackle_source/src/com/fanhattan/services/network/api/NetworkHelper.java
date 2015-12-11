// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.network.api;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public final class NetworkHelper
{

    public static final String INTENT_ACTION_DISABLE_NO_NETWORK_DIALOG = "com.fanhattan.services.network.DISABLE_NO_NETWORK_DIALOG";
    public static final String INTENT_ACTION_ENABLE_NO_NETWORK_DIALOG = "com.fanhattan.services.network.ENABLE_NO_NETWORK_DIALOG";
    public static final String SERVICE_CLASS_NAME = "com.fanhattan.services.FanhattanService";
    public static final String SERVICE_PCK = "com.fanhattan.services";
    public static final String TAG = "NetworkHelper";

    private NetworkHelper()
    {
        throw new IllegalAccessError();
    }

    public static boolean disableNoNetworkDialog(Context context)
    {
        try
        {
            Intent intent = new Intent("com.fanhattan.services.network.DISABLE_NO_NETWORK_DIALOG");
            intent.setClassName("com.fanhattan.services", "com.fanhattan.services.FanhattanService");
            context.startService(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("NetworkHelper", (new StringBuilder()).append("Cannot disable no network dialog ").append(context.getMessage()).toString());
            return false;
        }
        return true;
    }

    public static boolean enableNoNetworkDialog(Context context)
    {
        try
        {
            Intent intent = new Intent("com.fanhattan.services.network.ENABLE_NO_NETWORK_DIALOG");
            intent.setClassName("com.fanhattan.services", "com.fanhattan.services.FanhattanService");
            context.startService(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("NetworkHelper", (new StringBuilder()).append("Cannot enable no network dialog ").append(context.getMessage()).toString());
            return false;
        }
        return true;
    }
}
