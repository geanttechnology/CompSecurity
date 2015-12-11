// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzly

public final class zzlz
    implements zzly
{

    public zzlz()
    {
    }

    public final PendingResult zzb(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new _cls1(googleapiclient));
    }

    private class _cls1 extends zzma.zza
    {

        final zzlz zzagx;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
        {
            zza((zzmb)zzb1);
        }

        protected void zza(zzmb zzmb1)
        {
            ((zzmd)zzmb1.zzpc()).zza(new zza(this));
        }

        _cls1(GoogleApiClient googleapiclient)
        {
            zzagx = zzlz.this;
            super(googleapiclient);
        }

        private class zza extends zzlw
        {

            private final zzlb.zzb zzagy;

            public void zzbN(int i)
            {
                zzagy.zzp(new Status(i));
            }

            public zza(zzlb.zzb zzb1)
            {
                zzagy = zzb1;
            }
        }

    }

}
