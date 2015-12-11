// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzae

public class zzad
{

    private final long zzPk;
    private final int zzPl;
    private double zzPm;
    private long zzPn;
    private final Object zzPo;
    private final String zzPp;

    public zzad(int i, long l, String s)
    {
        zzPo = new Object();
        zzPl = i;
        zzPm = zzPl;
        zzPk = l;
        zzPp = s;
    }

    public zzad(String s)
    {
        this(60, 2000L, s);
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
        d = (double)(l - zzPn) / (double)zzPk;
        if (d <= 0.0D)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        zzPm = Math.min(zzPl, d + zzPm);
        zzPn = l;
        if (zzPm < 1.0D)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        zzPm = zzPm - 1.0D;
        obj;
        JVM INSTR monitorexit ;
        return true;
        zzae.zzaH((new StringBuilder("Excessive ")).append(zzPp).append(" detected; call ignored.").toString());
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
