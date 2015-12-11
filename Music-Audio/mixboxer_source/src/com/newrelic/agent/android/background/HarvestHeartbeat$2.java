// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.background;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.api.v1.NewRelicApi;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.ConnectivitySampler;
import com.newrelic.agent.android.util.MachineMeasurementsSampler;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.newrelic.agent.android.background:
//            HarvestHeartbeat

class val.lastHarvestTime extends Thread
{

    final HarvestHeartbeat this$0;
    final long val$lastHarvestTime;
    final long val$sessionStartTime;
    final long val$thisTime;

    public void run()
    {
        HarvestHeartbeat.access$000(HarvestHeartbeat.this).lock();
_L1:
        boolean flag = HarvestHeartbeat.access$100(HarvestHeartbeat.this);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        HarvestHeartbeat.access$200(HarvestHeartbeat.this).await();
          goto _L1
        InterruptedException interruptedexception;
        interruptedexception;
        HarvestHeartbeat.access$300().error("Interrupted waiting for harvest to finish", interruptedexception);
        HarvestHeartbeat.access$000(HarvestHeartbeat.this).unlock();
        synchronized (HarvestHeartbeat.access$700(HarvestHeartbeat.this))
        {
            HarvestHeartbeat.access$802(HarvestHeartbeat.this, null);
        }
        HarvestHeartbeat.access$300().info("Background thread has completed");
        HarvestHeartbeat.access$900(HarvestHeartbeat.this);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        HarvestHeartbeat.access$000(HarvestHeartbeat.this).unlock();
        java.util.List list = Agent.getAndClearTransactionData();
        java.util.List list1 = Agent.getAndClearErrorData();
        double d = (double)(System.nanoTime() - val$sessionStartTime) / 1000000000D;
        if (HarvestHeartbeat.access$400(HarvestHeartbeat.this).sample())
        {
            HarvestHeartbeat.access$600(HarvestHeartbeat.this).sendData((double)(val$thisTime - val$lastHarvestTime) / 1000D, list, list1, HarvestHeartbeat.access$500(HarvestHeartbeat.this).sample(), d);
            StatsEngine.reset();
        }
        synchronized (HarvestHeartbeat.access$700(HarvestHeartbeat.this))
        {
            HarvestHeartbeat.access$802(HarvestHeartbeat.this, null);
        }
        HarvestHeartbeat.access$300().info("Background thread has completed");
        HarvestHeartbeat.access$900(HarvestHeartbeat.this);
        return;
        obj1;
        Object obj2;
        Exception exception3;
        try
        {
            HarvestHeartbeat.access$000(HarvestHeartbeat.this).unlock();
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        finally
        {
            obj2 = HarvestHeartbeat.access$700(HarvestHeartbeat.this);
        }
        HarvestHeartbeat.access$300().error("Failed to send final post", ((Throwable) (obj1)));
        synchronized (HarvestHeartbeat.access$700(HarvestHeartbeat.this))
        {
            HarvestHeartbeat.access$802(HarvestHeartbeat.this, null);
        }
        HarvestHeartbeat.access$300().info("Background thread has completed");
        HarvestHeartbeat.access$900(HarvestHeartbeat.this);
        return;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        exception2;
        obj1;
        JVM INSTR monitorexit ;
        throw exception2;
        JVM INSTR monitorenter ;
        HarvestHeartbeat.access$802(HarvestHeartbeat.this, null);
        obj2;
        JVM INSTR monitorexit ;
        HarvestHeartbeat.access$300().info("Background thread has completed");
        HarvestHeartbeat.access$900(HarvestHeartbeat.this);
        throw exception3;
        exception3;
        obj2;
        JVM INSTR monitorexit ;
        throw exception3;
    }

    r()
    {
        this$0 = final_harvestheartbeat;
        val$sessionStartTime = l;
        val$thisTime = l1;
        val$lastHarvestTime = J.this;
        super();
    }
}
