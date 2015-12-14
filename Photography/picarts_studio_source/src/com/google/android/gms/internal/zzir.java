// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzic

class zzir
{

    private final Object zzJI = new Object();
    private final List zzJJ = new ArrayList();
    private final List zzJK = new ArrayList();
    private boolean zzJL;

    public zzir()
    {
        zzJL = false;
    }

    private void zze(Runnable runnable)
    {
        com.google.android.gms.internal.zzic.zza(runnable);
    }

    private void zzf(Runnable runnable)
    {
        zza.zzJt.post(runnable);
    }

    public void zzc(Runnable runnable)
    {
        Object obj = zzJI;
        obj;
        JVM INSTR monitorenter ;
        if (!zzJL)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        zze(runnable);
_L2:
        return;
        zzJJ.add(runnable);
        if (true) goto _L2; else goto _L1
_L1:
        runnable;
        obj;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public void zzd(Runnable runnable)
    {
        Object obj = zzJI;
        obj;
        JVM INSTR monitorenter ;
        if (!zzJL)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        zzf(runnable);
_L2:
        return;
        zzJK.add(runnable);
        if (true) goto _L2; else goto _L1
_L1:
        runnable;
        obj;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public void zzgV()
    {
label0:
        {
            synchronized (zzJI)
            {
                if (!zzJL)
                {
                    break label0;
                }
            }
            return;
        }
        for (Iterator iterator = zzJJ.iterator(); iterator.hasNext(); zze((Runnable)iterator.next())) { }
        break MISSING_BLOCK_LABEL_57;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        for (Iterator iterator1 = zzJK.iterator(); iterator1.hasNext(); zzf((Runnable)iterator1.next())) { }
        zzJJ.clear();
        zzJK.clear();
        zzJL = true;
        obj;
        JVM INSTR monitorexit ;
    }
}
