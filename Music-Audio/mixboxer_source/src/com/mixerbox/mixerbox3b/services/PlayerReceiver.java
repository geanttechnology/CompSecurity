// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

public class PlayerReceiver extends BroadcastReceiver
{

    public PlayerReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        int i;
label0:
        {
            Bundle bundle = intent.getExtras();
            if (bundle != null && intent.getAction().equals("PlayerBroadcastReceiver") && bundle.containsKey("player"))
            {
                i = bundle.getInt("player");
                intent.removeExtra("player");
                MixerBoxUtils.logMsg((new StringBuilder()).append("BUNDLE = ").append(i).toString());
                if (i != 1)
                {
                    break label0;
                }
                ((MainPage)context).musicPlayPause();
            }
            return;
        }
        if (i == 2)
        {
            ((MainPage)context).playPreviousSong();
            return;
        }
        if (i == 3)
        {
            ((MainPage)context).playNextSong();
            return;
        } else
        {
            ((NotificationManager)context.getSystemService("notification")).cancel(16);
            ((MainPage)context).shouldCloseApp = true;
            ((MainPage)context).closePlayer();
            ((MainPage)context).stopPlayer();
            ((MainPage)context).finish();
            return;
        }
    }
}
