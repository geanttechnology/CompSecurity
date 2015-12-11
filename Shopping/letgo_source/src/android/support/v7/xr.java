// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.support.v7:
//            abo, xq, xf, xp

public class xr
{

    private final ScheduledExecutorService a;
    private ScheduledFuture b;
    private String c;
    private boolean d;

    public xr()
    {
        this(Executors.newSingleThreadScheduledExecutor());
    }

    public xr(String s)
    {
        this(Executors.newSingleThreadScheduledExecutor());
        c = s;
    }

    xr(ScheduledExecutorService scheduledexecutorservice)
    {
        b = null;
        c = null;
        a = scheduledexecutorservice;
        d = false;
    }

    public void a(Context context, xf xf, long l, xp xp)
    {
        this;
        JVM INSTR monitorenter ;
        abo.d("ResourceLoaderScheduler: Loading new resource.");
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        context = new xq(context, xf, xp, c);
_L1:
        b = a.schedule(context, l, TimeUnit.MILLISECONDS);
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
        context = new xq(context, xf, xp);
          goto _L1
    }
}
