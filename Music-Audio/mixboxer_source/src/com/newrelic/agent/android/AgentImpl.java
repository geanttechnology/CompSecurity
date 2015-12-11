// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import com.newrelic.agent.android.api.common.ErrorData;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.util.Encoder;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface AgentImpl
{

    public abstract void addErrorData(ErrorData errordata);

    public abstract void addTransactionData(TransactionData transactiondata);

    public abstract void disable();

    public abstract List getAndClearErrorData();

    public abstract List getAndClearTransactionData();

    public abstract String getCrossProcessId();

    public abstract Encoder getEncoder();

    public abstract String getNetworkCarrier();

    public abstract int getResponseBodyLimit();

    public abstract int getStackTraceLimit();

    public abstract boolean isDisabled();

    public abstract void mergeErrorData(List list);

    public abstract void mergeTransactionData(List list);

    public abstract void setLocation(String s, String s1);

    public abstract void start();

    public abstract void stop();

    public abstract boolean waitForConnect(long l, TimeUnit timeunit)
        throws InterruptedException;

    public abstract boolean waitForHarvest(long l, TimeUnit timeunit)
        throws InterruptedException;
}
