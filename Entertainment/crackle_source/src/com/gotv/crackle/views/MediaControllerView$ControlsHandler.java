// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.gotv.crackle.views:
//            MediaControllerView

private class <init> extends Handler
{

    final MediaControllerView this$0;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 29
    //                   1 57;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        MediaControllerView.access$1400(MediaControllerView.this);
        if (!MediaControllerView.access$000())
        {
            sendMessageDelayed(obtainMessage(0), 1000L);
            return;
        }
          goto _L1
_L3:
        hideControls();
        return;
    }

    public void resetHideTimer()
    {
        resetHideTimer(5000);
    }

    public void resetHideTimer(int i)
    {
        MediaControllerView.access$200(MediaControllerView.this).removeMessages(1);
        MediaControllerView.access$200(MediaControllerView.this).sendEmptyMessageDelayed(1, i);
    }

    public void startUpdateLoop()
    {
        MediaControllerView.access$200(MediaControllerView.this).sendEmptyMessage(0);
    }

    public void startUpdateLoopDelayed(long l)
    {
        MediaControllerView.access$200(MediaControllerView.this).removeMessages(0);
        MediaControllerView.access$200(MediaControllerView.this).sendEmptyMessageDelayed(0, l);
    }

    public void stopUpdateLoop()
    {
        MediaControllerView.access$200(MediaControllerView.this).removeMessages(0);
    }

    private ()
    {
        this$0 = MediaControllerView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
