// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzlk
{

    private static final ExecutorService zzacD = Executors.newFixedThreadPool(2, new zza(null));

    public static ExecutorService zzoj()
    {
        return zzacD;
    }


    private class zza
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

        private zza()
        {
            zzacE = Executors.defaultThreadFactory();
            zzacF = new AtomicInteger(0);
        }

        zza(_cls1 _pcls1)
        {
            this();
        }
    }

}
