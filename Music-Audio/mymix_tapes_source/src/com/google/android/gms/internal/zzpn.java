// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;

public final class zzpn
    implements Account
{
    private static abstract class zza extends com.google.android.gms.plus.Plus.zza
    {

        public Result zzb(Status status)
        {
            return zzd(status);
        }

        public Status zzd(Status status)
        {
            return status;
        }

        private zza(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public zzpn()
    {
    }

    public void clearDefaultAccount(GoogleApiClient googleapiclient)
    {
        googleapiclient = Plus.zzf(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzyG();
        }
    }

    public String getAccountName(GoogleApiClient googleapiclient)
    {
        return Plus.zzf(googleapiclient, true).getAccountName();
    }

    public PendingResult revokeAccessAndDisconnect(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zza(googleapiclient) {

            final zzpn zzaLE;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zze)zzb);
            }

            protected void zza(zze zze1)
            {
                zze1.zzm(this);
            }

            
            {
                zzaLE = zzpn.this;
                super(googleapiclient);
            }
        });
    }
}
