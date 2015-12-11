// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.internal:
//            zzlq

public abstract class zzlc extends PendingResult
{

    private boolean zzL;
    private volatile Result zzaaX;
    private final Object zzabh;
    protected final zza zzabi;
    private final ArrayList zzabj;
    private ResultCallback zzabk;
    private volatile boolean zzabl;
    private boolean zzabm;
    private zzq zzabn;
    private Integer zzabo;
    private volatile zzlq zzabp;
    private final CountDownLatch zzoS;

    protected zzlc(Looper looper)
    {
        zzabh = new Object();
        zzoS = new CountDownLatch(1);
        zzabj = new ArrayList();
    /* block-local class not found */
    class zza {}

        zzabi = new zza(looper);
    }

    protected zzlc(GoogleApiClient googleapiclient)
    {
        zzabh = new Object();
        zzoS = new CountDownLatch(1);
        zzabj = new ArrayList();
        if (googleapiclient != null)
        {
            googleapiclient = googleapiclient.getLooper();
        } else
        {
            googleapiclient = Looper.getMainLooper();
        }
        zzabi = new zza(googleapiclient);
    }

    private Result get()
    {
        boolean flag = true;
        Object obj = zzabh;
        obj;
        JVM INSTR monitorenter ;
        Result result;
        if (zzabl)
        {
            flag = false;
        }
        zzx.zza(flag, "Result has already been consumed.");
        zzx.zza(isReady(), "Result is not ready.");
        result = zzaaX;
        zzaaX = null;
        zzabk = null;
        zzabl = true;
        zznL();
        return result;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void zzc(Result result)
    {
        zzaaX = result;
        zzabn = null;
        zzoS.countDown();
        result = zzaaX.getStatus();
        if (zzabk != null)
        {
            zzabi.zznM();
            if (!zzL)
            {
                zzabi.zza(zzabk, get());
            }
        }
        for (Iterator iterator = zzabj.iterator(); iterator.hasNext(); ((com.google.android.gms.common.api.PendingResult.zza)iterator.next()).zzt(result)) { }
        zzabj.clear();
    }

    public static void zzd(Result result)
    {
        if (!(result instanceof Releasable))
        {
            break MISSING_BLOCK_LABEL_16;
        }
        ((Releasable)result).release();
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("BasePendingResult", (new StringBuilder()).append("Unable to release ").append(result).toString(), runtimeexception);
        return;
    }

    public final Result await()
    {
        boolean flag1 = true;
        boolean flag;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "await must not be called on the UI thread");
        if (!zzabl)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Result has already been consumed");
        if (zzabp == null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Cannot await if then() has been called.");
        try
        {
            zzoS.await();
        }
        catch (InterruptedException interruptedexception)
        {
            zzw(Status.zzabc);
        }
        zzx.zza(isReady(), "Result is not ready.");
        return get();
    }

    public final Result await(long l, TimeUnit timeunit)
    {
        boolean flag1 = true;
        boolean flag;
        if (l <= 0L || Looper.myLooper() != Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "await must not be called on the UI thread when time is greater than zero.");
        if (!zzabl)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Result has already been consumed.");
        if (zzabp == null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Cannot await if then() has been called.");
        try
        {
            if (!zzoS.await(l, timeunit))
            {
                zzw(Status.zzabe);
            }
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit)
        {
            zzw(Status.zzabc);
        }
        zzx.zza(isReady(), "Result is not ready.");
        return get();
    }

    public void cancel()
    {
label0:
        {
            synchronized (zzabh)
            {
                if (!zzL && !zzabl)
                {
                    break label0;
                }
            }
            return;
        }
        zzq zzq1 = zzabn;
        if (zzq1 == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        try
        {
            zzabn.cancel();
        }
        catch (RemoteException remoteexception) { }
        zzd(zzaaX);
        zzabk = null;
        zzL = true;
        zzc(zzb(Status.zzabf));
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isCanceled()
    {
        boolean flag;
        synchronized (zzabh)
        {
            flag = zzL;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean isReady()
    {
        return zzoS.getCount() == 0L;
    }

    public final void setResultCallback(ResultCallback resultcallback)
    {
        boolean flag;
        boolean flag1 = true;
        Object obj;
        if (!zzabl)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Result has already been consumed.");
        obj = zzabh;
        obj;
        JVM INSTR monitorenter ;
        if (zzabp == null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Cannot set callbacks if then() has been called.");
        if (!isCanceled())
        {
            break MISSING_BLOCK_LABEL_51;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        if (!isReady())
        {
            break MISSING_BLOCK_LABEL_78;
        }
        zzabi.zza(resultcallback, get());
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        resultcallback;
        obj;
        JVM INSTR monitorexit ;
        throw resultcallback;
        zzabk = resultcallback;
          goto _L1
    }

    public final void setResultCallback(ResultCallback resultcallback, long l, TimeUnit timeunit)
    {
        boolean flag;
        boolean flag1 = true;
        Object obj;
        if (!zzabl)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Result has already been consumed.");
        obj = zzabh;
        obj;
        JVM INSTR monitorenter ;
        if (zzabp == null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Cannot set callbacks if then() has been called.");
        if (!isCanceled())
        {
            break MISSING_BLOCK_LABEL_58;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        if (!isReady())
        {
            break MISSING_BLOCK_LABEL_87;
        }
        zzabi.zza(resultcallback, get());
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        resultcallback;
        obj;
        JVM INSTR monitorexit ;
        throw resultcallback;
        zzabk = resultcallback;
        zzabi.zza(this, timeunit.toMillis(l));
          goto _L1
    }

    public final void zza(com.google.android.gms.common.api.PendingResult.zza zza1)
    {
        boolean flag1 = true;
        Object obj;
        boolean flag;
        if (!zzabl)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Result has already been consumed.");
        if (zza1 != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Callback cannot be null.");
        obj = zzabh;
        obj;
        JVM INSTR monitorenter ;
        if (!isReady())
        {
            break MISSING_BLOCK_LABEL_64;
        }
        zza1.zzt(zzaaX.getStatus());
_L2:
        return;
        zzabj.add(zza1);
        if (true) goto _L2; else goto _L1
_L1:
        zza1;
        obj;
        JVM INSTR monitorexit ;
        throw zza1;
    }

    protected final void zza(zzq zzq1)
    {
        synchronized (zzabh)
        {
            zzabn = zzq1;
        }
        return;
        zzq1;
        obj;
        JVM INSTR monitorexit ;
        throw zzq1;
    }

    protected abstract Result zzb(Status status);

    public final void zzb(Result result)
    {
        boolean flag1;
label0:
        {
            flag1 = true;
            synchronized (zzabh)
            {
                if (!zzabm && !zzL)
                {
                    break label0;
                }
                zzd(result);
            }
            return;
        }
        boolean flag;
        if (!isReady())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Results have already been set");
        if (!zzabl)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Result has already been consumed");
        zzc(result);
        obj;
        JVM INSTR monitorexit ;
        return;
        result;
        obj;
        JVM INSTR monitorexit ;
        throw result;
    }

    public Integer zznF()
    {
        return zzabo;
    }

    protected void zznL()
    {
    }

    public final void zzw(Status status)
    {
        synchronized (zzabh)
        {
            if (!isReady())
            {
                zzb(zzb(status));
                zzabm = true;
            }
        }
        return;
        status;
        obj;
        JVM INSTR monitorexit ;
        throw status;
    }
}
