// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class BatteryConnectionReceiver extends BroadcastReceiver
{

    public BatteryConnectionReceiver()
    {
    }

    public abstract void onBatteryLow();

    public abstract void onBatteryOkay();

    public void onReceive(Context context, Intent intent)
    {
        byte byte0;
        context = intent.getAction();
        byte0 = -1;
        context.hashCode();
        JVM INSTR lookupswitch 2: default 36
    //                   -1980154005: 75
    //                   490310653: 61;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_75;
_L4:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            onBatteryLow();
            return;

        case 1: // '\001'
            onBatteryOkay();
            break;
        }
        break MISSING_BLOCK_LABEL_98;
_L3:
        if (context.equals("android.intent.action.BATTERY_LOW"))
        {
            byte0 = 0;
        }
          goto _L4
        if (context.equals("android.intent.action.BATTERY_OKAY"))
        {
            byte0 = 1;
        }
          goto _L4
    }
}
