// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.ActivityRecognitionApi;

public class zza
    implements ActivityRecognitionApi
{

    public zza()
    {
    }

    public PendingResult removeActivityUpdates(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new _cls2(googleapiclient, pendingintent));
    }

    public PendingResult requestActivityUpdates(GoogleApiClient googleapiclient, long l, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new _cls1(googleapiclient, l, pendingintent));
    }

    private class _cls2 extends zza
    {
        private class zza extends com.google.android.gms.location.ActivityRecognition.zza
        {

            public Result zzb(Status status)
            {
                return zzd(status);
            }

            public Status zzd(Status status)
            {
                return status;
            }

            public zza(GoogleApiClient googleapiclient)
            {
                super(googleapiclient);
            }
        }


        final PendingIntent zzaEY;
        final com.google.android.gms.location.internal.zza zzaEZ;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            zzl1.zza(zzaEY);
            zzb(Status.zzabb);
        }

        _cls2(GoogleApiClient googleapiclient, PendingIntent pendingintent)
        {
            zzaEZ = com.google.android.gms.location.internal.zza.this;
            zzaEY = pendingintent;
            super(googleapiclient);
        }
    }


    private class _cls1 extends zza
    {

        final long zzaEX;
        final PendingIntent zzaEY;
        final com.google.android.gms.location.internal.zza zzaEZ;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            zzl1.zza(zzaEX, zzaEY);
            zzb(Status.zzabb);
        }

        _cls1(GoogleApiClient googleapiclient, long l, PendingIntent pendingintent)
        {
            zzaEZ = com.google.android.gms.location.internal.zza.this;
            zzaEX = l;
            zzaEY = pendingintent;
            super(googleapiclient);
        }
    }

}
