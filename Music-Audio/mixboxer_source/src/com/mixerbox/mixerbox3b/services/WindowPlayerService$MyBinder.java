// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.os.Binder;
import android.webkit.WebView;

// Referenced classes of package com.mixerbox.mixerbox3b.services:
//            WindowPlayerService

public class this._cls0 extends Binder
{

    final WindowPlayerService this$0;

    public int getCurrentTime()
    {
        return current;
    }

    public boolean getIsPlaying()
    {
        return flag;
    }

    public void pauseMusic()
    {
        flag = false;
        wv.loadUrl("javascript:pauseVideo()");
    }

    public void playMusic()
    {
        flag = true;
        wv.loadUrl("javascript:playVideo()");
    }

    public void playMusic(String s)
    {
        if (!isReady)
        {
            WindowPlayerService.access$000(WindowPlayerService.this);
            shouldPlayAfterReady = true;
            musicId = s;
            flag = false;
            return;
        } else
        {
            flag = true;
            wv.loadUrl((new StringBuilder()).append("javascript:loadVideoById('").append(s).append("',0)").toString());
            return;
        }
    }

    public ()
    {
        this$0 = WindowPlayerService.this;
        super();
    }
}
