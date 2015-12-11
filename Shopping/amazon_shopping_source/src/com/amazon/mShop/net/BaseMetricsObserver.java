// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.os.SystemClock;

// Referenced classes of package com.amazon.mShop.net:
//            MetricsCollector

public abstract class BaseMetricsObserver extends MetricsAggregator.MetricEvent
{
    public static final class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status Canceled;
        public static final Status Completed;
        public static final Status Failed;
        public static final Status Received;
        public static final Status Running;
        public static final Status Unknown;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/amazon/mShop/net/BaseMetricsObserver$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            Unknown = new Status("Unknown", 0);
            Running = new Status("Running", 1);
            Received = new Status("Received", 2);
            Completed = new Status("Completed", 3);
            Canceled = new Status("Canceled", 4);
            Failed = new Status("Failed", 5);
            $VALUES = (new Status[] {
                Unknown, Running, Received, Completed, Canceled, Failed
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }


    private Long mEndTime;
    private Long mNetworkEndTime;
    private String mShortErrorMessage;
    private Long mStartTime;
    private Status mStatus;

    protected BaseMetricsObserver()
    {
        mStatus = Status.Unknown;
    }

    public String getErrorMessage()
    {
        this;
        JVM INSTR monitorenter ;
        String s = mShortErrorMessage;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public Status getStatus()
    {
        this;
        JVM INSTR monitorenter ;
        Status status = mStatus;
        this;
        JVM INSTR monitorexit ;
        return status;
        Exception exception;
        exception;
        throw exception;
    }

    public int getTotalTime()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        l = mEndTime.longValue();
        l1 = mStartTime.longValue();
        int i = (int)(l - l1);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isFinished()
    {
        this;
        JVM INSTR monitorenter ;
        if (mStatus == Status.Canceled || mStatus == Status.Completed) goto _L2; else goto _L1
_L1:
        Status status;
        Status status1;
        status = mStatus;
        status1 = Status.Failed;
        if (status != status1) goto _L3; else goto _L2
_L2:
        boolean flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isStatusFailed()
    {
        this;
        JVM INSTR monitorenter ;
        Status status;
        Status status1;
        status = mStatus;
        status1 = Status.Failed;
        boolean flag;
        if (status == status1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void onCancelled()
    {
        this;
        JVM INSTR monitorenter ;
        onFinished(Status.Canceled);
        MetricsCollector.queueEvent(this);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onComplete()
    {
        this;
        JVM INSTR monitorenter ;
        onFinished(Status.Completed);
        MetricsCollector.queueEvent(this);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onFailed(String s)
    {
        this;
        JVM INSTR monitorenter ;
        mShortErrorMessage = s;
        onFinished(Status.Failed);
        MetricsCollector.queueEvent(this);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    protected void onFinished(Status status)
    {
        mEndTime = Long.valueOf(SystemClock.elapsedRealtime());
        if (mNetworkEndTime == null)
        {
            mNetworkEndTime = mEndTime;
        }
        mStatus = status;
    }

    public void onResponseReceived()
    {
        this;
        JVM INSTR monitorenter ;
        mNetworkEndTime = Long.valueOf(SystemClock.elapsedRealtime());
        mStatus = Status.Received;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onStart()
    {
        this;
        JVM INSTR monitorenter ;
        mStartTime = Long.valueOf(SystemClock.elapsedRealtime());
        mStatus = Status.Running;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
