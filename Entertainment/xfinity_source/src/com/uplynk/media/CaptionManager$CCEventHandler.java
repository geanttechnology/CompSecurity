// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.uplynk.media:
//            CaptionManager, MediaPlayer

protected class _cc extends Handler
{

    private CaptionManager _cc;
    private MediaPlayer _mediaPlayer;
    final CaptionManager this$0;

    public void handleMessage(Message message)
    {
        if (!_mediaPlayer.hasNativeContext())
        {
            Log.w("upLynkCaptionManager", "mediaplayer went away with unhandled closed caption events");
        } else
        {
            int i = message.arg1;
            if (_cc._preferredChannelIndex == i)
            {
                if (message.what == 0)
                {
                    clearDisplay();
                    return;
                }
                if (message.what == 1)
                {
                    CaptionManager.access$0(CaptionManager.this).removeMessages(0);
                    int j = message.arg2;
                    message = (short[])message.obj;
                    if (j != message.length)
                    {
                        Log.e("upLynkCaptionManager", (new StringBuilder("CC: Data Packet doesn't match advertised length  (")).append(message.length).append(" vs ").append(j).append(")").toString());
                        return;
                    } else
                    {
                        _cc.renderCCData(j, message);
                        return;
                    }
                }
                if (message.what == 2)
                {
                    CaptionManager.access$0(CaptionManager.this).removeMessages(0);
                    message = (m)message.obj;
                    _cc.renderCCStreamItem(message);
                    return;
                }
            }
        }
    }


    public m(MediaPlayer mediaplayer, CaptionManager captionmanager1, Looper looper)
    {
        this$0 = CaptionManager.this;
        super(looper);
        _mediaPlayer = mediaplayer;
        _cc = captionmanager1;
    }
}
