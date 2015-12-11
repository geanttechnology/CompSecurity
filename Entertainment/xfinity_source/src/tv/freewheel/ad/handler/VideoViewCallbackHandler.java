// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.handler;

import java.net.MalformedURLException;
import tv.freewheel.ad.EventCallback;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.Scheduler;

// Referenced classes of package tv.freewheel.ad.handler:
//            EventCallbackHandler

public class VideoViewCallbackHandler extends EventCallbackHandler
{

    private static int intervals[] = {
        5, 10, 15, 30, 60, 120, 180, 300
    };
    private boolean initSent;
    private int interval_index;
    public boolean replay;
    private Scheduler scheduler;

    public VideoViewCallbackHandler(EventCallback eventcallback)
        throws MalformedURLException
    {
        super(eventcallback);
        interval_index = -1;
        initSent = false;
        replay = false;
        scheduler = new Scheduler();
        scheduler.setTask(new Runnable() {

            final VideoViewCallbackHandler this$0;

            public void run()
            {
                send(scheduler.getLastRunDuration());
                int i = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = VideoViewCallbackHandler.this;
                super();
            }
        });
    }

    public void complete()
    {
        scheduler.pause();
        send(scheduler.getLastRunDuration());
        scheduler.stop();
        scheduler = new Scheduler();
        interval_index = -1;
        initSent = false;
    }

    public void resume()
    {
        scheduler.resume();
    }

    public void send(long l)
    {
        if (replay)
        {
            setParameter("init", "2");
        } else
        if (initSent)
        {
            setParameter("init", "0");
        } else
        {
            setParameter("init", "1");
            sendTrackingCallback();
            initSent = true;
        }
        setParameter("ct", String.valueOf(l));
        send();
    }

    public void start(long l)
    {
        logger.info((new StringBuilder()).append("delaySeconds: ").append(l).toString());
        int i = 0;
        do
        {
label0:
            {
                if (i < intervals.length)
                {
                    if (l >= (long)intervals[i])
                    {
                        break label0;
                    }
                    interval_index = i;
                }
                send(l);
                if (interval_index < 0)
                {
                    interval_index = 7;
                }
                scheduler.start(intervals[interval_index], false);
                return;
            }
            i++;
        } while (true);
    }





/*
    static int access$102(VideoViewCallbackHandler videoviewcallbackhandler, int i)
    {
        videoviewcallbackhandler.interval_index = i;
        return i;
    }

*/


/*
    static int access$104(VideoViewCallbackHandler videoviewcallbackhandler)
    {
        int i = videoviewcallbackhandler.interval_index + 1;
        videoviewcallbackhandler.interval_index = i;
        return i;
    }

*/

}
