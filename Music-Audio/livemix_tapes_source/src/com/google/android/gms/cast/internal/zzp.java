// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zzl, zzo

public final class zzp
{

    private static final zzl zzTy = new zzl("RequestTracker");
    public static final Object zzXT = new Object();
    private long zzWo;
    private long zzXQ;
    private long zzXR;
    private zzo zzXS;

    public zzp(long l)
    {
        zzXQ = l;
        zzWo = -1L;
        zzXR = 0L;
    }

    private void zzmN()
    {
        zzWo = -1L;
        zzXS = null;
        zzXR = 0L;
    }

    public void clear()
    {
        synchronized (zzXT)
        {
            if (zzWo != -1L)
            {
                zzmN();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean zzB(long l)
    {
        Object obj = zzXT;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzWo != -1L && zzWo == l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zza(long l, zzo zzo1)
    {
        zzo zzo2;
        long l1;
        synchronized (zzXT)
        {
            zzo2 = zzXS;
            l1 = zzWo;
            zzWo = l;
            zzXS = zzo1;
            zzXR = SystemClock.elapsedRealtime();
        }
        if (zzo2 != null)
        {
            zzo2.zzy(l1);
        }
        return;
        zzo1;
        obj;
        JVM INSTR monitorexit ;
        throw zzo1;
    }

    public boolean zzc(long l, int i)
    {
        return zzc(l, i, null);
    }

    public boolean zzc(long l, int i, Object obj)
    {
        zzo zzo1;
        boolean flag;
        flag = true;
        zzo1 = null;
        Object obj1 = zzXT;
        obj1;
        JVM INSTR monitorenter ;
        if (zzWo == -1L || zzWo != l)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        zzTy.zzb("request %d completed", new Object[] {
            Long.valueOf(zzWo)
        });
        zzo1 = zzXS;
        zzmN();
_L2:
        if (zzo1 != null)
        {
            zzo1.zza(l, i, obj);
        }
        return flag;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean zzd(long l, int i)
    {
        long l1;
        boolean flag;
        flag = true;
        l1 = 0L;
        Object obj1 = zzXT;
        obj1;
        JVM INSTR monitorenter ;
        Object obj;
        if (zzWo == -1L || l - zzXR < zzXQ)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        zzTy.zzb("request %d timed out", new Object[] {
            Long.valueOf(zzWo)
        });
        l = zzWo;
        obj = zzXS;
        zzmN();
_L2:
        if (obj != null)
        {
            ((zzo) (obj)).zza(l, i, null);
        }
        return flag;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        flag = false;
        obj = null;
        l = l1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean zzmO()
    {
        Object obj = zzXT;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzWo != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
