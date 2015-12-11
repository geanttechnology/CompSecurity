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

    public _cls1.zzJg(String s, _cls1 _pcls1, _cls1 _pcls1_1)
    {
        class _cls1
            implements zzm.zza
        {

            final zzm.zzb zzJf;
            final zzih.zza zzJg;

            public void zze(zzr zzr)
            {
                zzJf.zzb(zzJg.zzfF());
            }

            _cls1(zzm.zzb zzb, zzih.zza zza1)
            {
                zzJf = zzb;
                zzJg = zza1;
                super();
            }
        }

        super(0, s, new _cls1(_pcls1_1, _pcls1));
        zzJe = _pcls1;
        zzaG = _pcls1_1;
    }
}
