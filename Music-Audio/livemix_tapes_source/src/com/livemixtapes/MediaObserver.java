// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.media.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.livemixtapes:
//            LMTService, console, NowPlayingActivity

public class MediaObserver
    implements Runnable
{

    private Activity activity;
    private AtomicBoolean stop;
    volatile boolean task1Running;
    private AtomicBoolean ultrastop;

    public MediaObserver(Activity activity1)
    {
        stop = new AtomicBoolean(false);
        ultrastop = new AtomicBoolean(false);
        task1Running = false;
        if (task1Running)
        {
            return;
        } else
        {
            task1Running = true;
            activity = activity1;
            return;
        }
    }

    public void run()
    {
        stop.set(false);
        do
        {
            if (ultrastop.get())
            {
                return;
            }
            try
            {
                Thread.sleep(500L);
            }
            catch (Exception exception) { }
            activity.runOnUiThread(new Runnable() {

                final MediaObserver this$0;

                public void run()
                {
                    try
                    {
                        console.log(new Object[] {
                            (new StringBuilder("PROGRESS: ")).append(LMTService.mPlayer.getCurrentPosition()).toString()
                        });
                        if (!stop.get())
                        {
                            NowPlayingActivity.updatePosition();
                        }
                        return;
                    }
                    catch (Exception exception1)
                    {
                        return;
                    }
                }

            
            {
                this$0 = MediaObserver.this;
                super();
            }
            });
        } while (true);
    }

    public void stop()
    {
        stop.set(true);
    }

    public void unstop()
    {
        stop.set(false);
    }

}
