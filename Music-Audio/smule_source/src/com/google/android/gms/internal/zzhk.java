// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzhj, zzhm, zzho

public final class zzhk
    implements zzhj
{

    public zzhk()
    {
    }

    public PendingResult zzc(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzhl.zza(googleapiclient) {

            final zzhk zzUi;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
            {
                zza((zzhm)zza1);
            }

            protected void zza(zzhm zzhm1)
            {
                ((zzho)zzhm1.zzlX()).zza(new zza(this));
            }

            
            {
                zzUi = zzhk.this;
                super(googleapiclient);
            }

            private class zza extends zzhh
            {

                private final com.google.android.gms.common.api.zza.zzb zzKq;

                public void zzaW(int i)
                {
                    zzKq.zzj(new Status(i));
                }

                public zza(com.google.android.gms.common.api.zza.zzb zzb)
                {
                    zzKq = zzb;
                }
            }

        });
    }
}
