// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzmn;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzcd, zzbg

class zzbe
    implements zzcd
{

    private final long zzPk;
    private final int zzPl;
    private double zzPm;
    private long zzPn;
    private final Object zzPo = new Object();
    private final String zzPp;
    private final long zzaXx;
    private final zzmn zzpW;

    public zzbe(int i, long l, long l1, String s, zzmn zzmn1)
    {
        zzPl = i;
        zzPm = zzPl;
        zzPk = l;
        zzaXx = l1;
        zzPp = s;
        zzpW = zzmn1;
    }

    public boolean zzkF()
    {
        long l;
label0:
        {
            synchronized (zzPo)
            {
                l = zzpW.currentTimeMillis();
                if (l - zzPn >= zzaXx)
                {
                    break label0;
                }
                zzbg.zzaH((new StringBuilder("Excessive ")).append(zzPp).append(" detected; call ignored.").toString());
            }
            return false;
        }
        double d;
        if (zzPm >= (double)zzPl)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        d = (double)(l - zzPn) / (double)zzPk;
        if (d <= 0.0D)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        zzPm = Math.min(zzPl, d + zzPm);
        zzPn = l;
        if (zzPm < 1.0D)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        zzPm = zzPm - 1.0D;
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        zzbg.zzaH((new StringBuilder("Excessive ")).append(zzPp).append(" detected; call ignored.").toString());
        obj;
        JVM INSTR monitorexit ;
        return false;
    }
}
