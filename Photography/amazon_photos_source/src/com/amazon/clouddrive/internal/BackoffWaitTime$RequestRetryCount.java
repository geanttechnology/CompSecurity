// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.clouddrive.internal:
//            BackoffWaitTime

private static class <init>
{

    private final Map mRequestRetryCounts;

    int getRetiresForRequestAndIncrement(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mRequestRetryCounts.containsKey(class1)) goto _L2; else goto _L1
_L1:
        mRequestRetryCounts.put(class1, new AtomicInteger(1));
        int i = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = ((AtomicInteger)mRequestRetryCounts.get(class1)).getAndIncrement();
        if (true) goto _L4; else goto _L3
_L3:
        class1;
        throw class1;
    }

    void removeRequestRetryCount(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        mRequestRetryCounts.remove(class1);
        this;
        JVM INSTR monitorexit ;
        return;
        class1;
        throw class1;
    }

    private ()
    {
        mRequestRetryCounts = new HashMap();
    }

    mRequestRetryCounts(mRequestRetryCounts mrequestretrycounts)
    {
        this();
    }
}
