// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

public class EarphoneReceiver extends BroadcastReceiver
{

    public EarphoneReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        if (bundle != null && intent.getAction().equals("Earphone") && bundle.containsKey("key"))
        {
            int i = bundle.getInt("key");
            intent.removeExtra("key");
            if (i == 126)
            {
                if (((MainPage)context).videoState == 2)
                {
                    ((MainPage)context).wv.loadUrl("javascript:playVideo()");
                }
            } else
            {
                if (i == 127 || i == 86)
                {
                    ((MainPage)context).wv.loadUrl("javascript:pauseVideo()");
                    return;
                }
                if (i == 87 || i == 90)
                {
                    ((MainPage)context).playNextSong();
                    return;
                }
                if (i == 88 || i == 89)
                {
                    ((MainPage)context).playPreviousSong();
                    return;
                }
                if (i == 85 || i == 79)
                {
                    if (((MainPage)context).videoState == 2)
                    {
                        ((MainPage)context).wv.loadUrl("javascript:playVideo()");
                        MixerBoxUtils.logMsg("play");
                        return;
                    } else
                    {
                        ((MainPage)context).wv.loadUrl("javascript:pauseVideo()");
                        MixerBoxUtils.logMsg("pause");
                        return;
                    }
                }
            }
        }
    }
}
