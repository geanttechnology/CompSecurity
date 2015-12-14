// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Referenced classes of package com.google.android.gms.internal:
//            zzk, zzi, zzx, zzm, 
//            zzr

class zzaG extends zzk
{

    private final zzh zzJe;
    private final zzh zzaG;

    protected zzm zza(zzi zzi1)
    {
        return zzm.zza(new ByteArrayInputStream(zzi1.data), zzx.zzb(zzi1));
    }

    protected void zza(Object obj)
    {
        zzj((InputStream)obj);
    }

    protected void zzj(InputStream inputstream)
    {
        zzaG.zb(zzJe.zzh(inputstream));
    }

    public _cls1.zzJg(String s, _cls1.zzJg zzjg, _cls1.zzJg zzjg1)
    {
        super(0, s, new zzm.zza(zzjg1, zzjg) {

            final zzm.zzb zzJf;
            final zzih.zza zzJg;

            public void zze(zzr zzr)
            {
                zzJf.zzb(zzJg.zzfF());
            }

            
            {
                zzJf = zzb1;
                zzJg = zza1;
                super();
            }
        });
        zzJe = zzjg;
        zzaG = zzjg1;
    }
}
