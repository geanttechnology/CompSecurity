// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.util;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class RendererTimer
{
    public static interface IRendererTimerService
    {

        public abstract void playHeadTime(int i);

        public abstract void timeOut();
    }


    private static String CLASSTAG = "RendererTimer";
    private int counter;
    private int duration;
    private AtomicInteger state;
    private Timer timer;
    private IRendererTimerService timerService;

    public RendererTimer(int i, IRendererTimerService irenderertimerservice)
    {
        Log.d(CLASSTAG, (new StringBuilder()).append("RendererTimer(duration=").append(i).append(")").toString());
        duration = i;
        counter = i;
        timerService = irenderertimerservice;
        timer = new Timer();
        state = new AtomicInteger(-1);
    }

    public void pause()
    {
        Log.d(CLASSTAG, "pause");
        state.set(1);
    }

    public void reset()
    {
        Log.d(CLASSTAG, "reset");
        state.set(-1);
        counter = duration;
    }

    public void resume()
    {
        Log.d(CLASSTAG, "resume");
        state.set(0);
    }

    public void start()
    {
        Log.d(CLASSTAG, "start");
        state.set(0);
        TimerTask timertask = new TimerTask() {

            final RendererTimer this$0;

            public void run()
            {
                Log.d(RendererTimer.CLASSTAG, (new StringBuilder()).append("tick duration=").append(duration).append(", counter=").append(counter).toString());
                if (state.get() != 0)
                {
                    return;
                }
                if (counter > 0)
                {
                    int i = ((java.util.concurrent.atomic) (this)).;
                } else
                {
                    timer.purge();
                    timer.cancel();
                    timer = null;
                    timerService.timeOut();
                }
                timerService.playHeadTime(duration - counter);
            }

            
            {
                this$0 = RendererTimer.this;
                super();
            }
        };
        timer.scheduleAtFixedRate(timertask, 0L, 1000L);
    }

    public void stop()
    {
        Log.d(CLASSTAG, "stop");
        state.set(2);
        if (timer != null)
        {
            timer.purge();
            timer.cancel();
            timer = null;
        }
    }






/*
    static int access$210(RendererTimer renderertimer)
    {
        int i = renderertimer.counter;
        renderertimer.counter = i - 1;
        return i;
    }

*/




/*
    static Timer access$402(RendererTimer renderertimer, Timer timer1)
    {
        renderertimer.timer = timer1;
        return timer1;
    }

*/

}
