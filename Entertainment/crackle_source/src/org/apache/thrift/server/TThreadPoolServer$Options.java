// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.util.concurrent.TimeUnit;

// Referenced classes of package org.apache.thrift.server:
//            TThreadPoolServer

public static class stopTimeoutUnit
{

    public int maxWorkerThreads;
    public int minWorkerThreads;
    public TimeUnit stopTimeoutUnit;
    public int stopTimeoutVal;

    public ()
    {
        minWorkerThreads = 5;
        maxWorkerThreads = 0x7fffffff;
        stopTimeoutVal = 60;
        stopTimeoutUnit = TimeUnit.SECONDS;
    }
}
