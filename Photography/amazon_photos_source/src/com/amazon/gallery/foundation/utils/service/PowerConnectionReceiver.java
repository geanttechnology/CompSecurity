// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class PowerConnectionReceiver extends BroadcastReceiver
{

    public PowerConnectionReceiver()
    {
    }

    public abstract void onPowerConnected();

    public abstract void onPowerDisconnected();

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction() == "android.intent.action.ACTION_POWER_CONNECTED")
        {
            onPowerConnected();
        } else
        if (intent.getAction() == "android.intent.action.ACTION_POWER_DISCONNECTED")
        {
            onPowerDisconnected();
            return;
        }
    }
}
