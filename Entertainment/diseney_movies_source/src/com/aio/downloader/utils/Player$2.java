// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;

// Referenced classes of package com.aio.downloader.utils:
//            Player

class this._cls0 extends Handler
{

    final Player this$0;

    public void handleMessage(Message message)
    {
        int i = mediaPlayer.getCurrentPosition();
        int j = mediaPlayer.getDuration();
        if (j > 0)
        {
            long l = (Player.access$0(Player.this).getMax() * i) / j;
            Player.access$0(Player.this).setProgress((int)l);
        }
    }

    ()
    {
        this$0 = Player.this;
        super();
    }
}
