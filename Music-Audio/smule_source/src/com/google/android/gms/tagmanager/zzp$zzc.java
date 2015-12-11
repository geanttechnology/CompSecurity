// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzht;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbf, zzp, zzbg

class <init>
    implements zzbf
{

    final zzp zzaCL;

    public void zza( )
    {
         = zzaCL;
        ;
        JVM INSTR monitorenter ;
        if (!zzaCL.isReady())
        {
            if (zzp.zzf(zzaCL) == null)
            {
                break MISSING_BLOCK_LABEL_54;
            }
            zzaCL.setResult(zzp.zzf(zzaCL));
        }
_L2:
        zzp.zza(zzaCL, 0x36ee80L);
        return;
        zzaCL.setResult(zzaCL.zzaO(Status.zzQX));
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        ;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzb(com.google.android.gms.internal.c c)
    {
label0:
        {
            synchronized (zzaCL)
            {
                if (c.zzhh != null)
                {
                    break MISSING_BLOCK_LABEL_59;
                }
                if (zzp.zzi(zzaCL).zzhh != null)
                {
                    break label0;
                }
                zzbg.zzak("Current resource is null; network resource is also null");
                zzp.zza(zzaCL, 0x36ee80L);
            }
            return;
        }
        c.zzhh = zzp.zzi(zzaCL).zzhh;
        zzp.zza(zzaCL, c, zzp.zzg(zzaCL).currentTimeMillis(), false);
        zzbg.zzam((new StringBuilder()).append("setting refresh time to current time: ").append(zzp.zzj(zzaCL)).toString());
        if (!zzp.zzk(zzaCL))
        {
            zzp.zza(zzaCL, c);
        }
        zzp1;
        JVM INSTR monitorexit ;
        return;
        c;
        zzp1;
        JVM INSTR monitorexit ;
        throw c;
    }

    public void zzv(Object obj)
    {
        zzb((com.google.android.gms.internal.c.zzb)obj);
    }

    public void zzwB()
    {
    }

    private (zzp zzp1)
    {
        zzaCL = zzp1;
        super();
    }

    zzaCL(zzp zzp1, zzaCL zzacl)
    {
        this(zzp1);
    }
}
