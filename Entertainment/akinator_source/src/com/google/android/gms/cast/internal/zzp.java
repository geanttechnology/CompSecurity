// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zzl, zzo

public final class zzp
{

    private static final zzl zzVo = new zzl("RequestTracker");
    public static final Object zzZJ = new Object();
    private long zzYg;
    private long zzZG;
    private long zzZH;
    private zzo zzZI;

    public zzp(long l)
    {
        zzZG = l;
        zzYg = -1L;
        zzZH = 0L;
    }

    private void zznj()
    {
        zzYg = -1L;
        zzZI = null;
        zzZH = 0L;
    }

    public void clear()
    {
        synchronized (zzZJ)
        {
            if (zzYg != -1L)
            {
                zznj();
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
        Object obj = zzZJ;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzYg != -1L && zzYg == l)
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
        synchronized (zzZJ)
        {
            zzo2 = zzZI;
            l1 = zzYg;
            zzYg = l;
            zzZI = zzo1;
            zzZH = SystemClock.elapsedRealtime();
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
        Object obj1 = zzZJ;
        obj1;
        JVM INSTR monitorenter ;
        if (zzYg == -1L || zzYg != l)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        zzVo.zzb("request %d completed", new Object[] {
            Long.valueOf(zzYg)
        });
        zzo1 = zzZI;
        zznj();
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
        Object obj1 = zzZJ;
        obj1;
        JVM INSTR monitorenter ;
        Object obj;
        if (zzYg == -1L || l - zzZH < zzZG)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        zzVo.zzb("request %d timed out", new Object[] {
            Long.valueOf(zzYg)
        });
        l = zzYg;
        obj = zzZI;
        zznj();
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

    public boolean zznk()
    {
        Object obj = zzZJ;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzYg != -1L)
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
