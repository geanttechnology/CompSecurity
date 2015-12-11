// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.measurement:
//            zzg

class <init> extends ThreadPoolExecutor
{

    final zzg zzaLi;

    protected RunnableFuture newTaskFor(Runnable runnable, Object obj)
    {
        class _cls1 extends FutureTask
        {

            final zzg.zza zzaLj;

            protected void setException(Throwable throwable)
            {
                Thread.UncaughtExceptionHandler uncaughtexceptionhandler = zzg.zzb(zzaLj.zzaLi);
                if (uncaughtexceptionhandler == null) goto _L2; else goto _L1
_L1:
                uncaughtexceptionhandler.uncaughtException(Thread.currentThread(), throwable);
_L4:
                super.setException(throwable);
                return;
_L2:
                if (Log.isLoggable("GAv4", 6))
                {
                    Log.e("GAv4", (new StringBuilder("MeasurementExecutor: job failed with ")).append(throwable).toString());
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            _cls1(Runnable runnable, Object obj)
            {
                zzaLj = zzg.zza.this;
                super(runnable, obj);
            }
        }

        return new _cls1(runnable, obj);
    }

    public _cls1(zzg zzg)
    {
        zzaLi = zzg;
        super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        setThreadFactory(new <init>(null));
    }
}
