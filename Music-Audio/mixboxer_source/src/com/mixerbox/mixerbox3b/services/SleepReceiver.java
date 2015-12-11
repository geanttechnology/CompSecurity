// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mixerbox.mixerbox3b.MainPage;

public class SleepReceiver extends BroadcastReceiver
{

    public SleepReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getExtras() != null && intent.getAction().equals("SleepService"))
        {
            ((MainPage)context).shouldCloseApp = true;
            ((MainPage)context).closePlayer();
            ((MainPage)context).finish();
        }
    }
}
