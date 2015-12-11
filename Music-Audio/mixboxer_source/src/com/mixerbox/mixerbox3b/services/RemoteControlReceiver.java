// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

public class RemoteControlReceiver extends BroadcastReceiver
{

    public RemoteControlReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction()))
        {
            intent = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (intent.getAction() == 0)
            {
                Intent intent1 = new Intent();
                intent1.setAction("Earphone");
                intent1.putExtra("key", intent.getKeyCode());
                MixerBoxUtils.logMsg((new StringBuilder()).append(intent.getKeyCode()).append("").toString());
                context.sendBroadcast(intent1);
            }
        }
    }
}
