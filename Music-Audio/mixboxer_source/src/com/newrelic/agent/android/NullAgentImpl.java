// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import com.newrelic.agent.android.api.common.ErrorData;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.util.Encoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.newrelic.agent.android:
//            AgentImpl

public class NullAgentImpl
    implements AgentImpl
{

    public static final NullAgentImpl instance = new NullAgentImpl();
    private final Condition harvestCond;
    private boolean harvestHappened;
    private final ReentrantLock lock = new ReentrantLock();

    public NullAgentImpl()
    {
        harvestHappened = false;
        harvestCond = lock.newCondition();
    }

    public void addErrorData(ErrorData errordata)
    {
    }

    public void addTransactionData(TransactionData transactiondata)
    {
    }

    public void disable()
    {
    }

    public List getAndClearErrorData()
    {
        return new ArrayList();
    }

    public List getAndClearTransactionData()
    {
        return new ArrayList();
    }

    public String getCrossProcessId()
    {
        return null;
    }

    public Encoder getEncoder()
    {
        return new Encoder() {

            final NullAgentImpl this$0;

            public String encode(byte abyte0[])
            {
                return new String(abyte0);
            }

            
            {
                this$0 = NullAgentImpl.this;
                super();
            }
        };
    }

    public String getNetworkCarrier()
    {
        return "unknown";
    }

    public int getResponseBodyLimit()
    {
        return 0;
    }

    public int getStackTraceLimit()
    {
        return 0;
    }

    public boolean isDisabled()
    {
        return true;
    }

    public void mergeErrorData(List list)
    {
    }

    public void mergeTransactionData(List list)
    {
    }

    public void setLocation(String s, String s1)
    {
    }

    public void start()
    {
    }

    public void stop()
    {
    }

    public boolean waitForConnect(long l, TimeUnit timeunit)
    {
        return true;
    }

    public boolean waitForHarvest(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        lock.lock();
        harvestHappened = false;
        timeunit = new Date(System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(l, timeunit));
_L1:
        boolean flag;
        if (harvestHappened)
        {
            break MISSING_BLOCK_LABEL_65;
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

}
