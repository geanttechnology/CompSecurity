// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.fitness.result.DataReadResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzop

private static class <init> extends <init>
{

    private final aReadResult zzagy;
    private int zzarA;
    private DataReadResult zzarB;

    public void zza(DataReadResult datareadresult)
    {
        this;
        JVM INSTR monitorenter ;
        Log.v("Fitness", "Received batch result");
        if (zzarB != null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        zzarB = datareadresult;
_L2:
        zzarA = zzarA + 1;
        if (zzarA == zzarB.zztn())
        {
            zzagy.zzp(zzarB);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        zzarB.zzb(datareadresult);
        if (true) goto _L2; else goto _L1
_L1:
        datareadresult;
        this;
        JVM INSTR monitorexit ;
        throw datareadresult;
    }

    private aReadResult(aReadResult areadresult)
    {
        zzarA = 0;
        zzarB = null;
        zzagy = areadresult;
    }

    zzagy(zzagy zzagy1, zzagy zzagy2)
    {
        this(zzagy1);
    }
}
