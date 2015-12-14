// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Referenced classes of package com.google.android.gms.internal:
//            zzk, zzi, zzx, zzm, 
//            zzr

class zzaH extends zzk
{

    private final zzh zzGz;
    private final zzh zzaH;

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
        zzaH.zb(zzGz.zzh(inputstream));
    }

    public _cls1.zzGB(String s, _cls1 _pcls1, _cls1 _pcls1_1)
    {
        class _cls1
            implements zzm.zza
        {

            final zzm.zzb zzGA;
            final zzho.zza zzGB;

            public void zze(zzr zzr)
            {
                zzGA.zzb(zzGB.zzft());
            }

            _cls1(zzm.zzb zzb, zzho.zza zza1)
            {
                zzGA = zzb;
                zzGB = zza1;
                super();
            }
        }

        super(0, s, new _cls1(_pcls1_1, _pcls1));
        zzGz = _pcls1;
        zzaH = _pcls1_1;
    }
}
