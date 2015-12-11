// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.util.Encoder;
import java.util.List;

// Referenced classes of package com.newrelic.agent.android:
//            NullAgentImpl, AgentImpl

public class Agent
{

    private static final AgentImpl NULL_AGENT_IMPL;
    public static final String VERSION = "5.2.1";
    private static AgentImpl impl;
    private static Object implLock = new Object();

    public Agent()
    {
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

    public static String getActiveNetworkWanType()
    {
        return getImpl().getNetworkWanType();
    }

    public static List getAndClearTransactionData()
    {
        return getImpl().getAndClearTransactionData();
    }

    public static ApplicationInformation getApplicationInformation()
    {
        return getImpl().getApplicationInformation();
    }

    public static String getCrossProcessId()
    {
        return getImpl().getCrossProcessId();
    }

    public static DeviceInformation getDeviceInformation()
    {
        return getImpl().getDeviceInformation();
    }

    public static Encoder getEncoder()
    {
        return getImpl().getEncoder();
    }

    public static AgentImpl getImpl()
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
        return "5.2.1";
    }

    public static boolean isDisabled()
    {
        return getImpl().isDisabled();
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

    static 
    {
        NULL_AGENT_IMPL = new NullAgentImpl();
        impl = NULL_AGENT_IMPL;
    }
}
