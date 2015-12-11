// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.api;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public final class WipeDataServiceHelper
{

    public static final String ACTION_WIPE_USER_DATA = "com.fanhattan.services.WIPE_USER_DATA";
    public static final String SERVICE_CLASS_NAME = "com.fanhattan.services.WipeDataService";
    public static final String SERVICE_PCK = "com.fanhattan.services";
    public static final String TAG = "WipeDataServiceHelper";

    private WipeDataServiceHelper()
    {
        throw new IllegalAccessError();
    }

    public static boolean wipeData(Context context)
    {
        try
        {
            Intent intent = new Intent("com.fanhattan.services.WIPE_USER_DATA");
            intent.setClassName("com.fanhattan.services", "com.fanhattan.services.WipeDataService");
            context.startService(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("WipeDataServiceHelper", (new StringBuilder()).append("Cannot send wipe user data command to Fanhattan Services ").append(context.getMessage()).toString());
            return false;
        }
        return true;
    }
}
