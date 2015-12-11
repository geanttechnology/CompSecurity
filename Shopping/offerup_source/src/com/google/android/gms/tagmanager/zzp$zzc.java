// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzmn;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbf, zzp, zzbg

class <init>
    implements zzbf
{

    final zzp zzaWq;

    public void zzCC()
    {
    }

    public void zzH(Object obj)
    {
        zzb((com.google.android.gms.internal.)obj);
    }

    public void zza( )
    {
         = zzaWq;
        ;
        JVM INSTR monitorenter ;
        if (!zzaWq.isReady())
        {
            if (zzp.zzb(zzaWq) == null)
            {
                break MISSING_BLOCK_LABEL_54;
            }
            zzaWq.zzb(zzp.zzb(zzaWq));
        }
_L2:
        zzp.zza(zzaWq, 0x36ee80L);
        return;
        zzaWq.zzb(zzaWq.zzbf(Status.zzabe));
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        ;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzb(com.google.android.gms.internal. )
    {
label0:
        {
            synchronized (zzaWq)
            {
                if (.zziR != null)
                {
                    break MISSING_BLOCK_LABEL_59;
                }
                if (zzp.zze(zzaWq).zziR != null)
                {
                    break label0;
                }
                zzbg.e("Current resource is null; network resource is also null");
                zzp.zza(zzaWq, 0x36ee80L);
            }
            return;
        }
        .zziR = zzp.zze(zzaWq).zziR;
        zzp.zza(zzaWq, , zzp.zzc(zzaWq).currentTimeMillis(), false);
        zzbg.v((new StringBuilder("setting refresh time to current time: ")).append(zzp.zzf(zzaWq)).toString());
        if (!zzp.zzg(zzaWq))
        {
            zzp.zza(zzaWq, );
        }
        zzp1;
        JVM INSTR monitorexit ;
        return;
        ;
        zzp1;
        JVM INSTR monitorexit ;
        throw ;
    }

    private (zzp zzp1)
    {
        zzaWq = zzp1;
        super();
    }

    zzaWq(zzp zzp1, zzaWq zzawq)
    {
        this(zzp1);
    }
}
