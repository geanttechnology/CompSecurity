// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.media.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.livemixtapes:
//            MediaObserver, LMTService, console, NowPlayingActivity

class this._cls0
    implements Runnable
{

    final MediaObserver this$0;

    public void run()
    {
        try
        {
            console.log(new Object[] {
                (new StringBuilder("PROGRESS: ")).append(LMTService.mPlayer.getCurrentPosition()).toString()
            });
            if (!MediaObserver.access$0(MediaObserver.this).get())
            {
                NowPlayingActivity.updatePosition();
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    ty()
    {
        this$0 = MediaObserver.this;
        super();
    }
}
