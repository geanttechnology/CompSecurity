// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import com.newrelic.agent.android.api.common.ErrorData;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.util.Encoder;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.newrelic.agent.android:
//            NullAgentImpl, AgentImpl

public final class Agent
{

    private static final AgentImpl NULL_AGENT_IMPL;
    private static final String VERSION = "2.426.0";
    private static AgentImpl impl;
    private static Object implLock = new Object();

    public Agent()
    {
    }

    public static void addErrorData(ErrorData errordata)
    {
        getImpl().addErrorData(errordata);
    }

    public static void addTransactionData(TransactionData transactiondata)
    {
        getImpl().addTransactionData(transactiondata);
    }

    public static void disable()
    {
        getImpl().disable();
    }

    public static String getActiveNetworkCarrier()
    {
        return getImpl().getNetworkCarrier();
    }

    public static List getAndClearErrorData()
    {
        return getImpl().getAndClearErrorData();
    }

    public static List getAndClearTransactionData()
    {
        return getImpl().getAndClearTransactionData();
    }

    public static String getCrossProcessId()
    {
        return getImpl().getCrossProcessId();
    }

    public static Encoder getEncoder()
    {
        return getImpl().getEncoder();
    }

    private static AgentImpl getImpl()
    {
        AgentImpl agentimpl;
        synchronized (implLock)
        {
            agentimpl = impl;
        }
        return agentimpl;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static int getResponseBodyLimit()
    {
        return getImpl().getResponseBodyLimit();
    }

    public static int getStackTraceLimit()
    {
        return getImpl().getStackTraceLimit();
    }

    public static String getVersion()
    {
        return "2.426.0";
    }

    public static boolean isDisabled()
    {
        return getImpl().isDisabled();
    }

    public static void mergeErrorData(List list)
    {
        getImpl().mergeErrorData(list);
    }

    public static void mergeTransactionData(List list)
    {
        getImpl().mergeTransactionData(list);
    }

    public static void setImpl(AgentImpl agentimpl)
    {
        Object obj = implLock;
        obj;
        JVM INSTR monitorenter ;
        if (agentimpl != null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        impl = NULL_AGENT_IMPL;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        impl = agentimpl;
        if (true) goto _L2; else goto _L1
_L1:
        agentimpl;
        obj;
        JVM INSTR monitorexit ;
        throw agentimpl;
    }

    public static void setLocation(String s, String s1)
    {
        getImpl().setLocation(s, s1);
    }

    public static void start()
    {
        getImpl().start();
    }

    public static void stop()
    {
        getImpl().stop();
    }

    public static boolean waitForConnect(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        return getImpl().waitForConnect(l, timeunit);
    }

    public static boolean waitForHarvest(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        return getImpl().waitForHarvest(l, timeunit);
    }

    static 
    {
        NULL_AGENT_IMPL = new NullAgentImpl();
        impl = NULL_AGENT_IMPL;
    }
}
