// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.media;

import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.rdio.android.core.media:
//            SimpleUriAudioPlayer

private class <init>
{

    final SimpleUriAudioPlayer this$0;
    private Timer timer;
    private TimerTask timerTask;

    public void pause()
    {
        if (timer != null)
        {
            timer.cancel();
        }
    }

    public void resume()
    {
        timer = new Timer();
        if (timerTask != null)
        {
            timerTask.cancel();
        }
        timerTask = new TimerTask() {

            final SimpleUriAudioPlayer.PositionTimer this$1;

            public void run()
            {
                SimpleUriAudioPlayer.access$100(this$0);
            }

            
            {
                this$1 = SimpleUriAudioPlayer.PositionTimer.this;
                super();
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0L, 1000L);
    }

    private _cls1.this._cls1()
    {
        this$0 = SimpleUriAudioPlayer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
