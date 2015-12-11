// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.webkit.WebView;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        wv.loadUrl((new StringBuilder()).append("javascript:setQuality(").append(JS_Player_W_F).append(",").append(MixerBoxSharedPreferences.getHighQuality(_fld0)).append(")").toString());
        if (shouldPlayAfterReady)
        {
            shouldPlayAfterReady = false;
            playMusic(false);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
