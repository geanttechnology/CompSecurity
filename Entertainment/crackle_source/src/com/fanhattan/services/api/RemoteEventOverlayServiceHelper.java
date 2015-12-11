// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.api;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public final class RemoteEventOverlayServiceHelper
{

    public static final String ACTION_TOGGLE_REMOTE_EVENT_OVERLAY = "com.fanhattan.services.TOGGLE_REMOTE_EVENT_OVERLAY";
    public static final String SERVICE_CLASS_NAME = "com.fanhattan.services.FanhattanService";
    public static final String SERVICE_PCK = "com.fanhattan.services";
    public static final String TAG = "RemoteEventOverlayServiceHelper";

    private RemoteEventOverlayServiceHelper()
    {
        throw new IllegalAccessError();
    }

    public static void toggle(Context context)
    {
        try
        {
            Intent intent = new Intent("com.fanhattan.services.TOGGLE_REMOTE_EVENT_OVERLAY");
            intent.setClassName("com.fanhattan.services", "com.fanhattan.services.FanhattanService");
            context.startService(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("RemoteEventOverlayServiceHelper", (new StringBuilder()).append("Cannot send a command to Fanhattan Services ").append(context.getMessage()).toString());
        }
    }
}
