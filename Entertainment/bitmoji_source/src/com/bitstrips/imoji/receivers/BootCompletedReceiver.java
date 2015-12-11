// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bitstrips.imoji.ImojiApplication;
import com.bitstrips.imoji.manager.FloaterServiceManager;
import com.bitstrips.imoji.util.PreferenceUtils;

public class BootCompletedReceiver extends BroadcastReceiver
{

    FloaterServiceManager floaterServiceManager;
    PreferenceUtils preferenceUtils;

    public BootCompletedReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        ((ImojiApplication)context.getApplicationContext()).inject(this);
        boolean flag = preferenceUtils.getBoolean(0x7f060083, true);
        context = preferenceUtils.getString(0x7f06002a, null);
        if (flag && context != null)
        {
            floaterServiceManager.startFloaterService();
        }
    }
}
