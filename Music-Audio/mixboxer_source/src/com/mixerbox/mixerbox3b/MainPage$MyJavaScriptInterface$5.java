// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        isReady = true;
        if (SCREEN_STATE == 1)
        {
            wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W).append(",").append(JS_Player_H).append(")").toString());
        } else
        {
            wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W_F).append(",").append(JS_Player_H_F).append(")").toString());
        }
        if (MainPage.playerType == 0)
        {
            rlHint.setVisibility(0);
            MainPage.playerType = 2;
            MixerBoxSharedPreferences.putPlayerType(_fld0, 2);
            playMusic(false);
        } else
        if (shouldPlayAfterReady)
        {
            shouldPlayAfterReady = false;
            playMusic(false);
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
