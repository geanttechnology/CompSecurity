// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class WakeUp extends BroadcastReceiver
{

    public WakeUp()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Log.d("DataBerriesWakeUp", "Cable connected or disconnected");
    }
}
