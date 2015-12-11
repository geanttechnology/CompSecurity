// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzmn

public class zzik
{

    private long zzJk;
    private long zzJl;
    private Object zzpd;

    public zzik(long l)
    {
        zzJl = 0x8000000000000000L;
        zzpd = new Object();
        zzJk = l;
    }

    public boolean tryAcquire()
    {
        long l;
label0:
        {
            synchronized (zzpd)
            {
                l = zzp.zzbz().elapsedRealtime();
                if (zzJl + zzJk <= l)
                {
                    break label0;
                }
            }
            return false;
        }
        zzJl = l;
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
