// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.fitness.result.DataReadResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzno

private static class  extends 
{

    private final com.google.android.gms.common.api.eadResult zzQz;
    private int zzapd;
    private DataReadResult zzape;

    public void zza(DataReadResult datareadresult)
    {
        this;
        JVM INSTR monitorenter ;
        Log.v("Fitness", "Received batch result");
        if (zzape != null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        zzape = datareadresult;
_L2:
        zzapd = zzapd + 1;
        if (zzapd == zzape.zzsB())
        {
            zzQz.zn(zzape);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        zzape.zzb(datareadresult);
        if (true) goto _L2; else goto _L1
_L1:
        datareadresult;
        this;
        JVM INSTR monitorexit ;
        throw datareadresult;
    }

    private (com.google.android.gms.common.api. )
    {
        zzapd = 0;
        zzape = null;
        zzQz = ;
    }

    (com.google.android.gms.common.api.Qz qz,  )
    {
        this(qz);
    }
}
