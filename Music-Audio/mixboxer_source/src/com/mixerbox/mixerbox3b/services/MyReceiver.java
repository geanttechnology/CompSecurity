// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mixerbox.mixerbox3b.MainPage;

public class MyReceiver extends BroadcastReceiver
{

    public MyReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        if (bundle != null && intent.getAction().equals("MyService") && bundle.containsKey("t"))
        {
            int i = bundle.getInt("t");
            intent.removeExtra("t");
            if (i == 0)
            {
                ((MainPage)context).playNextSong();
            } else
            {
                if (i == 1)
                {
                    i = bundle.getInt("d");
                    ((MainPage)context).setSongTime(i / 1000);
                    return;
                }
                if (i == 2)
                {
                    int j = bundle.getInt("c");
                    ((MainPage)context).updateTime(j / 1000);
                    if (j / 1000 < 5)
                    {
                        ((MainPage)context).checkButton();
                        return;
                    }
                }
            }
        }
    }
}
