// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzjw, zzjv

final class zzRm extends zzRm
{

    private final String zzRm;
    final zzjv zzRn;

    protected final volatile void zza(com.google.android.gms.common.api.Rm rm)
    {
        zza((zzjw)rm);
    }

    protected final void zza(zzjw zzjw1)
    {
        zzjw1.zza(new zzjx.zza() {

            final zzjv.zzc zzRp;

            public void zze(Status status)
            {
                zzRp.zzb(status);
            }

            
            {
                zzRp = zzjv.zzc.this;
                super();
            }
        }, zzRm);
    }

    protected final Result zzb(Status status)
    {
        return zzd(status);
    }

    protected final Status zzd(Status status)
    {
        return status;
    }

    public piClient(zzjv zzjv, GoogleApiClient googleapiclient, String s)
    {
        zzRn = zzjv;
        super(googleapiclient);
        zzRm = s;
    }
}
