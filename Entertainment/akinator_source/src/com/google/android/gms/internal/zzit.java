// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.google.android.gms.internal:
//            zzis

public class zzit
    implements zzis
{

    protected final BlockingQueue zzJM = new LinkedBlockingQueue();
    protected Object zzJN;
    private final Object zzpd = new Object();
    protected int zzys;

    public zzit()
    {
        zzys = 0;
    }

    public int getStatus()
    {
        return zzys;
    }

    public void reject()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzys != 0)
        {
            throw new UnsupportedOperationException();
        }
        break MISSING_BLOCK_LABEL_27;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        zzys = -1;
    /* block-local class not found */
    class zza {}

        for (Iterator iterator = zzJM.iterator(); iterator.hasNext(); ((zza)iterator.next()).zzJP.run()) { }
        zzJM.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    public void zza(zzis.zzc zzc, zzis.zza zza1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzys != 1) goto _L2; else goto _L1
_L1:
        zzc.zzc(zzJN);
_L5:
        return;
_L2:
        if (zzys != -1) goto _L4; else goto _L3
_L3:
        zza1.run();
          goto _L5
        zzc;
        obj;
        JVM INSTR monitorexit ;
        throw zzc;
_L4:
        if (zzys != 0) goto _L5; else goto _L6
_L6:
        zzJM.add(new zza(zzc, zza1));
          goto _L5
    }

    public void zzg(Object obj)
    {
        Object obj1 = zzpd;
        obj1;
        JVM INSTR monitorenter ;
        if (zzys != 0)
        {
            throw new UnsupportedOperationException();
        }
        break MISSING_BLOCK_LABEL_27;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        zzJN = obj;
        zzys = 1;
        for (Iterator iterator = zzJM.iterator(); iterator.hasNext(); ((zza)iterator.next()).zzJO.zzc(obj)) { }
        zzJM.clear();
        obj1;
        JVM INSTR monitorexit ;
    }
}
