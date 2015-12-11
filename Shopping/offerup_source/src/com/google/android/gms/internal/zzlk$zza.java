// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class <init>
    implements ThreadFactory
{

    private final ThreadFactory zzacE;
    private AtomicInteger zzacF;

    public final Thread newThread(Runnable runnable)
    {
        runnable = zzacE.newThread(runnable);
        runnable.setName((new StringBuilder("GAC_Executor[")).append(zzacF.getAndIncrement()).append("]").toString());
        return runnable;
    }

    private ()
    {
        zzacE = Executors.defaultThreadFactory();
        zzacF = new AtomicInteger(0);
    }

    ( )
    {
        this();
    }
}
