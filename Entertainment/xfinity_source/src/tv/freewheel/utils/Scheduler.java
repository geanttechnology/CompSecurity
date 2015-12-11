// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.utils;

import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package tv.freewheel.utils:
//            Logger, RecordTimer

public class Scheduler
{

    private long lastRunDuration;
    private Logger logger;
    private boolean paused;
    private RecordTimer recordTimer;
    private boolean repeatTask;
    private Runnable task;
    private long taskIntervalSeconds;
    private Timer timer;

    public Scheduler()
    {
        logger = Logger.getLogger(this);
        timer = null;
        lastRunDuration = 0L;
        paused = false;
    }

    public long getLastRunDuration()
    {
        return lastRunDuration;
    }

    public void pause()
    {
        if (paused || task == null || recordTimer == null)
        {
            return;
        }
        paused = true;
        recordTimer.pause();
        if (timer != null)
        {
            timer.cancel();
        }
        timer = null;
        lastRunDuration = recordTimer.tick();
    }

    public void resume()
    {
        if (paused)
        {
            long l = (taskIntervalSeconds - lastRunDuration) * 1000L;
            recordTimer.resume();
            if (timer != null)
            {
                timer.cancel();
            }
            timer = new Timer();
            if (repeatTask)
            {
                timer.scheduleAtFixedRate(new TimerTask() {

                    final Scheduler this$0;

                    public void run()
                    {
                        if (recordTimer != null)
                        {
                            lastRunDuration = recordTimer.tick();
                            task.run();
                        }
                    }

            
            {
                this$0 = Scheduler.this;
                super();
            }
                }, l, taskIntervalSeconds * 1000L);
            } else
            {
                timer.schedule(new TimerTask() {

                    final Scheduler this$0;

                    public void run()
                    {
                        if (recordTimer != null)
                        {
                            lastRunDuration = recordTimer.tick();
                            task.run();
                        }
                    }

            
            {
                this$0 = Scheduler.this;
                super();
            }
                }, l);
            }
            paused = false;
        }
    }

    public void setTask(Runnable runnable)
    {
        task = runnable;
    }

    public void start(double d, boolean flag)
    {
        if (task == null)
        {
            logger.error("task set is null");
            return;
        }
        if (paused)
        {
            resume();
            return;
        }
        long l = (long)(1000D * d);
        recordTimer = new RecordTimer();
        taskIntervalSeconds = (long)d;
        if (timer != null)
        {
            timer.cancel();
        }
        timer = new Timer();
        if (flag)
        {
            repeatTask = true;
            timer.scheduleAtFixedRate(new TimerTask() {

                final Scheduler this$0;

                public void run()
                {
                    if (recordTimer != null)
                    {
                        lastRunDuration = recordTimer.tick();
                        task.run();
                    }
                }

            
            {
                this$0 = Scheduler.this;
                super();
            }
            }, l, l);
            return;
        } else
        {
            repeatTask = false;
            timer.schedule(new TimerTask() {

                final Scheduler this$0;

                public void run()
                {
                    if (recordTimer != null)
                    {
                        lastRunDuration = recordTimer.tick();
                        task.run();
                    }
                }

            
            {
                this$0 = Scheduler.this;
                super();
            }
            }, l);
            return;
        }
    }

    public void stop()
    {
        if (timer != null)
        {
            timer.cancel();
        }
        timer = null;
        recordTimer = null;
        lastRunDuration = 0L;
        paused = false;
        task = null;
        taskIntervalSeconds = 0L;
    }



/*
    static long access$102(Scheduler scheduler, long l)
    {
        scheduler.lastRunDuration = l;
        return l;
    }

*/

}
