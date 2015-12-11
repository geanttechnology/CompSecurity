// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.c;

import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.target.ui.fragment.cardstream.c:
//            j

public static class mClock
{

    private final rvice mClock;
    private final ScheduledExecutorService mExecutor;

    public mClock a(Runnable runnable, long l, String s)
    {
        return new <init>(runnable, mExecutor, mClock, l, s);
    }

    public rvice(ScheduledExecutorService scheduledexecutorservice, rvice rvice)
    {
        mExecutor = scheduledexecutorservice;
        mClock = rvice;
    }
}
