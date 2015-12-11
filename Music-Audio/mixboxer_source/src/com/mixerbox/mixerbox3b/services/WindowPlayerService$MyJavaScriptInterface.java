// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.webkit.WebView;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

// Referenced classes of package com.mixerbox.mixerbox3b.services:
//            WindowPlayerService

public class this._cls0
{

    final WindowPlayerService this$0;

    public void log(String s)
    {
        MixerBoxUtils.logMsg((new StringBuilder()).append("FROM JS: ").append(s).toString());
    }

    public void onPlayerReady()
    {
        isReady = true;
        if (shouldPlayAfterReady)
        {
            wv.loadUrl((new StringBuilder()).append("javascript:loadVideoById('").append(musicId).append("',0)").toString());
            flag = true;
        }
        shouldPlayAfterReady = false;
    }

    public void playNext()
    {
        Message message = Message.obtain(null, 0xbc5c01);
        try
        {
            messenger.send(message);
            return;
        }
        catch (RemoteException remoteexception)
        {
            remoteexception.printStackTrace();
        }
    }

    public void setCurrentTime(int i)
    {
        current = i;
        MixerBoxUtils.logMsg((new StringBuilder()).append("FROM JS: ").append(i).toString());
    }

    public ()
    {
        this$0 = WindowPlayerService.this;
        super();
    }
}
