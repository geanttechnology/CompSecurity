// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.flurry.sdk:
//            kf, kd

public final class jq extends kf
{

    private static jq a = null;

    protected jq()
    {
        super(com/flurry/sdk/jq.getName(), 0, 5, 5000L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, new kd()));
    }

    public static jq a()
    {
        com/flurry/sdk/jq;
        JVM INSTR monitorenter ;
        jq jq1;
        if (a == null)
        {
            a = new jq();
        }
        jq1 = a;
        com/flurry/sdk/jq;
        JVM INSTR monitorexit ;
        return jq1;
        Exception exception;
        exception;
        throw exception;
    }

    public static void b()
    {
        com/flurry/sdk/jq;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            a.c();
        }
        a = null;
        com/flurry/sdk/jq;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
