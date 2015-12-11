// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.background;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.api.v1.NewRelicApi;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.transport.TransportException;
import com.newrelic.agent.android.util.ConnectivitySampler;
import com.newrelic.agent.android.util.MachineMeasurementsSampler;
import java.io.InterruptedIOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HarvestHeartbeat
    implements Runnable
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final NewRelicApi api1;
    private final ConnectivitySampler connectivitySampler;
    private final TimeUnit deltaTimeUnit;
    private final ScheduledThreadPoolExecutor executor;
    private Thread finalThread;
    private final Object finalThreadLock;
    private ScheduledFuture future;
    private final Condition harvestCond;
    private long harvestCounter;
    private long harvestInterval;
    private TimeUnit harvestIntervalUnit;
    private boolean harvesting;
    private long lastTime;
    private final ReentrantLock lock;
    private final MachineMeasurementsSampler machineMeasurementsSampler;
    private final long minDeltaTime;
    private boolean needConnect;
    private long sessionStartTime;
    private final Condition stopCond;
    private boolean stopRequested;
    private boolean stopped;

    public HarvestHeartbeat(NewRelicApi newrelicapi, MachineMeasurementsSampler machinemeasurementssampler, ConnectivitySampler connectivitysampler, long l)
    {
        this(newrelicapi, machinemeasurementssampler, connectivitysampler, l, TimeUnit.MILLISECONDS, (long)((double)l * 0.83333333333333337D), TimeUnit.MILLISECONDS);
    }

    public HarvestHeartbeat(NewRelicApi newrelicapi, MachineMeasurementsSampler machinemeasurementssampler, ConnectivitySampler connectivitysampler, long l, TimeUnit timeunit, long l1, TimeUnit timeunit1)
    {
        finalThreadLock = new Object();
        stopped = false;
        stopRequested = false;
        harvesting = false;
        lock = new ReentrantLock();
        stopCond = lock.newCondition();
        harvestCond = lock.newCondition();
        harvestCounter = 0L;
        api1 = newrelicapi;
        harvestInterval = l;
        harvestIntervalUnit = timeunit;
        minDeltaTime = l1;
        deltaTimeUnit = timeunit1;
        machineMeasurementsSampler = machinemeasurementssampler;
        connectivitySampler = connectivitysampler;
        executor = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {

            final HarvestHeartbeat this$0;

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, "[New Relic] Heartbeat");
            }

            
            {
                this$0 = HarvestHeartbeat.this;
                super();
            }
        });
    }

    private void afterStop()
    {
        lock.lock();
        if (stopRequested)
        {
            stopRequested = false;
        }
        stopped = true;
        stopCond.signalAll();
        lock.unlock();
        return;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    private void finalSendData(final long sessionStartTime, final long lastHarvestTime)
    {
        final long thisTime = System.currentTimeMillis();
        Object obj = finalThreadLock;
        obj;
        JVM INSTR monitorenter ;
        if (finalThread != null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        log.debug("Sending final data in background.");
        finalThread = new Thread() {

            final HarvestHeartbeat this$0;
            final long val$lastHarvestTime;
            final long val$sessionStartTime;
            final long val$thisTime;

            public void run()
            {
                lock.lock();
_L1:
                boolean flag = harvesting;
                if (!flag)
                {
                    break MISSING_BLOCK_LABEL_107;
                }
                harvestCond.await();
                  goto _L1
                InterruptedException interruptedexception;
                interruptedexception;
                HarvestHeartbeat.log.error("Interrupted waiting for harvest to finish", interruptedexception);
                lock.unlock();
                synchronized (finalThreadLock)
                {
                    finalThread = null;
                }
                HarvestHeartbeat.log.info("Background thread has completed");
                afterStop();
                return;
                exception1;
                obj1;
                JVM INSTR monitorexit ;
                throw exception1;
                lock.unlock();
                java.util.List list = Agent.getAndClearTransactionData();
                java.util.List list1 = Agent.getAndClearErrorData();
                double d = (double)(System.nanoTime() - sessionStartTime) / 1000000000D;
                if (connectivitySampler.sample())
                {
                    api1.sendData((double)(thisTime - lastHarvestTime) / 1000D, list, list1, machineMeasurementsSampler.sample(), d);
                    StatsEngine.reset();
                }
                synchronized (finalThreadLock)
                {
                    finalThread = null;
                }
                HarvestHeartbeat.log.info("Background thread has completed");
                afterStop();
                return;
                obj2;
                Object obj3;
                Exception exception4;
                try
                {
                    lock.unlock();
                    throw obj2;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj2) { }
                finally
                {
                    obj3 = finalThreadLock;
                }
                HarvestHeartbeat.log.error("Failed to send final post", ((Throwable) (obj2)));
                synchronized (finalThreadLock)
                {
                    finalThread = null;
                }
                HarvestHeartbeat.log.info("Background thread has completed");
                afterStop();
                return;
                exception2;
                obj2;
                JVM INSTR monitorexit ;
                throw exception2;
                exception3;
                obj2;
                JVM INSTR monitorexit ;
                throw exception3;
                JVM INSTR monitorenter ;
                finalThread = null;
                obj3;
                JVM INSTR monitorexit ;
                HarvestHeartbeat.log.info("Background thread has completed");
                afterStop();
                throw exception4;
                exception4;
                obj3;
                JVM INSTR monitorexit ;
                throw exception4;
            }

            
            {
                this$0 = HarvestHeartbeat.this;
                sessionStartTime = l;
                thisTime = l1;
                lastHarvestTime = l2;
                super();
            }
        };
        finalThread.start();
_L2:
        return;
        log.debug("Final session data thread already running: will not fire again.");
        Agent.getAndClearTransactionData();
        Agent.getAndClearErrorData();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void harvest(long l)
        throws InterruptedIOException
    {
        lock.lock();
        if (!harvesting)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        log.verbose("A harvest is already in progress. Come back later.");
        lock.unlock();
        return;
        harvesting = true;
        lock.unlock();
        if (l >= TimeUnit.MILLISECONDS.convert(minDeltaTime, deltaTimeUnit))
        {
            break MISSING_BLOCK_LABEL_132;
        }
        log.verbose("Skipping harvest heartbeat - too soon");
        lock.lock();
        harvestCounter = harvestCounter + 1L;
        harvesting = false;
        harvestCond.signalAll();
        lock.unlock();
        return;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
        exception;
        lock.unlock();
        throw exception;
        synchronized (finalThreadLock)
        {
            if (finalThread == null)
            {
                break MISSING_BLOCK_LABEL_207;
            }
            log.warning("Previous heartbeat is still shutting down -- skipping harvest ...");
        }
        lock.lock();
        harvestCounter = harvestCounter + 1L;
        harvesting = false;
        harvestCond.signalAll();
        lock.unlock();
        return;
        obj;
        lock.unlock();
        throw obj;
        obj;
        JVM INSTR monitorexit ;
        TicToc tictoc;
        obj = Agent.getAndClearTransactionData();
        obj1 = Agent.getAndClearErrorData();
        tictoc = new TicToc();
        if (!isOnline()) goto _L2; else goto _L1
_L1:
        lock.lock();
        if (!stopRequested)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        log.warning("Stop requested after the harvest started -- skipping harvest ...");
        lock.unlock();
        lock.lock();
        harvestCounter = harvestCounter + 1L;
        harvesting = false;
        harvestCond.signalAll();
        lock.unlock();
        return;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        lock.lock();
        harvestCounter = harvestCounter + 1L;
        harvesting = false;
        harvestCond.signalAll();
        lock.unlock();
        throw obj;
        obj;
        lock.unlock();
        throw obj;
        lock.unlock();
        tictoc.tic();
        api1.sendData((double)l / 1000D, ((java.util.Collection) (obj)), ((java.util.Collection) (obj1)), machineMeasurementsSampler.sample());
        StatsEngine.get().recordTimeMs("Supportability/MobileAgent/Collector/Harvest", tictoc.toc());
_L4:
        lock.lock();
        harvestCounter = harvestCounter + 1L;
        harvesting = false;
        harvestCond.signalAll();
        lock.unlock();
        return;
        Object obj2;
        obj2;
        lock.unlock();
        throw obj2;
        obj2;
        log.error("Failed to send transaction data", ((Throwable) (obj2)));
        Agent.mergeTransactionData(((java.util.List) (obj)));
        Agent.mergeErrorData(((java.util.List) (obj1)));
        continue; /* Loop/switch isn't completed */
_L2:
        log.debug("Radio seems to be offline. Metric data will not be sent...");
        Agent.mergeTransactionData(((java.util.List) (obj)));
        Agent.mergeErrorData(((java.util.List) (obj1)));
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        lock.unlock();
        throw obj;
        obj;
        lock.unlock();
        throw obj;
    }

    private boolean isOnline()
    {
        return connectivitySampler.sample();
    }

    public void dispose()
    {
        stop(false);
        executor.shutdown();
    }

    public void run()
    {
        long l;
        l = System.currentTimeMillis();
        lock.lock();
        boolean flag = needConnect;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        needConnect = false;
        lock.unlock();
        if (!flag) goto _L2; else goto _L1
_L1:
        log.info("Connecting!");
        api1.sendConnect();
_L3:
        this;
        JVM INSTR monitorenter ;
        lastTime = l;
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        try
        {
            lock.unlock();
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            log.error(((Exception) (obj)).toString());
        }
        return;
        obj;
        log.error((new StringBuilder()).append("Harvested interrupted during I/O operation: ").append(((InterruptedIOException) (obj)).getMessage()).toString(), ((Throwable) (obj)));
          goto _L3
_L2:
        log.info((new StringBuilder()).append("Heartbeat [").append(l - lastTime).append("ms elapsed]").toString());
        harvest(l - lastTime);
          goto _L3
        obj;
        log.error((new StringBuilder()).append("Harvester interrupted during an I/O operation: ").append(((InterruptedIOException) (obj)).getMessage()).toString(), ((Throwable) (obj)));
          goto _L3
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void setInterval(long l, TimeUnit timeunit)
    {
        lock.lock();
        boolean flag = stopRequested;
        if (flag)
        {
            lock.unlock();
            return;
        }
        lock.unlock();
        this;
        JVM INSTR monitorenter ;
        if (timeunit.convert(harvestInterval, harvestIntervalUnit) != l)
        {
            harvestInterval = l;
            harvestIntervalUnit = timeunit;
            log.info((new StringBuilder()).append("Setting heartbeat interval to ").append(l).append(" ").append(timeunit.name().toLowerCase()).toString());
            if (future != null)
            {
                log.debug("Restarting the executor with the new heartbeat interval");
                future.cancel(true);
                future = executor.scheduleAtFixedRate(this, l, l, harvestIntervalUnit);
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        timeunit;
        this;
        JVM INSTR monitorexit ;
        throw timeunit;
        timeunit;
        lock.unlock();
        throw timeunit;
    }

    public void start(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (future != null) goto _L2; else goto _L1
_L1:
        lock.lock();
        stopRequested = false;
        needConnect = flag;
        ScheduledThreadPoolExecutor scheduledthreadpoolexecutor;
        lock.unlock();
        lastTime = System.currentTimeMillis();
        sessionStartTime = System.nanoTime();
        scheduledthreadpoolexecutor = executor;
        long l;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        l = 0L;
_L3:
        future = scheduledthreadpoolexecutor.scheduleAtFixedRate(this, l, harvestInterval, harvestIntervalUnit);
        log.info(MessageFormat.format("Harvest thread started [interval: {0} {1}, minDelta: {2} {3}]", new Object[] {
            Long.valueOf(harvestInterval), harvestIntervalUnit.name().toLowerCase(), Long.valueOf(minDeltaTime), deltaTimeUnit.name().toLowerCase()
        }));
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        l = harvestInterval;
          goto _L3
    }

    public void stop()
    {
        stop(true);
    }

    public void stop(boolean flag)
    {
        lock.lock();
        stopRequested = true;
        stopped = false;
        needConnect = false;
        lock.unlock();
        this;
        JVM INSTR monitorenter ;
        long l;
        if (future == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        l = sessionStartTime;
        sessionStartTime = 0L;
        future.cancel(true);
        future = null;
        log.info("Harvest thread stopped");
        if (!flag) goto _L2; else goto _L1
_L1:
        finalSendData(l, lastTime);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
_L2:
        afterStop();
          goto _L3
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        afterStop();
          goto _L3
    }

    public boolean waitForHarvest(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        lock.lock();
        timeunit = new Date(System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(l, timeunit));
        l = harvestCounter;
_L1:
        boolean flag;
        if (harvestCounter != l)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        flag = harvestCond.awaitUntil(timeunit);
        if (!flag)
        {
            lock.unlock();
            return false;
        }
          goto _L1
        lock.unlock();
        return true;
        timeunit;
        lock.unlock();
        throw timeunit;
    }

    public boolean waitForStop(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        lock.lock();
_L2:
        boolean flag;
        if (stopped)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = stopCond.await(l, timeunit);
        if (!flag)
        {
            lock.unlock();
            return false;
        }
        if (true) goto _L2; else goto _L1
_L1:
        lock.unlock();
        return true;
        timeunit;
        lock.unlock();
        throw timeunit;
    }











/*
    static Thread access$802(HarvestHeartbeat harvestheartbeat, Thread thread)
    {
        harvestheartbeat.finalThread = thread;
        return thread;
    }

*/

}
