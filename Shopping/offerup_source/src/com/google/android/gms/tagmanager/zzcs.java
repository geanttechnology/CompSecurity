// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


// Referenced classes of package com.google.android.gms.tagmanager:
//            zzcd, zzbg

class zzcs
    implements zzcd
{

    private final long zzPk;
    private final int zzPl;
    private double zzPm;
    private final Object zzPo;
    private long zzaYS;

    public zzcs()
    {
        this(60, 2000L);
    }

    public zzcs(int i, long l)
    {
        zzPo = new Object();
        zzPl = i;
        zzPm = zzPl;
        zzPk = l;
    }

    public boolean zzkF()
    {
        Object obj = zzPo;
        obj;
        JVM INSTR monitorenter ;
        double d;
        long l;
        l = System.currentTimeMillis();
        if (zzPm >= (double)zzPl)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        d = (double)(l - zzaYS) / (double)zzPk;
        if (d <= 0.0D)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        zzPm = Math.min(zzPl, d + zzPm);
        zzaYS = l;
        if (zzPm < 1.0D)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        zzPm = zzPm - 1.0D;
        obj;
        JVM INSTR monitorexit ;
        return true;
        zzbg.zzaH("No more tokens available.");
        obj;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
