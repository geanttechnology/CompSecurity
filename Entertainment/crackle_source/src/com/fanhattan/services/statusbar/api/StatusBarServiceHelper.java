// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.statusbar.api;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public final class StatusBarServiceHelper
{

    public static final String INTENT_ACTION_HIDE_STATUS_BAR = "com.fanhattan.services.HIDE_STATUS_BAR";
    public static final String INTENT_ACTION_SHOW_STATUS_BAR = "com.fanhattan.services.SHOW_STATUS_BAR";
    public static final String SERVICE_CLASS_NAME = "com.fanhattan.services.FanhattanService";
    public static final String SERVICE_PCK = "com.fanhattan.services";
    public static final String TAG = "StatusBarServiceHelper";

    private StatusBarServiceHelper()
    {
        throw new IllegalAccessError();
    }

    public static boolean hide(Context context)
    {
        try
        {
            Intent intent = new Intent("com.fanhattan.services.HIDE_STATUS_BAR");
            intent.setClassName("com.fanhattan.services", "com.fanhattan.services.FanhattanService");
            context.startService(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("StatusBarServiceHelper", (new StringBuilder()).append("Cannot hide status bar ").append(context.getMessage()).toString());
            return false;
        }
        return true;
    }

    public static boolean show(Context context)
    {
        try
        {
            Intent intent = new Intent("com.fanhattan.services.SHOW_STATUS_BAR");
            intent.setClassName("com.fanhattan.services", "com.fanhattan.services.FanhattanService");
            context.startService(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("StatusBarServiceHelper", (new StringBuilder()).append("Cannot show status bar ").append(context.getMessage()).toString());
            return false;
        }
        return true;
    }
}
