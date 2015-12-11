// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public final class kp
{

    final ScheduledExecutorService a;
    ScheduledFuture b;
    String c;
    private boolean d;

    public kp()
    {
        this(Executors.newSingleThreadScheduledExecutor());
    }

    public kp(String s)
    {
        this(Executors.newSingleThreadScheduledExecutor());
        c = s;
    }

    private kp(ScheduledExecutorService scheduledexecutorservice)
    {
        b = null;
        c = null;
        a = scheduledexecutorservice;
        d = false;
    }
}
