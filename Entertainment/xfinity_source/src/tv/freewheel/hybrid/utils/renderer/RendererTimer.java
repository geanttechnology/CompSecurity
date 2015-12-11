// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.utils.renderer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import tv.freewheel.hybrid.utils.Logger;

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
    private Logger logger;
    private AtomicInteger state;
    private Timer timer;
    private IRendererTimerService timerService;

    public RendererTimer(int i, IRendererTimerService irenderertimerservice)
    {
        logger = Logger.getLogger(this);
        logger.debug((new StringBuilder()).append("RendererTimer(duration=").append(i).append(")").toString());
        duration = i;
        counter = i;
        timerService = irenderertimerservice;
        timer = new Timer();
        state = new AtomicInteger(-1);
    }

    public void pause()
    {
        logger.debug("pause");
        state.set(1);
    }

    public void resume()
    {
        logger.debug("resume");
        state.set(0);
    }

    public void start()
    {
        logger.debug("start");
        state.set(0);
        TimerTask timertask = new TimerTask() {

            final RendererTimer this$0;

            public void run()
            {
                logger.debug((new StringBuilder()).append("tick duration=").append(duration).append(", counter=").append(counter).toString());
                if (state.get() != 0)
                {
                    return;
                }
                if (counter > 0)
                {
                    int i = this.access$110;
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
        logger.debug("stop");
        state.set(2);
        if (timer != null)
        {
            timer.purge();
            timer.cancel();
            timer = null;
        }
    }





/*
    static int access$110(RendererTimer renderertimer)
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
