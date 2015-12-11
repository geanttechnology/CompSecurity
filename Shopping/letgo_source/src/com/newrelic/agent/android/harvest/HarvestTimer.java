// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.newrelic.agent.android.harvest:
//            AgentHealth, Harvester

public class HarvestTimer
    implements Runnable
{

    private static final long DEFAULT_HARVEST_PERIOD = 60000L;
    private static final long HARVEST_PERIOD_LEEWAY = 1000L;
    private static final long NEVER_TICKED = -1L;
    protected final Harvester harvester;
    protected long lastTickTime;
    private Lock lock;
    private final AgentLog log = AgentLogManager.getAgentLog();
    private long period;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("Harvester"));
    private long startTimeMs;
    private ScheduledFuture tickFuture;

    public HarvestTimer(Harvester harvester1)
    {
        tickFuture = null;
        period = 60000L;
        lock = new ReentrantLock();
        harvester = harvester1;
    }

    private long now()
    {
        return System.currentTimeMillis();
    }

    private void tickIfReady()
    {
        long l = timeSinceLastTick();
        if (1000L + l < period && l != -1L)
        {
            log.debug((new StringBuilder()).append("HarvestTimer: Tick is too soon (").append(l).append(" delta) Last tick time: ").append(lastTickTime).append(" . Skipping.").toString());
            return;
        }
        log.debug((new StringBuilder()).append("HarvestTimer: time since last tick: ").append(l).toString());
        l = now();
        try
        {
            tick();
        }
        catch (Exception exception)
        {
            log.error((new StringBuilder()).append("HarvestTimer: Exception in timer tick: ").append(exception.getMessage()).toString());
            exception.printStackTrace();
            AgentHealth.noticeException(exception);
        }
        lastTickTime = l;
        log.debug((new StringBuilder()).append("Set last tick time to: ").append(lastTickTime).toString());
    }

    protected void cancelPendingTasks()
    {
        lock.lock();
        if (tickFuture != null)
        {
            tickFuture.cancel(true);
            tickFuture = null;
        }
        lock.unlock();
        return;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public boolean isRunning()
    {
        return tickFuture != null;
    }

    public void run()
    {
        lock.lock();
        tickIfReady();
        lock.unlock();
        return;
        Object obj;
        obj;
        log.error((new StringBuilder()).append("HarvestTimer: Exception in timer tick: ").append(((Exception) (obj)).getMessage()).toString());
        ((Exception) (obj)).printStackTrace();
        AgentHealth.noticeException(((Exception) (obj)));
        lock.unlock();
        return;
        obj;
        lock.unlock();
        throw obj;
    }

    public void setPeriod(long l)
    {
        period = l;
    }

    public void shutdown()
    {
        cancelPendingTasks();
        scheduler.shutdownNow();
    }

    public void start()
    {
        if (isRunning())
        {
            log.warning("HarvestTimer: Attempting to start while already running");
            return;
        }
        if (period <= 0L)
        {
            log.error("HarvestTimer: Refusing to start with a period of 0 ms");
            return;
        } else
        {
            log.debug((new StringBuilder()).append("HarvestTimer: Starting with a period of ").append(period).append("ms").toString());
            startTimeMs = System.currentTimeMillis();
            tickFuture = scheduler.scheduleAtFixedRate(this, 0L, period, TimeUnit.MILLISECONDS);
            harvester.start();
            return;
        }
    }

    public void stop()
    {
        if (!isRunning())
        {
            log.warning("HarvestTimer: Attempting to stop when not running");
            return;
        } else
        {
            cancelPendingTasks();
            log.debug("HarvestTimer: Stopped.");
            startTimeMs = 0L;
            harvester.stop();
            return;
        }
    }

    protected void tick()
    {
        log.debug("Harvest: tick");
        TicToc tictoc = new TicToc();
        tictoc.tic();
        long l;
        try
        {
            harvester.execute();
        }
        catch (Exception exception)
        {
            log.error((new StringBuilder()).append("HarvestTimer: Exception in harvest execute: ").append(exception.getMessage()).toString());
            exception.printStackTrace();
            AgentHealth.noticeException(exception);
        }
        log.debug("Harvest: executed");
        if (harvester.isDisabled())
        {
            stop();
        }
        l = tictoc.toc();
        log.debug((new StringBuilder()).append("HarvestTimer tick took ").append(l).append("ms").toString());
    }

    public void tickNow()
    {
        ScheduledFuture scheduledfuture = scheduler.schedule(new Runnable() {

            final HarvestTimer this$0;
            final HarvestTimer val$timer;

            public void run()
            {
                timer.tick();
            }

            
            {
                this$0 = HarvestTimer.this;
                timer = harvesttimer1;
                super();
            }
        }, 0L, TimeUnit.SECONDS);
        try
        {
            scheduledfuture.get();
            return;
        }
        catch (Exception exception)
        {
            log.error((new StringBuilder()).append("Exception waiting for tickNow to finish: ").append(exception.getMessage()).toString());
            exception.printStackTrace();
            AgentHealth.noticeException(exception);
            return;
        }
    }

    public long timeSinceLastTick()
    {
        if (lastTickTime == 0L)
        {
            return -1L;
        } else
        {
            return now() - lastTickTime;
        }
    }

    public long timeSinceStart()
    {
        if (startTimeMs == 0L)
        {
            return 0L;
        } else
        {
            return now() - startTimeMs;
        }
    }
}
