// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzkm

public final class zzkn
    implements zzkm
{

    public zzkn()
    {
    }

    public PendingResult zzc(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new _cls1(googleapiclient));
    }

    private class _cls1 extends zzko.zza
    {

        final zzkn zzabk;

        protected volatile void zza(com.google.android.gms.common.api.Api.Client client)
        {
            zza((zzkp)client);
        }

        protected void zza(zzkp zzkp1)
        {
            ((zzkr)zzkp1.zznM()).zza(new zza(this));
        }

        _cls1(GoogleApiClient googleapiclient)
        {
            zzabk = zzkn.this;
            super(googleapiclient);
        }

        private class zza extends zzkk
        {

            private final com.google.android.gms.common.api.zza.zzb zzOs;

            public void zzbB(int i)
            {
                zzOs.zzm(new Status(i));
            }

            public zza(com.google.android.gms.common.api.zza.zzb zzb)
            {
                zzOs = zzb;
            }
        }

    }

}
