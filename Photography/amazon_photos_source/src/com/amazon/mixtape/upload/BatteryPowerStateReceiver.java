// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;

import android.content.BroadcastReceiver;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public abstract class BatteryPowerStateReceiver extends BroadcastReceiver
{

    private final Collection mBatteryActions = new LinkedHashSet(3, 1.0F);
    private final Collection mPowerActions = Collections.singleton("android.os.action.POWER_SAVE_MODE_CHANGED");

    public BatteryPowerStateReceiver()
    {
        mBatteryActions.add("android.intent.action.BATTERY_CHANGED");
        mBatteryActions.add("android.intent.action.BATTERY_LOW");
        mBatteryActions.add("android.intent.action.BATTERY_OKAY");
        mBatteryActions.add("android.intent.action.ACTION_POWER_CONNECTED");
        mBatteryActions.add("android.intent.action.ACTION_POWER_DISCONNECTED");
    }
}
