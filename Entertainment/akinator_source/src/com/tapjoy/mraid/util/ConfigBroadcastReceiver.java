// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.mraid.controller.Display;

public class ConfigBroadcastReceiver extends BroadcastReceiver
{

    private Display a;
    private int b;

    public ConfigBroadcastReceiver(Display display)
    {
        a = display;
        b = a.getOrientation();
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
        {
            int i = a.getOrientation();
            if (i != b)
            {
                b = i;
                a.onOrientationChanged(b);
            }
        }
    }
}
