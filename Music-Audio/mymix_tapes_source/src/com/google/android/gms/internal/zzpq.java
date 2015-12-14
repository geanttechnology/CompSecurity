// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class zzpq
    implements Moments
{
    private static abstract class zza extends com.google.android.gms.plus.Plus.zza
    {

        public com.google.android.gms.plus.Moments.LoadMomentsResult zzaY(Status status)
        {
            return new com.google.android.gms.plus.Moments.LoadMomentsResult(this, status) {

                final Status zzQs;
                final zza zzaLM;

                public MomentBuffer getMomentBuffer()
                {
                    return null;
                }

                public String getNextPageToken()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzQs;
                }

                public String getUpdated()
                {
                    return null;
                }

                public void release()
                {
                }

            
            {
                zzaLM = zza1;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaY(status);
        }

        private zza(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class zzb extends com.google.android.gms.plus.Plus.zza
    {

        public Result zzb(Status status)
        {
            return zzd(status);
        }

        public Status zzd(Status status)
        {
            return status;
        }

        private zzb(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class zzc extends com.google.android.gms.plus.Plus.zza
    {

        public Result zzb(Status status)
        {
            return zzd(status);
        }

        public Status zzd(Status status)
        {
            return status;
        }

        private zzc(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public zzpq()
    {
    }

    public PendingResult load(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zza(googleapiclient) {

            final zzpq zzaLF;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            protected void zza(zze zze1)
            {
                zze1.zzk(this);
            }

            
            {
                zzaLF = zzpq.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult load(GoogleApiClient googleapiclient, int i, String s, Uri uri, String s1, String s2)
    {
        return googleapiclient.zza(new zza(googleapiclient, i, s, uri, s1, s2) {

            final zzpq zzaLF;
            final String zzaLG;
            final Uri zzaLH;
            final String zzaLI;
            final String zzaLJ;
            final int zzauY;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            protected void zza(zze zze1)
            {
                zze1.zza(this, zzauY, zzaLG, zzaLH, zzaLI, zzaLJ);
            }

            
            {
                zzaLF = zzpq.this;
                zzauY = i;
                zzaLG = s;
                zzaLH = uri;
                zzaLI = s1;
                zzaLJ = s2;
                super(googleapiclient);
            }
        });
    }

    public PendingResult remove(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, s) {

            final zzpq zzaLF;
            final String zzaLL;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            protected void zza(zze zze1)
            {
                zze1.zzej(zzaLL);
                zza(((Result) (Status.zzaaD)));
            }

            
            {
                zzaLF = zzpq.this;
                zzaLL = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult write(GoogleApiClient googleapiclient, Moment moment)
    {
        return googleapiclient.zzb(new zzc(googleapiclient, moment) {

            final zzpq zzaLF;
            final Moment zzaLK;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            protected void zza(zze zze1)
            {
                zze1.zza(this, zzaLK);
            }

            
            {
                zzaLF = zzpq.this;
                zzaLK = moment;
                super(googleapiclient);
            }
        });
    }
}
