// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class val.s
    implements Runnable
{

    final is._cls0 this$1;
    final int val$s;

    public void run()
    {
        if (!shouldCloseApp)
        {
            videoState = val$s;
            if (videoState == 1)
            {
                errorCount = 0;
            }
            if (!MixerBoxClient.isConnectingToInternet(_fld0))
            {
                tvNoNet.setVisibility(0);
                stopPlayer();
                return;
            }
            if (videoState == 1 && tvNoNet.getVisibility() == 0)
            {
                tvNoNet.setVisibility(8);
                playMusic(false);
            }
            if (MainPage.playerType == 2 && !hasSetCanAuto && videoState == 1)
            {
                hasSetCanAuto = true;
                rlHint.setVisibility(8);
                MainPage.access$600(_fld0);
            }
            if (tvSwitch.getVisibility() == 0 && videoState == 1)
            {
                tvSwitch.setVisibility(8);
                MixerBoxSharedPreferences.putPlayerType(_fld0, 1);
                MainPage.playerType = 1;
                MainPage.access$600(_fld0);
            }
            if (videoState == 1 && shouldResetTime)
            {
                shouldResetTime = false;
                wv.loadUrl((new StringBuilder()).append("javascript:seekTo(").append(resetTime).append(")").toString());
                resetTime = 0;
                return;
            }
        }
    }

    ()
    {
        this$1 = final_;
        val$s = I.this;
        super();
    }
}
