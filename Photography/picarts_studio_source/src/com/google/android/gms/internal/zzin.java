// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.google.android.gms.internal:
//            zziq, zzir

public class zzin
    implements zziq
{

    private final zzir zzJA = new zzir();
    private Object zzJy;
    private boolean zzJz;
    private final Object zzpd = new Object();
    private boolean zzzD;

    public zzin()
    {
        zzJy = null;
        zzJz = false;
        zzzD = false;
    }

    public boolean cancel(boolean flag)
    {
        if (!flag)
        {
            return false;
        }
        synchronized (zzpd)
        {
            if (!zzJz)
            {
                break MISSING_BLOCK_LABEL_29;
            }
        }
        return false;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        zzzD = true;
        zzJz = true;
        zzpd.notifyAll();
        zzJA.zzgV();
        obj;
        JVM INSTR monitorexit ;
        return true;
    }

    public Object get()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = zzJz;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        Exception exception;
        Object obj1;
        try
        {
            zzpd.wait();
        }
        catch (InterruptedException interruptedexception) { }
        if (zzzD)
        {
            throw new CancellationException("CallbackFuture was cancelled.");
        }
        break MISSING_BLOCK_LABEL_45;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj1 = zzJy;
        obj;
        JVM INSTR monitorexit ;
        return obj1;
    }

    public Object get(long l, TimeUnit timeunit)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = zzJz;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        l = timeunit.toMillis(l);
        if (l == 0L)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        try
        {
            zzpd.wait(l);
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit) { }
        if (!zzJz)
        {
            throw new TimeoutException("CallbackFuture timed out.");
        }
        break MISSING_BLOCK_LABEL_63;
        timeunit;
        obj;
        JVM INSTR monitorexit ;
        throw timeunit;
        if (zzzD)
        {
            throw new CancellationException("CallbackFuture was cancelled.");
        }
        timeunit = ((TimeUnit) (zzJy));
        obj;
        JVM INSTR monitorexit ;
        return timeunit;
    }

    public boolean isCancelled()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzzD;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isDone()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzJz;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzc(Runnable runnable)
    {
        zzJA.zzc(runnable);
    }

    public void zzd(Runnable runnable)
    {
        zzJA.zzd(runnable);
    }

    public void zzf(Object obj)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (!zzzD)
                {
                    break label0;
                }
            }
            return;
        }
        if (zzJz)
        {
            throw new IllegalStateException("Provided CallbackFuture with multiple values.");
        }
        break MISSING_BLOCK_LABEL_39;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        zzJz = true;
        zzJy = obj;
        zzpd.notifyAll();
        zzJA.zzgV();
        obj1;
        JVM INSTR monitorexit ;
    }
}
